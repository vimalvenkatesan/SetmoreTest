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
import appModule.openbrowser;
import appModule.signout;
import Utility.Constant;
import Utility.Reporter;


@Listeners(Reporter.class)
public class Setmore_login {		
	
	private static WebDriver driver;
	 
	private static Logger Log = Logger.getLogger(Log4j.class.getName());
 
	//DOMConfigurator.configure("log4j.xml");
	
	@BeforeTest
	public void login()
	
	{	Log.info("Lets Login");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		Log.info("Implicit wait applied on the driver for 30 seconds");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);      
	}

	@Test
	public void SetmoreLogin()
	
	{	
		Log.info("Input SetMore Login Fields");
		driver.findElement(By.id("username")).sendKeys("love12345@setmore.com");
		driver.findElement(By.id("password")).sendKeys("Setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
	}
	
	
    @AfterTest
    public void Logout()
    
    {	
    signout.Execute(driver);
	}
	
    	}
	
    
