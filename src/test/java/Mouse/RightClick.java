package Mouse;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.time.Duration;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RightClick {
	
	@Test(priority=1)

	public  void rightclick() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
        
		Actions act=new Actions(driver);   //Action is predefined mouse over action
		
		//Right click action
		
		act.contextClick(button).build().perform(); //build().perform() is default method we need to put end of the statement
		
		//click on copy
		
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		
		//close alert box
		
		driver.switchTo().alert().accept();
		
	}
	
}

