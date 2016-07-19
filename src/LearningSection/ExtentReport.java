package LearningSection;
import java.awt.Frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;
import Utility.CreateScreenshot;
import junit.framework.Assert;
public class ExtentReport

{
	 ExtentReports report;
	 ExtentTest logger1;
	 WebDriver driver;
	 


	@Test
	public void verifyTitle(){
		
	
   report = new ExtentReports("/Users/user/Downloads/Xslt_reports/Page.html");
   logger1 =report.startTest("Test1verifyblogtitle");

		driver = new FirefoxDriver();
		
		logger1.log(LogStatus.INFO, "Browser started");
	   	driver.manage().window().maximize();	
	    driver.get("http://learn-automation.com");
	    String title=driver.getTitle();
	    Assert.assertTrue(title.contains("google"));
	    
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	
	{
		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			CreateScreenshot.snap(driver,result.getName());
//		}
			
		{
			String path=CreateScreenshot.snap(driver, result.getName());
			String image= logger1.addScreenCapture(path);
			logger1.log(LogStatus.FAIL,"Title verification", image);
		}
	
	report.endTest(logger1);
	report.flush();
	
	driver.get("/Users/user/Downloads/Xslt_reports.html");
	}
}
