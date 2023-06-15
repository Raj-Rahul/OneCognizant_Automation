package project;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Language
{
	WebDriver driver=null;
	
	
	public Language(WebDriver d)
	{
		driver=d;
	}
	
	public List<String> selectLang() throws IOException
	{
				
		//Switching to frame
		List<String> a = new ArrayList<String>();
		driver.switchTo().frame("appFrame");
		driver.findElement(By.xpath("//button[@id='menu3']")).click();
		
		//Taking Screenshot
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File firstsrc = screenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+ "\\screenshot\\captured2.png";
		FileUtils.copyFile(firstsrc, new File(path));
		
		//getting language
		List<WebElement> l=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu langList show\"]"));
		for(int i=0;i<l.size();i++)
		{
			String s1=l.get(i).getText();
			a.add(s1);
			System.out.println(s1);
		}
		return a;
	}
}
