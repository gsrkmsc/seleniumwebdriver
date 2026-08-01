package wait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebDriver;

public class Implicitwait {
	
	@Test(priority=1)
	public void implicitwait() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10)); //implicit wait declaration
		
		
		driver.get("https://www.valuelabs.com");
		driver.manage().window().maximize();
		
		
		//driver.findElement(By.xpath("//a[@class='nav-link']")).click();
		
		WebElement contactus = driver.findElement(By.xpath("//a[@class='nav-link']"));
        contactus.click();
		//driver.close(); //it will close driver instance
	}

}
