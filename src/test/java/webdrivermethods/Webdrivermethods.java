package webdrivermethods;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebDriver;

public class Webdrivermethods {
	@Test(priority=1)
	
	public void getmethods()
	
	{
		WebDriver driver=new ChromeDriver();
		//get URL
		driver.get("https://youtube.com");
		driver.manage().window().maximize();
		//title of the page
		String title=driver.getTitle();  //storing in a variable
		System.out.println("Title of the page is "+title);
		//get current url
		String currenturl=driver.getCurrentUrl(); //storing in a variable
		System.out.println("Current URL is "+currenturl);
		//get page source
		//String pagesource=driver.getPageSource();
		//System.out.println("Pagesource is "+pagesource);
		//getwindowhandle-returns ID of single browser window
		String windowid=driver.getWindowHandle();   //ID will change dynamically
		System.out.println("window ID is "+windowid);
		
		//getwindowhandles()- return ID's of the multiple browser windows
		driver.switchTo().newWindow(WindowType.TAB); //it will open new tab
		driver.get("https://www.google.com");
		Set<String> windowids=driver.getWindowHandles(); //set is return of type of strings and window id's are unique
		System.out.println("window ID's are "+windowids);
		driver.close(); //it will close current windows only
		//driver.quit(); //to close all the browser windows at a time
		
	}
	

}

