package CalendarPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Constant;
import appModule.signout;
import customerPage.Aftersuite;

public class Multiplebookings {
	
	
	WebDriver driver;
	//String calslot = "//*[@id='calendarHolder']/div/div/div/div/div/table/tbody/tr[48]/td/table/tbody/tr/td[4]";
	int apptCount 			= 200;
	int positionOfSlots 	= 65;
	
	
	
	
	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Application Lauched successfully | ");
		driver.findElement(By.id("username")).sendKeys("love12345@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath(".//*[@id='Login_Form_id']/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority=2)
	public void bookLimitedAppts() 
	{
		
		for (int i = 1; i <= apptCount; i++) {
			System.out.println(" Booked No of APPTS  :: " + i);
			if (i != 4) {
				try {
					
					this.BookingAppts( positionOfSlots );
					positionOfSlots++; 
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Test(priority=1)
	public void BookingAppts( int positionOfSlots ) throws InterruptedException {
		
		driver.findElement(
				By.xpath(".//*[@id='startCalendar']"))
				.click();
		driver.findElement(
				By.xpath("//*[@id='calendarHolder']/div/div/div/div/div/table/tbody/tr["+positionOfSlots+"]/td/div"))
				.click();
		driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[3]/ul/li[2]/div[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='service-sa0d61450771373756']")).click();
		Thread.sleep(5000);

		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='editApptPopup']/div[8]/a[1]")));

		// click continue
		driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[7]/a[1]")).click();
		// Input cusomter name
	//	driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/div/input")).sendKeys("Oats"+i);
		driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/div/input")).sendKeys("Marksandspencers");
		// click New customer
		driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[5]/a")).click();
		
		driver.findElement(By.xpath(".//*[@id='apptCust-LoginId']")).sendKeys("amyjackson663@gmail.com");
//		driver.findElement(By.xpath(".//*[@id='apptCust-LoginId']")).sendKeys("jacksrone"+i+"@gmail.com");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='apptCust-MobileNo']")).sendKeys("9791171017");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[7]/a[1]")).click();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
			Thread.sleep(5000);
	}
	
//		 @AfterTest
//		    public void Logout()
//		    
//		    {	
//		    signout.Execute(driver);
//		    }
	}
