package CalendarPage;

import org.testng.annotations.Test;

import appModule.signout;
import logins.Log4j;

import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Singlebooking {

	WebDriver driver;
	
	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	@BeforeTest
	public void setUp(){
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://my.setmore.com/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Reporter.log("Application Lauched successfully | ");
	driver.findElement(By.id("username")).sendKeys("love12345@setmore.com");
	driver.findElement(By.id("password")).sendKeys("setmore");
	driver.findElement(By.xpath(".//*[@id='Login_Form_id']/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	 @Test
	 public void book() throws InterruptedException 		
	{	
		 
		 int positionOfSlots = 80;		 

		     driver.findElement(By.xpath(".//*[@id='calendarHolder']/div/div/div/div/div/table/tbody/tr["+positionOfSlots+"]/td")).click();
		   
		 
		//click service scroll
		//	 driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]/div[3]/ul/li[2]/div[1]/a")).click();
			 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[3]/ul/li[2]/div[1]/a")).click();
				 //Select service 
			 driver.findElement(By.xpath(".//*[@id='service-sa0d61450771373756']")).click();
				Thread.sleep(5000);
				Log.info("Two");
				
	    //click continue
		//	 driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]/div[7]/a[1]")).click();
			 driver.findElement(By.className("appt-save-btn")).click();
			
        //Input cusomter name
			 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/div/input")).sendKeys("Almighty");
			 
		//click New customer
			 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/a")).click();
			 
			 driver.findElement(By.xpath(".//*[@id='apptCust-LoginId']")).sendKeys("Almighty@g.com");
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//*[@id='dup-appt-save-btn']")).click();
			 Thread.sleep(5000);
		 
	 }
	 
	 @AfterTest
	 public void Logout()
	    
	    {	
	    signout.Execute(driver);
		}
		
	
}