package Tables;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.util.List;


public class StaticTable {
	
	@Test(priority=1)
	 
	 public void statictable()
	 
	 {
		WebDriver driver=new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 driver.manage().window().maximize();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 
		 //find total no of rows in a table
		 
		 int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();	//particular table to capture no of rows
		 
		//int tablerows=driver.findElements(By.tagName("tr")).size(); //another method when single table in a webpage
		 System.out.println("Number of rows are " +rows);
		 
		 //find no of columns in a table
		 
		
		   int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		 
		 //int tablecols=driver.findElements(By.tagName("tr")).size();  //another method when single table in a webpage
		 System.out.println("Number of columns are " +cols);
		 
		 //Read data froms specific row and column
		 
		 String bookname=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
	     System.out.println(bookname);  
	     
	     //read the data from all rows and columns
	     
	     for(int r=2;r<=rows;r++)
	     {
	    	 for(int c=1;c<=cols;c++)
	    	 {
	    		 String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();  //we can not store r value c value and syntax is "+r+" 
	    	 
	    		 System.out.println(value+ "\t"); // \t is java command to maintain one space
	    	 
	    	 }
	     }
	 
	     //to find the book with specific author
	     
	 //  to find out particular Author search:
	     for(int r=2; r<=rows; r++)
	     {
	         String Authorname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText(); // Changed to td[2]
	         if(Authorname.equals("Mukesh"))
	         {
	             String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
	             System.out.println("Book Name is " + book);
	         }
	     }
	     
	     // to know the price of the book
	     
	     int total=0;
	     
	     for(int r=2; r<=rows; r++)
	     {
	         String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText(); // Changed to td[2]
	         total=total+Integer.parseInt(price);
	     }
	     
	     System.out.println("Total Price of the books "+total);

	 }

}
