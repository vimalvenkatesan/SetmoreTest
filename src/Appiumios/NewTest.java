package Appiumios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import Appium.Setmore_signin;

public class NewTest {

	static WebDriver driver;
	private static Logger Log = Logger.getLogger(Setmore_signin.class.getName());

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.2");
		capabilities.setCapability("stimulator", "iPhone 5s");
		capabilities.setCapability("app", "/Users/user/Desktop/SetmoreiOS/Payload/SetMore.app");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/driver/hub"), capabilities);
	}

	@Test(priority = 1)
	public void login() {
		Log.info("Lets Login");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).sendKeys("setmore");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[6]")).click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
