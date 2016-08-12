package Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class create_account {
	WebDriver driver;
	private static Logger Log = Logger.getLogger(create_account.class.getName());

	@BeforeMethod
	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "9396aa06");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.adaptavant.setmore");
		capabilities.setCapability("appActivity", "com.adaptavant.setmore.ui.StartActivity");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void CreateAccount() {

		// Click app Button
		WebElement Setmore_logow = driver.findElement(By.className("android.widget.ImageView"));
		Setmore_logow.click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Create Account Button
		driver.findElement(By.id("com.adaptavant.setmore:id/CreateAccount_LandingPage")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Give Name
		driver.findElement(By.id("com.adaptavant.setmore:id/AccountName")).sendKeys("Rogesr4");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Give Email
		// driver.findElement(By.id("")).sendKeys("");
		driver.findElement(By.id("com.adaptavant.setmore:id/AccountEmail")).sendKeys("Roger1234@gasmi.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/AccountPassword")).sendKeys("Password");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/CreateAccount")).click();
	}

	@Test(priority = 1)

	public void firstPage() {

		// com.adaptavant.setmore:id/CompanyName
		driver.findElement(By.id("com.adaptavant.setmore:id/CompanyName")).sendKeys("TestInidaCompany");

		driver.findElement(By
				.xpath("//android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]"))
				.click();
		//
		// Selectselect= new Select (driver.findElement(locator));
		// select.selectByVisibleText(value);driver.findElement(By.xpath("")).sendKeys("");
		//
		// driver.findElement(By.xpath("")).sendKeys("");
		// driver.findElement(By.id("")).sendKeys("");
		// driver.findElement(By.id("")).sendKeys("");
		// driver.findElement(By.id("")).sendKeys("");
		// driver.findElement(By.id("")).sendKeys("");

	}
	// @AfterClass
	// public void Log_out(){
	//
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	// Log.info("Logout method started");
	// WebElement menu =
	// driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu"));
	// menu.click();
	// WebElement setmore_signin =
	// driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout"));
	// setmore_signin.click();
	// WebElement alert_signout =
	// driver.findElement(By.id("com.adaptavant.setmore:id/ConfirmLayout"));
	// alert_signout.click();

}
