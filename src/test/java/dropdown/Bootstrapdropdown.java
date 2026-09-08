package dropdown;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;

public class Bootstrapdropdown {
	
	@Test(priority=1)
    public void bootstrap() {
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        
        driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
        
        //select single options
        driver.findElement(By.xpath("//input[@value='Java']")).click();
        
        //capture all the options and find out the size
        
        List<WebElement> options=driver.findElements(By.xpath("ul[contains(@class,'multiselect')]//label"));
        System.out.println("Number of options are " + options.size());
        
        // Printing the options from the drop down
        
        //enhanced for loop
        
        for(WebElement op:options)
        {
        	System.out.println(op.getText());
        }
        
        //select multiple options
        

        for(WebElement op:options)
        {
        	
        	if(op.getText().equals("Java") || op.getText().equals("sql"));
        	{
        		op.click();
        	}
        }
        
       
     
        
	}

}
