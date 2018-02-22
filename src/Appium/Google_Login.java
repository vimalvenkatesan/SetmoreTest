package Appium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import logins.Facebook_login;

public class Google_Login {
	WebDriver driver;
	private static Logger Log = Logger.getLogger(Google_Login.class.getName());

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
	public void GoogleLogin() {

		WebElement Setmore_logo = driver.findElement(By.className("android.widget.ImageView"));
		Setmore_logo.click();

		driver.findElement(By.id("com.adaptavant.setmore:id/Google_LoginButton")).click();
		// Click Google login
		// driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]")).click();

		// Click Add first Account
		driver.findElement(By.xpath("android:id/text1")).click();
		// click Ok
		driver.findElement(By.xpath("android:id/button2")).click();
		// driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.CheckedTextView[1]")).click();
		driver.navigate().back();

		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")).click();
		// click Allow
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[2]")).click();
		// Enter UserName
		// driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[4]")).sendKeys("jacksrone@gmail.com");
		// //Click Next
		// driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Button[1]")).click();

		//
		// driver.findElement(By.xpath("")).click();
		// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[1]")).click();
		// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[1]")).sendKeys("jacksrone@gmail.com");
		// driver.navigate().back();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")).click();
		// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")).sendKeys("JohnCena");
		// driver.navigate().back();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//// driver.findElement(By.name("Sign in")).click();
		// try {
		// Thread.sleep(12000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("com.adaptavant.setmore:id/Dialog_RightBtn")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().back();

	}
}
