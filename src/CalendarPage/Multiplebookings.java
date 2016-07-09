package CalendarPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModule.signout;

public class Multiplebookings {
	WebDriver driver;
	String calslot = "//*[@id='calendarHolder']/div/div/div/div/div/table/tbody/tr[48]/td/table/tbody/tr/td[4]";

	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://staging.setmore.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Application Lauched successfully | ");
		driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath(".//*[@id='Login_Form_id']/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void bookLimitedAppts() 
	{
		int apptCount 			= 200;
		int positionOfSlots 	= 30;
		for (int i = 1; i <= apptCount; i++) {
			System.out.println(" Booked No of APPTS  :: " + i);
//			if (i != 4) {
				try {
					
					BookingAppts( i , positionOfSlots );positionOfSlots++; 
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
//	}

	@Test
	public void BookingAppts( int i , int positionOfSlots ) throws InterruptedException {

		driver.findElement(
				By.xpath("//*[@id='calendarHolder']/div/div/div/div/div/table/tbody/tr["+positionOfSlots+"]/td/table/tbody/tr/td[7]"))
				.click();

		// click service scroll
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[4]/div[3]/ul/li[2]/div[1]/a")).click();
		// Select service
//		driver.findElement(By.xpath(".//*[@id='service-se2c31440052067209']")).click();
		
		driver.findElement(By.xpath(".//*[@id='service-s3d4445d8693ee5bdcb4a5cb7cb192a52d9a1e3ff']")).click();
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
		//driver.findElement(By.xpath(".//*[@id='dup-appt-save-btn']")).click();
		driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[7]/a[1]")).click();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

	 @AfterTest
	    public void Logout()
	    
	    {	
	    signout.Execute(driver);
		}
		
	}
