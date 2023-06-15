package project;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class credentials 
{
	WebDriver driver=null;
	
	List<String> ud=new ArrayList<String>();
	
	public credentials(WebDriver d)
	{
		driver=d;
	}
	
	public List<String> UserDetails()
	{
		driver.findElement(By.xpath("//div[@id='O365_MainLink_MePhoto']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		String name=driver.findElement(By.id("mectrl_currentAccount_primary")).getText();
		String email=driver.findElement(By.xpath("//div[@id='mectrl_currentAccount_secondary']")).getText();
		
		ud.add(name);
		ud.add(email);
		
		System.out.println(ud);
		
		return ud;

	}
	
}
