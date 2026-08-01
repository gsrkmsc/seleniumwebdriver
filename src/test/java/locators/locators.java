package locators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class locators {
	
	@Test(priority=1)

	public  void verifylocators() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		//name
		
		//driver.findElement(By.name("search_query")).sendKeys("prasadtechintelugu");
		
		//id
		
        //boolean logoDisplaystatus=driver.findElement(By.id("logo-icon")).isDisplayed();
        //System.out.println(logoDisplaystatus);
		
		//linktext & Partiallinktext
		//driver.findElement(By.linkText("Shorts")).click(); //linktext
		//driver.findElement(By.partialLinkText("Short")).click(); //partiallinktext
		
		//tagname
		//List<WebElement>links=driver.findElements(By.tagName("a"));  //tagname <a>
		//System.out.println("total number of links:"+links.size());
		
		//tagname with img
		
		List<WebElement>images=driver.findElements(By.tagName("img"));
		System.out.println("total number of images:"+images.size());   //size is count of elements
		
		//tagname with a
		
		//List<WebElement>links=driver.findElements(By.tagName("a"));
		//System.out.println("total number of links:"+links.size());
	}
		
		

}
