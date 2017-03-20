package SettingsPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Constant;
import Utility.Reporter;
import appModule.signout;
import customerPage.AddCustomer;
@Listeners(Reporter.class)
public class CreateStaff {

	
	   public static WebDriver driver=new FirefoxDriver();
	    private static Logger Log = Logger.getLogger(CreateStaff.class.getName());
	
	    @BeforeClass
		public void Login()
		{
	    	
	    Log.info("Web application launched");
		// driver.get("https://www.setmore.com/");
		//driver.get("https://my.setmore.com/");
		//driver.get("https://staging.setmore.com");
		//driver.get(Constant.Staging_URL);
		
		driver.get(Constant.URL);
		Log.info("Singin started");
		driver.findElement(By.id("username")).sendKeys("sports@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	  
        }
	    
	    @Test(priority=1)
	    public void SettingsTab()
	    {	
		 
	     Log.info("Settings Tab Clicked ");
	     
	     driver.findElement(By.xpath(".//*[@id='settings_new']/a")).click();
	     WebElement ele = driver.findElement(By.xpath(".//*[@id='settings_new']/ul/li[1]/a/div[1]"));
	     Actions Builder=new Actions(driver);
	     Builder.click(ele).perform();
	    }
	
	    
	    @Test(priority=2)
	    public void CreateStaff()
	    { 
	    Log.info("Create Staff");
	    
	    driver.findElement(By.xpath(".//*[@id='createNewStaffBtn']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='staffNewName']")).clear();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='staffNewName']")).sendKeys("NewdStaff");
		
		Log.info("Staff Email");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='staffNewEmail']")).clear();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='staffNewEmail']")).sendKeys("Staffsf@email.com");
	    
		driver.findElement(By.xpath(".//*[@id='addstaff']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Log.info("Staff Services");
//		
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(".//*[@id='staffContentNav']/ul/li[2]/a")).click();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.findElement(By.xpath(".//*[@id='staff-services']/div/div[2]/ul/li[1]")).click();
		
	    }
	    
@AfterTest
public void Logout()

{	
signout.Execute(driver);
}
}
