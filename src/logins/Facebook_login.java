package logins;

import org.testng.annotations.Test;

import com.sun.org.apache.xpath.internal.functions.Function;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import Utility.Constant;
import Utility.Reporter;
import appModule.signout;

@Listeners(Reporter.class)
public class Facebook_login {

	private static final TimeUnit SECONDS = null;

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Facebook_login.class.getName());

	@BeforeTest
	public void login()

	{
		Log.info("Web application launched");
		System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/Office/EclipseRD/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		Log.info("Implicit wait applied on the driver for 30 seconds");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Facebook_Login()

	{
		Log.info("Input FaceBook_Login Fields");
		driver.findElement(By.className("facebook_signin_btn")).click();
		driver.findElement(By.id("email")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Setmore");
		driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement element =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='login_details']
		// //*[@id='account_menu']")));
		// Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		// .withTimeout(30, SECONDS)
		// .pollingEvery(5, SECONDS)
		// .ignoring(NoSuchElementException.class);
		//
		// WebElement foo = wait.until(new Function() {
		// public WebElement apply(WebDriver driver) {
		// return driver.findElement(By.id("foo"));
		// }});
		//
	}

	@AfterTest
	public void Logout()

	{

		signout.Execute(driver);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.SUCCESS == result.getStatus()) {
			Utility.CreateScreenshot.snap(driver, result.getName());
		}
	}
}
