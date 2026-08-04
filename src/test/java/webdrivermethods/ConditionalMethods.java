package webdrivermethods;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.WebDriver;


public class ConditionalMethods {
	
	@Test(priority=1)
	public void conditionalmethods()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //explicit wait
		driver.manage().window().maximize();
		driver.get("https://youtube.com");
		//Is Displayed or not
		//WebElement logo=driver.findElement(By.xpath("//ytd-topbar-logo-renderer[@id='logo']//img"));
		//System.out.println("Display status of logo "+logo.isDisplayed());
		boolean status=driver.findElement(By.xpath("//button[@title='Search']//div")).isDisplayed();
		System.out.println("Display search icon "+status);
		//Is Enabled
		boolean statusenabled=driver.findElement(By.xpath("//button[@title='Search']//div")).isEnabled();
		System.out.println("search is enabled "+statusenabled);
		//Is Selected
		boolean selected=driver.findElement(By.xpath("//yt-formatted-string[normalize-space()='Home']")).isSelected();
		System.out.println("Home is selected "+selected);
		
		
		
	}

}
