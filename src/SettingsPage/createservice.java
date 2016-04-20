package SettingsPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Constant;
import Utility.Reporter;
import customerPage.AddCustomer;
@Listeners(Reporter.class)
public class createservice {

	
	   public static WebDriver driver=new FirefoxDriver();
	    private static Logger Log = Logger.getLogger(createservice.class.getName());
	
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
//		driver.manage().window().maximize();
	  
        }
	    
	    @Test(priority=1)
	    public void SettingsTab()
	    {	
		 
	     Log.info("Settings Tab Clicked ");
	     
	     driver.findElement(By.xpath(".//*[@id='settings_new']/a")).click();
	     WebElement ele = driver.findElement(By.xpath(".//*[@id='settings_new']/ul/li[2]/a/div[2]/h3"));
	     Actions Builder=new Actions(driver);
	     Builder.click(ele).perform();
	    }
	
	    
	    @Test(priority=2)
	    public void createservices()
	    { 
	    Log.info("Create service");
	    
	    Log.info("service Name");
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='addNewService']")).click();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='service_ServiceName']")).sendKeys("ServiceOne1");
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='service_Cost']")).click();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='service_Cost']")).sendKeys("100");
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='service_Duration']")).click();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='service_Duration']")).sendKeys("15");
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='serviceDetails']/ul[2]/li[1]/div/span/div/a")).click();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='saveNewService']")).click();
	    
	    
	    Log.info("Create Category");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='addCategoryPlus']")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='categoryNewName']")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='categoryNewName']")).sendKeys("Service Category");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='addCategory']")).click();
	
	    }
	    }
