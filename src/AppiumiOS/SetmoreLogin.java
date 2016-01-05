
package AppiumiOS;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetmoreLogin {
	WebDriver driver;

	@BeforeMethod
	@BeforeClass
    public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.1");
		capabilities.setCapability("deviceName", "iPhone 5");
		capabilities.setCapability("app", "/Users/sathiyarengarajan/Downloads/SetmoreiOS/build/Release-iphonesimulator/SetMore.app");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}

	
	
    
    @Test(priority=1)
public void login(){
    	
    	driver.findElement(By.name("OK")).click();
    	driver.findElement(By.name("Setmore Login")).click();
    	try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATextField[1]")).click();
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATextField[1]")).sendKeys("chv@setmore.com");
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIASecureTextField[1]")).click();
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIASecureTextField[1]")).sendKeys("123456");
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.name("SIGN IN")).click();
		try {
    		Thread.sleep(12000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAButton[1]")).click();
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.name("SIGN OUT")).click();
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		driver.findElement(By.name("Yes")).click();
		
		try {
    		Thread.sleep(3000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		   }
    

 @AfterClass
    public void teardown(){

        driver.quit();
    } 
}