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

public class Mouseoveractions {
	
	@Test(priority=1)

	public  void mouseoveractions() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.opencart.com");
		
		WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac(1)']"));
		
		Actions act=new Actions(driver);  //Actions is class and driver is parameter
	    //mouse over action
		act.moveToElement(desktops).moveToElement(mac).click().build().perform(); //buid().perform() is compulsory for action class
	   
	}

}
