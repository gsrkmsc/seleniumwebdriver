package locators;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class csslocators {
	
	@Test(priority=1)
	
	public void css() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoblaze.com/");
		
		//tag and id syntax: tag#id
		driver.findElement(By.cssSelector("input#nava")).click(); //css locator Tagname#id
		//driver.findElement(By.cssSelector("#nava")).click();   //css locator without tagname
		
		//tag class  syntax: tag.classname
		
		//driver.findElement(By.cssSelector("a.hrefch")).click(); //css locator Tag.classname
		//driver.findElement(By.cssSelector(".hrefch")).click();    //css locator with.classname
		
		//tag attribute  syntax: tag[attribute="value"]
		
		//driver.findElement(By.cssSelector("a[onClick=byCat('phone')]")).click();   //css locator with tag and attribute
		//driver.findElement(By.cssSelector("[onClick=byCat('phone')]")).click();
	 
		//tag class attribute syntax: tag.classname[attribute='value']
		
		driver.findElement(By.cssSelector("a.nav-link[data-toggle='modal']"));  //css locator with tag.classname[attribute='value]
		//driver.findElement(By.cssSelector(".nav-link[data-toggle='modal']"));    //without tag
		
	}
	

}
