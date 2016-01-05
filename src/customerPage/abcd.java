//	package customerPage;
//	
//	import org.openqa.selenium.WebDriver; 
//	import org.openqa.selenium.firefox.FirefoxDriver;
//	import org.testng.Assert;
//	import org.testng.annotations.Test;
//	import com.opera.core.systems.scope.services.Exec;
//	import com.relevantcodes.extentreports.ExtentReports;
//	import com.relevantcodes.extentreports.LogStatus;
//	import com.relevantcodes.extentreports.ExtentTest;
//	import com.relevantcodes.extentreports.NetworkMode;
//	import com.relevantcodes.extentreports.ReporterType;
//	import com.relevantcodes.extentreports.LogStatus;
//	import java.util.logging.Logger;
//	
//	public class abcd {
//	
//		public static WebDriver driver=new FirefoxDriver();
//		private static Logger Log = Logger.getLogger(Customer.class.getName());
//	     @Test
//	     public void verifySeleniumBlog(){
//	           // Create object of extent report and specify the Class name in get method
//	 
//	           // in my case I have used AdvanceReporting.class
//	 
//	          ExtentReports logger=ExtentReports.get(abcd.class);
//	           // Call init method and specify the location where you want to save this report
//	 
//	           // second parameter is set to true it means it will overwrite report with new one
//	 
//	          logger.init("/Users/user/Downloads/myreport.html", true);
//	 
//	 
//	 
//	           // Start Test
//	 
//	          logger.startTest("Verify Page Title");
//	 
//	 
//	 
//	 
//	 
//	           // Start browser
//	 
//	           WebDriver driver=new FirefoxDriver();
//	 
//	           driver.manage().window().maximize();
//	 
//	           logger.log(LogStatus.INFO, "Browser started");
//	 
//	 
//	 
//	           // Open application
//	 
//	           driver.get("http://learn-automation.com");
//	 
//	           logger.Log(LogStatus.INFO, "Navigated to www.learn-automation.com");
//	 
//	 
//	 
//	           // get title
//	 
//	           String title=driver.getTitle();
//	 
//	           logger.log(LogStatus.INFO, "Get the current title");
//	 
//	 
//	 
//	           // Verify title
//	 
//	            Assert.assertTrue(title.contains("Selenium"));
//	            logger.log(LogStatus.PASS, "Title verified");
//	            logger.attachScreenshot("/Users/user/Downloads/Model.jpg"); 
//	            driver.quit();
//	 
//	            logger.log(LogStatus.INFO, "Browser closed");
//	 
//	           
//	 
//	            logger.endTest(null);
//	 
//	      }
//	 
//	 
//	 
//	}