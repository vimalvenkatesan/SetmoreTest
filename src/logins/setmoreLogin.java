package logins;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import Utility.Constant;
import Utility.EmailReport;
import Utility.Reporter;
import appModule.signout;
import pageObjects.SetmoreLoginPage;

@Listeners(Reporter.class)
public class setmoreLogin {

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	@BeforeTest
	public void login()

	{
		// ExtentReports extent = new
		// ExtentReports("/Users/user/Downloads/extentreports-java-v2.41.1/Reports.json",true);
		Log.info("Lets Login");

		System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/Office/EclipseRD/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Utility.CreateScreenshot.snap(driver, "OpenBrowser");
	}

	@Test
	public void SetmoreLogin()

	{
		Log.info("Input SetMore Login Fields");
		driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath(".//*[@id=\"Login_Form_id\"]/div/div[2]/div[1]/ul[1]/li[5]/div[3]/input")).click();
		
	}

	@AfterTest
	public void Logout()

	{
		signout.Execute(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws EmailException {
		if (ITestResult.SUCCESS == result.getStatus()) {
			Utility.CreateScreenshot.snap(driver, result.getName());
			EmailReport.SendEmail();
		}

	}
}