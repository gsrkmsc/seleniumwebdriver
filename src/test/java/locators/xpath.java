package locators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpath {
	
	@Test(priority=1)
	
	public  void xpath() {
		
		
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://www.amazon.in/");
	//aboslute xpath
	//driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("tshirts");
	//relative xpath
	//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	//xpath with text only not using any attribute
	//driver.findElement(By.xpath("a[text()='Bestsellers']")).click();
	//text
	driver.findElement(By.xpath("//span[text()='© 1996-2026, Amazon.com, Inc. or its affiliates']")).isDisplayed();
	driver.close();

	}
}
