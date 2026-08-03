package navigationalcommands;

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

public class HandlemultipleBrowserWindows 
{
	
	
	@Test(priority=1)
	
	public void handlemultibrowserwindows()
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://www.valuelabs.com");  
		driver.switchTo().newWindow(WindowType.TAB); //opening new tab
		driver.get("https://www.youtube.com");   //entering the url in new tab
		
		Set<String> WindowIDs=driver.getWindowHandles();
		
		//Approach1
		
		/*List<String> windowList=new ArrayList(WindowIDs);
		String parentID=windowList.get(0);
		String childID=windowList.get(1);
		
		System.out.println(driver.getTitle());
		
		//switch to parent window
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		
		//switch to child window
		
		driver.switchTo().window(childID);
		System.out.println(driver.getTitle());
		*/
		
		//Approach2
		
		for(String windID:WindowIDs)
		{
			String title=driver.switchTo().window(windID).getTitle();
			
			if (title.equals("YouTube"))
			{
				System.out.println(driver.getCurrentUrl());
				
			}
			
		}
	}

}
