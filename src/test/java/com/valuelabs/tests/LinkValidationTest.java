package com.valuelabs.tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Launches the browser, navigates to https://www.valuelabs.com/,
 * and verifies that every link found on the page is reachable.
 *
 * Driver management is handled automatically by Selenium Manager
 * (bundled with Selenium 4.6+), so no separate driver binary or
 * WebDriverManager dependency is required.
 *
 * Results are reported through Allure (see allure-results / Allure report).
 */
@Epic("ValueLabs Website")
@Feature("Homepage Link Validation")
public class LinkValidationTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://www.valuelabs.com/";

    // Domains known to block automated / headless HTTP requests (e.g. via Cloudflare / anti-bot
    // protection) and would otherwise show up as false failures.
    private static final List<String> BOT_PROTECTED_DOMAINS = Arrays.asList(
            "twitter.com",
            "x.com",
            "facebook.com"
    );

    private static final int TIMEOUT_MS = 10000;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Story("Page loads successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Launches Chrome, navigates to the ValueLabs homepage, and verifies the page title is present.")
    public void verifyPageTitle() {
        navigateToHomePage();
        String title = driver.getTitle();
        attachText("Page Title", title);
        Assert.assertNotNull(title, "Page title should not be null");
        Assert.assertFalse(title.trim().isEmpty(), "Page title should not be empty");
    }

    @Test(dependsOnMethods = "verifyPageTitle")
    @Story("All homepage links are reachable")
    @Severity(SeverityLevel.NORMAL)
    @Description("Collects every link on the ValueLabs homepage and verifies each one returns a non-error HTTP status.")
    public void verifyAllLinksAreWorking() {
        navigateToHomePage();

        Set<String> links = collectLinks();
        attachText("Total Unique Links Found", String.valueOf(links.size()));

        List<String> brokenLinks = new ArrayList<>();
        List<String> skippedLinks = new ArrayList<>();

        for (String link : links) {
            if (isBotProtected(link)) {
                skippedLinks.add(link);
                continue;
            }

            int statusCode = checkLink(link);
            if (statusCode == -1 || statusCode >= 400) {
                brokenLinks.add(link + " [status: " + statusCode + "]");
            }
        }

        attachText("Link Validation Summary",
                "Total links checked : " + links.size() + "\n"
                        + "Skipped (bot-protected): " + skippedLinks.size() + "\n"
                        + "Broken links found   : " + brokenLinks.size() + "\n\n"
                        + (brokenLinks.isEmpty() ? "" : "Broken link details:\n  - " + String.join("\n  - ", brokenLinks)));

        Assert.assertTrue(brokenLinks.isEmpty(),
                "Found " + brokenLinks.size() + " broken link(s): " + brokenLinks);
    }

    @Step("Navigate to {BASE_URL}")
    private void navigateToHomePage() {
        driver.get(BASE_URL);
    }

    @Step("Collect all unique links from the page")
    private Set<String> collectLinks() {
        List<WebElement> anchorElements = driver.findElements(By.tagName("a"));
        Set<String> links = new LinkedHashSet<>();
        for (WebElement anchor : anchorElements) {
            String href = anchor.getAttribute("href");
            if (href != null && !href.trim().isEmpty()
                    && !href.startsWith("mailto:")
                    && !href.startsWith("tel:")
                    && !href.startsWith("javascript:")) {
                links.add(href.trim());
            }
        }
        return links;
    }

    @Step("Check link: {link}")
    private int checkLink(String link) {
        return getStatusCode(link);
    }

    /**
     * Sends a HEAD request first (cheaper); falls back to GET if the server
     * does not support HEAD (some servers return 405/501 for HEAD requests).
     */
    private int getStatusCode(String urlString) {
        int status = sendRequest(urlString, "HEAD");
        if (status == 405 || status == 501 || status == -1) {
            status = sendRequest(urlString, "GET");
        }
        return status;
    }

    private int sendRequest(String urlString, String method) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setConnectTimeout(TIMEOUT_MS);
            connection.setReadTimeout(TIMEOUT_MS);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 "
                            + "(KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            return -1;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private boolean isBotProtected(String url) {
        for (String domain : BOT_PROTECTED_DOMAINS) {
            if (url.contains(domain)) {
                return true;
            }
        }
        return false;
    }

    @Attachment(value = "{name}", type = "text/plain")
    private String attachText(String name, String content) {
        return content;
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus() && driver != null) {
            takeScreenshot();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
