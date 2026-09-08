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

public class Slider {
	
	@Test(priority=1)

	public  void draganddrop() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.navigate().to("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");

	    //capturing the x,y coordinates of the minimum slider
		
		WebElement min_slider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
)
	   
	
	
	
	
	}
}