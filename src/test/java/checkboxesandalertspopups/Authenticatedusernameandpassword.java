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


public class Authenticatedusernameandpassword

{
	//Handle with authenticated username and password
	
	@Test(priority=1)
	
	public void authenticatedusernameandpassword()  
	
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.get("http://the-internet.herokuapp.com/basic_auth");  //it will ask username and password to enter into application
		//syntax-http://username:password@the-internet.herokuapp.com/basic_auth
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");  //this syntax to enter directly into application- it will pass username and password and entering into application
	}
}
