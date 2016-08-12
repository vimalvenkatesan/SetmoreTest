package Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginthree {
	WebDriver driver;

	@BeforeMethod
	@BeforeClass
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1");
		capabilities.setCapability("deviceName", "9396aa06");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appActivity", "com.adaptavant.setmore.ui.StartActivity");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		// driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);

	}
	// @Test(priority=1)
	// public void SetmoreLogin(){
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Setmore_LoginButton")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Login_Email")).click();
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Login_Email")).sendKeys("chv@setmore.com");
	//
	// driver.navigate().back();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Login_Password")).click();
	//
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Login_Password")).sendKeys("123456");
	//
	// driver.navigate().back();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/remember_me")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Login_LoginButton")).click();
	// try {
	// Thread.sleep(6000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Dialog_RightBtn")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	// driver.navigate().back();
	// }

	// @Test(priority=2)
	// public void GoogleLogin(){
	// driver.findElement(By.id("com.adaptavant.setmore:id/Google_LoginButton")).click();
	// try {
	// Thread.sleep(12000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[1]")).click();
	// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[1]")).sendKeys("");
	// driver.navigate().back();
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")).click();
	// driver.findElement(By.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.widget.EditText[2]")).sendKeys("");
	// driver.navigate().back();
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	// driver.findElement(By.name("Sign in")).click();
	// try {
	// Thread.sleep(12000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	//
	// driver.findElement(By.id("com.adaptavant.setmore:id/Dialog_RightBtn")).click();
	//
	// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	// driver.navigate().back();
	// }
	@Test(priority = 3)
	public void FacebookLogin() {

		driver.findElement(By.id("com.adaptavant.setmore:id/Facebook_LoginButton")).click();

		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By
				.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]"))
				.click();
		driver.findElement(By
				.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]"))
				.clear();
		driver.findElement(By
				.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[1]"))
				.sendKeys("jacksrone@gmail.com");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By
				.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[2]"))
				.click();
		driver.findElement(By
				.xpath("//android.webkit.WebView[1]/android.view.View[1]/android.view.View[3]/android.widget.EditText[2]"))
				.sendKeys("JohnCena");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("Log in")).click();

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("com.adaptavant.setmore:id/Dialog_RightBtn")).click();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterClass
	public void teardown() {

		driver.quit();
	}
}