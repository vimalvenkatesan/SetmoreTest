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
import org.testng.annotations.Test;

public class Book_ExtCust {
	WebDriver driver;
	private static Logger Log = Logger.getLogger(Setmore_signin.class.getName());

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

	@Test(priority = 1)
	public void login() {
		Log.info("Lets Login");
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
	public void ExistingCustomer() {
		Log.info("Gonna Book with Existing Cusotomer");
		driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_addmenu")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/create_newappointment")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@text, 'All Services')]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
		driver.findElement(By
				.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.Button[1]"))
				.click();
		// driver.findElement(By.xpath("com.adaptavant.setmore:id/create_appt_search_resource_et")).click();
		// driver.findElement(By.xpath("com.adaptavant.setmore:id/create_appt_search_resource_et")).sendKeys("Abc");
		// driver.findElement(By.xpath("com.adaptavant.setmore:id/create_appt_search_resource_et")).sendKeys(Keys.TAB);
		// android.widget.ListView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]
		driver.findElement(By
				.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.id("com.adaptavant.setmore:id/create_appt_save_bt")).click();
		Log.info("Appointment booked with Existing Cusotmer");
		ExistingCustomer();
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
		Log.info("Lets Logout Dude");
		WebElement menu = driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu"));
		menu.click();
		WebElement setmore_signin = driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout"));
		setmore_signin.click();
		WebElement alert_signout = driver.findElement(By.id("com.adaptavant.setmore:id/ConfirmLayout"));
		alert_signout.click();

	}

}
