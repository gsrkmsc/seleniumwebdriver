package checkboxesandalertspopups;
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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WindowType;

public class Checkboxes

{
	
	
	@Test(priority=1)
	
	public void checkboxex() throws InterruptedException
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://testautomationpractice.blogspot.com/"); 
		//select specific checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//to select all the checkboxes
		List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		//Normal for loop
		/*for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		*/
		//enhanced for loop
		/*for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
		*/
		//select last 3 checkboxes
		//formula:total no of checkboxes-how many checkboxes want to select=starting index
		//7-3=4(starting index)
		/*for(int i=4;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		*/
		//first 3 checkboxes
		/*for(int i=0;i<3;i++)
		{
			checkboxes.get(i).click();
		}
		*/
		//unselected the checkboxes
		for(int i=0;i<3;i++)  //selecting the checkboxes
		{
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for(int i=0;i<checkboxes.size();i++)  //uncehcking
		{
			if(checkboxes.get(i).isSelected());
			{
				checkboxes.get(i).click();
			}
		}
		
	}
	
	}
