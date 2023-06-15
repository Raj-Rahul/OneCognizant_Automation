package project;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

public class main {
	
	public static WebDriver driver;
	Implicitwait iw=new Implicitwait();
	Extentreport er=new Extentreport();
	@BeforeClass
	public void before()
	{
		System.out.println("Report will generate after all the test cases are executed:");
	}
	
	@BeforeMethod
	@Parameters("browser")
	public void setDriver(@Optional("chrome")String browser) throws InterruptedException
	{
		Driver dd=new Driver();
		driver=dd.d(browser);
	}
	
	@Test (enabled=true,priority=1)
	public void test1() throws IOException 
	{	
		//adding name to extent report
		er.TestName("Verifying User Information");
		
		//adding log to extent report
		er.logs("Open browser");
		
		//Creating object for credetials class
		credentials c=new credentials(driver);
		
		er.logs("On User details page");
		List<String> ud=c.UserDetails();
		
		//Verifying the credentials of the user, using assertion method
		Assert.assertEquals(ud.get(0),"Raj, Rahul (Contractor)");
		er.logs("User name is verified");
		Assert.assertEquals(ud.get(1),"2263071@cognizant.com");
		er.logs("User email is verified");
		
		//Taking Screenshot
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File firstsrc = screenshot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+ "\\screenshot\\captured1.png";
		FileUtils.copyFile(firstsrc, new File(path));
	}
	
	@Test (enabled=true,priority=2)
	public void test2() throws IOException, InterruptedException 
	{
		er.TestName("Getting Details 1");
		String parentwindow=driver.getWindowHandle();
		er.logs("Taking the parent window handle value");
		
		//Creating object for GetLanguage class
		GetLanguage gl=new GetLanguage(driver);
		iw.wait(driver);
		er.logs("Opening the browser");
		er.logs("Moving to another tab");
		er.logs("Inputs");
		
		        

		
		List<String> a=gl.start(parentwindow);
		
			}
	
	@Test (enabled=true,priority=3)
	public void test3() throws IOException
	{
		er.TestName("Getting Details 2");
		String parentwindow=driver.getWindowHandle();
		er.logs("Taking the parent window handle value");
		
		//Creating object for Countries class
		Countries c=new Countries(driver);
		er.logs("Opening the browser");
		er.logs("Clicking buttons");
		c.selectCountry(parentwindow);
		er.logs("Extracting data");
		
		
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}
	
	@AfterClass
	public void after() throws IOException
	{
		er.Flush();
	}
}
