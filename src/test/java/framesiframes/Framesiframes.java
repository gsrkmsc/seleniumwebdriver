package framesiframes;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Framesiframes {
	
	@Test(priority=1)

	public  void verifylocators() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		//frame1
		WebElement frame1=driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));  //initiating to frame1
		
		driver.switchTo().frame(frame1); //passed frame as webelement and switch to frame1
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("welcome");
		
		//going back to default page
		
		driver.switchTo().defaultContent();
		
		//frame2
		
        WebElement frame2=driver.findElement(By.xpath("//frameset//frameset//frame[1]"));  //initiating to frame2
		
		driver.switchTo().frame(frame2); //passed frame as webelement and switch to frame1
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("selenium");
		
		//going back to default page
		
		driver.switchTo().defaultContent();
		
		
		//Frame3-iframe
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));  //initiating to frame3
		
		driver.switchTo().frame(frame3); //passed frame as webelement and switch to frame1
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("java");
		
		//now interacting iframe in frame3
		
		driver.switchTo().frame(0); //switching to iframe with index
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		
		//again switch to main page
		driver.switchTo().defaultContent();		
	}
}
