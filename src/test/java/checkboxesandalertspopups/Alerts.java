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

public class Alerts

{
	
	
	@Test(priority=1)
	
	public void alerts() throws InterruptedException 
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Normal alert with ok Button
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();  //switch to alert window and with accept it will close
	   Alert myalert=driver.switchTo().alert(); //storing alert in Alert variable
	   System.out.println(myalert.getText());  //it will get text from the alert
	   myalert.accept(); //it will close the myalert
	   
	   //confirmation alert-ok & cancel button
	   
	   driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	   Thread.sleep(5000);
	   
	   //closing
	   driver.switchTo().alert().accept();  //close alert using ok button
	   
	   driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
	   Thread.sleep(5000);
	   
	   //cancel
	   driver.switchTo().alert().dismiss(); //close alert using cancel button
	   
	   //prompt alert-input box
	   
	   driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	   Thread.sleep(5000);
	   
	   //passing text and ok with accept
	   
	   Alert mypromptalertok=driver.switchTo().alert();
	   
	   mypromptalertok.sendKeys("welcome");
	   driver.switchTo().alert().accept(); //clicking on ok button
	   
	   driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
	   Thread.sleep(5000);
       //passing text and cancel with dismiss
	   
	   Alert mypromptalertcancel=driver.switchTo().alert();
	   mypromptalertcancel.sendKeys("welcome");
	   driver.switchTo().alert().dismiss(); //clicking on cancel button
	   
	   
	   
	   
	   
	}
	
	
	}
