package Appium;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class Face_Login {
WebDriver driver;


@BeforeMethod
@BeforeClass
public void setUp() throws MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "Android");
	capabilities.setCapability("VERSION", "5.1"); 
	capabilities.setCapability("deviceName","9396aa06");
	capabilities.setCapability("platformName","Android"); 
    capabilities.setCapability("appPackage", "com.adaptavant.setmore");
   // capabilities.setCapability("appActivity","com.adaptavant.setmore"); 
   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}


@Test
public void testCal() throws Exception {

	//click Setmore app
     WebElement Setmore_logo = driver.findElement(By.className("android.widget.ImageView"));
     Setmore_logo.click();
     //Click Fb 
     driver.findElement(By.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]")).click();
     //UserName
     driver.findElement(By.id("com.facebook.katana:id/login_username")).clear();
     driver.findElement(By.id("com.facebook.katana:id/login_username")).sendKeys("jacksrone@gmail.com");
     //pwd
     driver.findElement(By.id("com.facebook.katana:id/login_password")).sendKeys("Setmore^7");
     
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("/Users/user/Documents/Magicpic/screenshot.png"),true);
     //driver.findElement(By.className("com.adaptavant.setmore:id/Login_LoginButton")).click();
	    
     WebElement Fb_signin = driver.findElement(By.id("com.facebook.katana:id/login_login"));
     Fb_signin.click();
}}


//@AfterClass
//public void Log_out(){
//	//Logout
//	
//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//	 WebElement menu = driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_mainmenu"));
//	 menu.click();
//	 WebElement setmore_signin = driver.findElement(By.id("com.adaptavant.setmore:id/menu_signout"));
//     setmore_signin.click();
//     WebElement alert_signout = driver.findElement(By.id("com.adaptavant.setmore:id/ConfirmLayout"));
//     alert_signout.click();
//}
//}
