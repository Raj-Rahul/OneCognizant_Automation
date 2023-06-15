package project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class Implicitwait {
	
WebDriver driver=null;
	
	public void wait(WebDriver d)
	{
		driver=d;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}

}
