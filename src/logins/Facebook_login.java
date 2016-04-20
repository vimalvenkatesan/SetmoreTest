package logins;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import Utility.Constant;
import Utility.Reporter;
import appModule.signout;

@Listeners(Reporter.class)
public class Facebook_login {
	
	
	private static WebDriver driver;
	 
	private static Logger Log = Logger.getLogger(Facebook_login.class.getName());
	
	
	@BeforeTest
	public void login()
	
	{
		Log.info("Web application launched");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);     
	 }
	
	
	@Test
	public void Facebook_Loign()
	
	{   
		Log.info("Input FaceBook_Login Fields");
		driver.findElement(By.className("facebook_signin_btn")).click();
		driver.findElement(By.id("email")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Indian123$");
		driver.findElement(By.id("loginbutton")).click();
	}
	
	
    @AfterTest
    public void Logout()
    
    {
        Log.info("Logout Buddy");
	    signout.Execute(driver);
	}
	
          }
	
