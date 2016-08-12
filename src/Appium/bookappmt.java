package Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class bookappmt {
	WebDriver driver;
	private static Logger Log = Logger.getLogger(Setmore_signin.class.getName());

	@BeforeMethod
	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "9396aa06");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.adaptavant.setmore");
		// capabilities.setCapability("appActivity","com.adaptavant.setmore");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test(priority = 1)
	public void login() {
		driver.findElement(By.id("com.adaptavant.setmore:id/Setmore_LoginButton")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/Login_Email")).sendKeys("jacksrone@gmail.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/Login_Password")).sendKeys("setmore");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/remember_me")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/Login_LoginButton")).click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void NewCustomer() {

		driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_addmenu")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/create_newappointment")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@text, 'All Services')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.FrameLayout[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.Button[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/First_Name")).sendKeys("Test");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/Last_Name")).sendKeys("Customer1");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/NewCategory_SelectBT")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void Log_out() {

		driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_addmenu")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Log.info("Logout method started");
		WebElement menu = driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu"));
		menu.click();
		WebElement setmore_signin = driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout"));
		setmore_signin.click();
		WebElement alert_signout = driver.findElement(By.id("com.adaptavant.setmore:id/ConfirmLayout"));
		alert_signout.click();

	}

}
