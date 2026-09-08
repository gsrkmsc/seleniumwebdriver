package dropdown;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class GoogleAutosuggesition {
	
	 @Test(priority=1)
	 
	 public void autosuggesition() throws InterruptedException
	 {
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.get("http://www.google.com");
		 
		 driver.manage().window().maximize();
		 
		 driver.findElement(By.name("q")).sendKeys("selenium"); //searchbox
		 Thread.sleep(5000);
		 
		 List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		 
		 System.out.println(list.size());
		 
		 for(int i=0;i<list.size();i++)
		 {
			 System.out.println(list.get(i).getText());
			 
			 if(list.get(i).getText().equals("Selenium"))
			 {
				 list.get(i).click();
				 break;
			 }
		 }
	 }
	 

}
