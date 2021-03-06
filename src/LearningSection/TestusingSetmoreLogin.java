package LearningSection;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.sun.corba.se.impl.util.Utility;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailException;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import appModule.openbrowser;
//import appModule.signout;
//import Utility.Constant;
//import Utility.Reporter;

import Utility.Constant;
import Utility.CreateScreenshot;
import Utility.EmailReport;
import appModule.signout;
import logins.Log4j;

public class TestusingSetmoreLogin {

	ExtentReports report;
	ExtentTest logger1;
	WebDriver driver;
	// private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	@BeforeTest
	public void login()

	{
		report = new ExtentReports("/Users/user/Downloads/Xslt_reports/Page1.html");
		logger1 = report.startTest("Report Results");
		// ExtentReports extent = new
		// ExtentReports("/Users/user/Downloads/extentreports-java-v2.41.1/Reports.json",true);
		Log.info("Web application launched");
		System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/Office/EclipseRD/geckodriver");
		driver = new FirefoxDriver();
		driver.get(Constant.URL);
		Log.info("Singin started");
		Log.info("Implicit wait applied on the driver for 30 seconds");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// CreateScreenshot.snap(driver, "OpenBrowser");
	}

	@Test(priority=1)
	public void SetmoreLogin()

	{
		Log.info("Input SetMore Login Fields");
		driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath(".//*[@id=\"Login_Form_id\"]/div/div[2]/div[1]/ul[1]/li[5]/div[3]/input")).click();
		// CreateScreenshot.snap(driver,"loggedina");
	}
	

	@Test(priority=2)
	public void Logout()

	{
		signout.Execute(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws EmailException

	{
		if (result.getStatus() == ITestResult.FAILURE)

		{
			String screenshot = CreateScreenshot.snap(driver, result.getName());
			String image = logger1.addScreenCapture(screenshot);
			logger1.log(LogStatus.FAIL, "Result verification", image);
			EmailReport.SendEmail();
		}

		report.endTest(logger1);
		report.flush();

		driver.get("/Users/user/Downloads/Xslt_reports/Page1.html");
	}
	
		
	
}
