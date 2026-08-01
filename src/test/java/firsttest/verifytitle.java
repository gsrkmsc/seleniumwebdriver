package firsttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifytitle {

    @Test
    public void verifyYouTubeTitle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "YouTube", "Testcase failed - title mismatch");

        System.out.println("Testcase is Passed");
        driver.quit();
    }
}