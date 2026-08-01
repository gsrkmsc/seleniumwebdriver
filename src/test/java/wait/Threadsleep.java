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

public class Threadsleep {
	
	@Test(priority=1)
	public void threadsleep() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		
		
		
		driver.get("https://www.valuelabs.com");
		driver.manage().window().maximize();
		Thread.sleep(5000); // pauses for exactly 5 seconds, no matter what
		
		driver.findElement(By.xpath("//a[@class='nav-link']")).click();
		
		
		
	}

}