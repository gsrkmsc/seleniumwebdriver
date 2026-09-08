package Mouse;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.Duration;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DoubleClick {
	
	@Test(priority=1)

	public  void doubleclick() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		
		//switch to frame
		
		driver.switchTo().frame("iframeResult"); //passing iframe id
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']")); 
		
		
		
		box1.clear(); //clears the box
		box1.sendKeys("Welcome");
		
		//Double click action on the button
		
		Actions act=new Actions(driver);
		act.doubleClick(button).build().perform();
		
		//validation of copied text in box2
		
		if (box2.getAttribute("value").equals("Welcome"))  //instead of getText() we can use getAttribue(value)
		{
			System.out.println("Text Copied");
		}
			
		else
		{
			System.out.println("Text not Copied");
		}

	}
}
