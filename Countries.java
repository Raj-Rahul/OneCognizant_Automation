package project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Countries 
{
	Random r=new Random();
	WebDriver driver=null;
	Implicitwait iw1=new Implicitwait();
	
	public Countries(WebDriver d)
	{
		driver=d;
	}
	
	public void selectCountry(String pw) throws IOException
	{
		
		
		iw1.wait(driver);
		
		//moving cursor to the scroll down frame
	    WebElement e=driver.findElement(By.xpath("//a[@class='an_a_91bed31b'][1]"));
	    Actions a=new Actions(driver);
	    a.moveToElement(e).perform();
	    
	    //scrolling to click ONECOGNIZANT icon
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    
	    //clicking one cognizant
		driver.findElement(By.xpath("//div[@data-list-index='0']")).click();
		iw1.wait(driver);

		//one_cognizant page opening in new tab
		Set<String> handles = driver.getWindowHandles();
		
		for(String h:handles)
		{
			if(!h.equals(pw))
			{
				//Switching tab
				driver.switchTo().window(h);
				driver.findElement(By.xpath("//input[@id='oneC_searchAutoComplete']")).sendKeys("GSD");
				iw1.wait(driver);
				driver.findElement(By.xpath("//div[contains(text(),'Live Support - GSD')]")).click();
				iw1.wait(driver);
				
				//Moving into the frame where country button is located
				driver.switchTo().frame("appFrame");
				driver.findElement(By.xpath("//button[@id='menu4']")).click();
				iw1.wait(driver);
				
				//Taking Screenshot
				TakesScreenshot screenshot = (TakesScreenshot)driver;
				File firstsrc = screenshot.getScreenshotAs(OutputType.FILE);
				String path=System.getProperty("user.dir")+ "\\screenshot\\captured3.png";
				FileUtils.copyFile(firstsrc, new File(path));
				
				
				//default country
				List<WebElement> l5=driver.findElements(By.xpath("//div[@class='eachTileRow']/div[@class='p-1 flex-fill']/div[@role='link']"));
				List<String> pa1=new ArrayList<String>();
				System.out.println("Data from default country");
				System.out.println("");
				
				for(int i=0;i<l5.size();i++)
				{
					String s=l5.get(i).getText();
					pa1.add(s);
					System.out.println(s);
				}
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				
				
				
				//invoking random class
				int rr=r.randomNo();
				
				//country 1
				
				//capturing all the countries name 
				
				List<WebElement> l2=driver.findElements(By.xpath("//ul[@aria-labelledby=\"menu4\"]//child::li"));
				
				
				List<String> countryName=new ArrayList<String>();
				
				for(WebElement e1:l2)
				{
					String myText=e1.getText();
					countryName.add(myText);
				}
				
				//Storing country names into Excel sheet
				Excel ex=new Excel(driver);
				ex.putData("Sheet1", countryName);
				
				WebElement ww=l2.get(rr);
				ww.click();
				
				iw1.wait(driver);
				
				
				
				List<String> pa=new ArrayList<String>();
				List<WebElement> l3=driver.findElements(By.xpath("//div[@class='eachTileRow']/div[@class='p-1 flex-fill']/div[@role='link']"));
				
				System.out.println("Data from country 1");
				System.out.println("");
				
				for(int i=0;i<l3.size();i++)
				{
					String s=l3.get(i).getText();
					pa.add(s);
					System.out.println(s);
				}
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				//country 2

				Actions a1 = new Actions(driver);
				a1.sendKeys(Keys.PAGE_UP).build().perform();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
				//driver.switchTo().frame("appFrame");
				driver.findElement(By.xpath("//button[@id='menu4']")).click();
				iw1.wait(driver);
				
				int rr1=r.randomNo();
				WebElement ww1=l2.get(rr1);
				ww1.click();
				
				List<String> pa11=new ArrayList<String>();
				List<WebElement> l4=driver.findElements(By.xpath("//div[@class='eachTileRow']/div[@class='p-1 flex-fill']/div[@role='link']"));
				
				System.out.println("Data from country 2");
				System.out.println("");
				
				for(int i=0;i<l4.size();i++)
				{
					String s=l4.get(i).getText();
					pa11.add(s);
					System.out.println(s);
				}
				
				
			}
		}
		
	}
}
