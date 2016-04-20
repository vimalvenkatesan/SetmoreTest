package Appiumios;
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
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class Setmore {
	
WebDriver driver;
private static Logger Log = Logger.getLogger(Setmore.class.getName());


@BeforeMethod
public void setUp() throws MalformedURLException{

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("appium-version", "1.0");
	capabilities.setCapability("platformName", "iOS");
	capabilities.setCapability("platformVersion", "9.2");
    capabilities.setCapability("deviceName", "Karthik-setmore (9.2.1) [183860b353ab410d740e7eaaf71bf1f8dbabcff3]");
//	capabilities.setCapability("deviceName","iPhone 5s (9.2) [6A3BB487-E5A2-4E9C-ACC4-00B4E4B06C7C]");
//	capabilities.setCapability("appPackage", "com.setmore.app");
	//capabilities.setCapability("udid","04da2efc2b94f9cf45d9581b287680005352b7b4");
	
	capabilities.setCapability("udid","183860b353ab410d740e7eaaf71bf1f8dbabcff3");
	 
	  
	  capabilities.setCapability("bundleId","com.setmore.app");
	  capabilities.setCapability("app","/Users/user/Desktop/Setmore iOS ipa/SetMore.ipa");
	
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	
    
}

@Test
public void SetMoreLogin() {

     WebElement Setmore_logo = driver.findElement(By.className("android.widget.ImageView"));
     Setmore_logo.click();
     
     driver.findElement(By.className("android.widget.Button")).click();
     
     driver.findElement(By.id("com.adaptavant.setmore:id/Login_Email")).sendKeys("jacksrone@gmail.com");
     driver.findElement(By.id("com.adaptavant.setmore:id/Login_Password")).sendKeys("setmore");
     
     File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 try {
		FileUtils.copyFile(scrFile, new File("/Users/user/Documents/Magicpic/screenshot.png"),true);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
     //driver.findElement(By.className("com.adaptavant.setmore:id/Login_LoginButton")).click();
     WebElement setmore_signin = driver.findElement(By.id("com.adaptavant.setmore:id/Login_LoginButton"));
     setmore_signin.click();
     
}


@AfterMethod
public void tearDown() throws Exception {
driver.quit();
}



}