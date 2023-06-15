package project;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport 
{
	Object a;
	ExtentTest et;
	
	public Extentreport()
	{
		ExtentReports extent=new ExtentReports();
		a=extent;
		ExtentSparkReporter sp=new ExtentSparkReporter("Report.html");
		((ExtentReports) a).attachReporter(sp);
	}
	
	public void TestName(String b)
	{
		et=((ExtentReports) a).createTest(b);
	}
	
	public void logs(String b)
	{
		et.log(Status.INFO, b);
	}
	
	public void Flush() throws IOException
	{
		((ExtentReports) a).flush();
		//Desktop.getDesktop().browse(new File("Report.html").toURI());
	}
	
}
