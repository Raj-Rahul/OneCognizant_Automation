package project;

import java.util.*;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class GetLanguage {
	WebDriver driver=null;

	Implicitwait iw1=new Implicitwait();
	
	public GetLanguage(WebDriver d)
	{
		driver=d;
	}

	public List<String> start(String pw) throws IOException, InterruptedException
	{
		List<String> b=new ArrayList<String>();
		iw1.wait(driver);
		
		//Move mouse cursor to random element to activate scrolldown functionality
	    WebElement e=driver.findElement(By.xpath("//a[@class='an_a_91bed31b'][1]"));
	    
	    //action class helps to perform mouse funtionality 
	    Actions a=new Actions(driver);
	    a.moveToElement(e).perform();
	    
	    //Scrolling page down to find the element
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    
	    //clicking one cognizant
		driver.findElement(By.xpath("//div[@data-list-index='0']")).click();
		iw1.wait(driver);
		
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String h:handles)
		{
			if(!h.equals(pw))
			{
				driver.switchTo().window(h);
				driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).sendKeys("GSD");
				iw1.wait(driver);
				driver.findElement(By.xpath("//div[contains(text(),'Live Support - GSD')]")).click();
				iw1.wait(driver);
				
				//creating object for language class
				Language l=new Language(driver);
				b=l.selectLang();
				
				
				
				//driver.switchTo().frame("appFrame");
				
				//Validating Welcome message
				WebElement f = driver.findElement(By.xpath("//p[@class='Welcome-automated-text']"));
				WebElement s = driver.findElement(By.xpath("//p[@class='LiSA-help-text']"));
				System.out.println(f.getText());
				System.out.println(s.getText());
				Assert.assertEquals(f.getText(),"Welcome to the all-in-one Live Support!");
				Assert.assertEquals(s.getText(),"Check FAQs. Chat with an agent. Submit and track tickets.");
				
				
				driver.close();
				
			}
		}
		return b;
	}
	

}
