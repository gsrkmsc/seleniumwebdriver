package checkboxesandalertspopups;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Handlealertusingexplicitwait

{
	//Handle alert by using explicit wait without driver.switchTo().alert()
	
	@Test(priority=1)
	
	public void alertsusingexplicitwait() throws InterruptedException 
	
	{
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));  //explictwait
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Normal alert with ok Button
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		
		Alert myalerts=mywait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(myalerts.getText());
		myalerts.accept();
		
		
		
	}
	

}
