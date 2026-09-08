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

public class DragandDrop {
	
	@Test(priority=1)

	public  void draganddrop() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.navigate().to("https://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

		
		Actions act=new Actions(driver);  //Actions is mouse operations and driver is parameter
		
		WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));
        
        //drag and drop
        
        act.dragAndDrop(rome, italy).build().perform(); //it will draganddrop
	  
	}
}

