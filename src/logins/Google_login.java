package logins;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import Utility.Constant;
import Utility.Reporter;
import appModule.signout;

@Listeners(Reporter.class)
public class Google_login {
	
	
	private static WebDriver driver;
	 
	private static Logger Log = Logger.getLogger(Log4j.class.getName());
	
	
//	String Url="https://my.setmore.com";
	
	
	@BeforeTest
	public void login()
	
	{
//		System.setProperty("webdriver.chrome.driver","//Applications//chromedriver");
//		WebDriver driver=new ChromeDriver();
	  //driver=new SafariDriver();
        driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		
		Log.info("Implicit wait applied on the driver for 30 seconds");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	}
	
	
	@Test
	public void GoogleLogin() throws IOException
	
	{
		Log.info("Input Gooogle_Login Fields");
		//Google signin
		driver.findElement(By.className("google_signin_btn")).click();
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		driver.findElement(By.xpath(".//*[@id='Email']")).click();
		//Google Loginpage
	    driver.findElement(By.id("Email")).sendKeys("jacksrone@gmail.com");
	    driver.findElement(By.id("next")).click();
	    //driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("JohnCena");
	    driver.findElement(By.id("signIn")).click();
	    //ScreenShot
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("/Users/user/Documents/Magicpic/screenshot.png"),true);
	}
	
	
    @AfterTest
    public void Logout()
    
    {	
      signout.Execute(driver);
		
    }

    
    @AfterMethod
    public void tearDown(ITestResult result)
    {
      if(ITestResult.SUCCESS==result.getStatus())
	    {
	     Utility.CreateScreenshot.snap(driver, result.getName());
        }
    }
    
    	}
	
