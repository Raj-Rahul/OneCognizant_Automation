package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver 
	{
		public WebDriver d(String browser) throws InterruptedException
			{
				WebDriver rj=null;
				
				if(browser.equalsIgnoreCase("Chrome"))
				{
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					
					//System.setProperty("webdriver.chrome.driver","C:\\Users\\2263071\\Downloads\\chromedriver_win32 (1)");
					rj=new ChromeDriver(options);
					rj.manage().window().maximize();
					rj.get("https://be.cognizant.com/");
					Thread.sleep(35000);
					return rj;
				}
				    //System.setProperty("webdriver.chrome.driver","C:\\Users\\2263071\\Downloads\\chromedriver_win32 (1)");
						rj=new EdgeDriver();
						rj.manage().window().maximize();
						rj.get("https://be.cognizant.com/");
						Thread.sleep(20000);
						return rj;
			}
	}
