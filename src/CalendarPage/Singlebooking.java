package CalendarPage;

import org.testng.annotations.Test;

import appModule.signout;

import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Singlebooking {

	WebDriver driver;
	
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
				 
		     driver.findElement(By.xpath("//*[@id='calendarHolder']/div/div/div/div/div/table/tbody/tr[51]/td/table/tbody/tr/td[4]")).click();
		        
				//click service scroll
			 driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]/div[3]/ul/li[2]/div[1]/a")).click();
				 //Select service 
			 driver.findElement(By.xpath(".//*[@id='service-se2c31440052067209']")).click();
				Thread.sleep(5000);
				
     		 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]/div[7]/a[1]")));

				  //click continue
			 driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]/div[7]/a[1]")).click();
				 //Input cusomter name
			 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/div/input")).sendKeys("Jack Single");
				 //click New customer
			 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/a")).click();
			 driver.findElement(By.xpath(".//*[@id='apptCust-LoginId']")).sendKeys("jacksrone@gmail.com");
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//*[@id='dup-appt-save-btn']")).click();
			 try
			 {
					Thread.sleep(3000);
			 } 
			 catch (InterruptedException e) 
			 {
				e.printStackTrace();
			 }			
				
		 
	 }

	 @AfterTest
	    public void Logout()
	    
	    {	
	      signout.Execute(driver);
			
	    }
	}