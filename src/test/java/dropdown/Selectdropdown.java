package dropdown;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;


public class Selectdropdown {

    @Test(priority=1)
    public void selectdropdown() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));   //selecting the drop down and storing in a variable
        Select countryoptions = new Select(country);  // creating countryoptions object to select the options from the drop down
        
        //selectby visible text
        //countryoptions.selectByVisibleText("France");
        
        //selectby value
        
        //countryoptions.selectByValue("japan");
        
        //select by index
        
        //countryoptions.selectByIndex(2);
        
        //capture the options from drop down
        List<WebElement>options=countryoptions.getOptions();
        System.out.println("Total number of options "+options.size());
    
       //printing the options
        //classic for loop
        
       /* for(int i=0;i<options.size();i++)
        {
        	System.out.println(options.get(i).getText());        
        	
        	}
        	*/
        
        //enhanced for loopt
        
        for(WebElement op:options)
        {
        	System.out.println(op.getText());
        }
    
    
    }
}
