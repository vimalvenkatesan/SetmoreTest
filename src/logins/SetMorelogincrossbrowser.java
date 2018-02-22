package logins;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.Reporter;
import java.util.logging.Logger;
import appModule.signout;

@Listeners(Reporter.class)
public class SetMorelogincrossbrowser {

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	public WebDriver driver;
	String Url = "https://my.setmore.com";

	@Parameters("firefox")

	@BeforeTest
	// Passing Browser parameter from TestNG xml

	public void beforeTest(String browser) {

		// If the browser is Firefox, then do this

		if (browser.equalsIgnoreCase("firefox")) {
			Log.info("firefox Browser Launched");
			System.setProperty("webdriver.gecko.driver", "//Users//user//Downloads//EclipseSeleniumJava//geckodriver");
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("Chrome")) {
			Log.info("Chrome Browser Launched");
			System.setProperty("webdriver.chrome.driver", "//Downloads//EclipseSeleniumJava//chromedriver");
			driver = new ChromeDriver();
			System.out.println("ChromeDriver: is launched ");

		} else if (browser.equalsIgnoreCase("Safari")) {
			Log.info("Safari Browser Launched");
			driver = new SafariDriver();
			System.out.println("SafariDriver: is launched ");
		}

		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void SetmoreLogin() {
		Log.info("Input SetMore Login Fields");
		driver.findElement(By.id("username")).sendKeys("love12345@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// @Test(priority=2)
	// public void Logout()
	//
	// {
	// {
	// signout.Execute(driver);
	// }
	//
	// try
	// {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	//
	// }}

	@AfterTest
	public void Close_window() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
	}
}