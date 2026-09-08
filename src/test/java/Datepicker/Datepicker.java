package Datepicker;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;


public class Datepicker {
	
	
	//@Test(priority=1)
	public void testDatePickerinput() {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	
	//switch to frame
	
	driver.switchTo().frame(0);  //as index only one
	
	//using sendkeys
	//java
	
	driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("09/07/2026");
	}
	
	@Test(priority=2)
	public void testDatePicker() 
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://jqueryui.com/datepicker/");
	driver.manage().window().maximize();
	
	//switch to frame
	
	driver.switchTo().frame(0);  //as index only one
	
	//using datepicker
	//expected data
	String year="2026";
	String month="October";
	String date="7";
	
	driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	
	//select current month & year
	
	while(true)
	{
		String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); //it will capture actual month
	    String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();  //it will capture the current year
	
	    if(currentMonth.equals(month) && currentYear.equals(year))
	    {
	    	break;
	    }
	    
	    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
	    }
	
	//select the date
	List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	
	for(WebElement dt:allDates)
	{
		if(dt.getText().equals(date))
		{
			dt.click();
			break;
		}
	}
}

}
