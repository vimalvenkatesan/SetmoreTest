package Appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class setmore_sigin_Emulator {

	WebDriver driver;
	private static Logger Log = Logger.getLogger(setmore_sigin_Emulator.class.getName());

	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "9396aa06");
		capabilities.setCapability("deviceName", "emulator-5554");
		// capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.adaptavant.setmore");
		capabilities.setCapability("appActivity", "com.adaptavant.setmore.ui.StartActivity");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void SetMoreLogin() {

		WebElement Setmore_logo = driver.findElement(By.className("android.widget.ImageView"));
		Setmore_logo.click();

		driver.findElement(By.className("android.widget.Button")).click();

		driver.findElement(By.id("com.adaptavant.setmore:id/Login_Email")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("com.adaptavant.setmore:id/Login_Password")).sendKeys("setmore");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("/Users/user/Documents/Magicpic/screenshot.png"), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.findElement(By.className("com.adaptavant.setmore:id/Login_LoginButton")).click();
		WebElement setmore_signin = driver.findElement(By.id("com.adaptavant.setmore:id/Login_LoginButton"));
		setmore_signin.click();

	}

	@AfterClass
	public void Log_out() {

		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 200)).until(
				ExpectedConditions.presenceOfElementLocated(By.id("com.adaptavant.setmore:id/myschedule_mainmenu")));
		Log.info("Logout method started");
		WebElement menu = driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu"));
		menu.click();
		WebElement setmore_signin = driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout"));
		setmore_signin.click();
		WebElement alert_signout = driver.findElement(By.id("com.adaptavant.setmore:id/ConfirmLayout"));
		alert_signout.click();

	}

}