package bookingPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Appium.Setmore_signin;
import Utility.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@Listeners(Reporter.class)
public class BookaSlot {
	
	private static Logger Log = Logger.getLogger(Setmore_signin.class.getName());
	WebDriver driver;
	String st="No Slots Available";
//	baseUrl="http://staging.setmore.com/",
//	css_currentdate="td.datepickerSelected > a > span",
//	xpath_slots="//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a",
//	sr;
	

	@BeforeMethod
	@BeforeSuite
	 public void setUp(){
		 driver = new FirefoxDriver();
		 driver.get("http://live12345.setmore.com");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

  @Test
  public void booking() {
	
 
			// click to choose book services
			driver.findElement(By.xpath(".//*[@id='gt_sr']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			// Click to choose service
			driver.findElement(By.xpath(".//*[@id='se2c31440052067209']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			
			//Click to choose date
	       List<WebElement> date = driver.findElements(By.xpath("//td[@class='datepickerSelected']"));
		 //List<WebElement> date = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
			//List<WebElement> date = driver.findElements(By.xpath("//td[@class='']"));
			String selectedDate		=	date.get(0).getText();
			driver.findElement(By.linkText(selectedDate)).click();

					//List the timeslots
					List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a"));
					System.out.println("Available Slots :: " + availslots);
					int bookings 		= availslots.size();
					System.out.println(" Time slots size :: " + bookings);
					try
					{
						if (bookings > 0) 
						{
							String[] slots1 = new String[bookings];
							int j = 0;
							// System.out.println(" available slots :: "+availslots);
							for (WebElement avail : availslots) {
								slots1[j] = avail.getText();
								System.out.println(slots1[j]);
								j++;
							

							for (String SelectedSlot : slots1) {
								System.out.println("Selected SLot :: " + SelectedSlot);
								driver.findElement(By.linkText(SelectedSlot)).click();

								driver.findElement(By.id("cust-IName")).sendKeys(
										"Vimal Tester");
								
								// Click on continue
								driver.findElement(
										By.xpath(".//*[@id='cust-continue']")).click();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								// Book My Appointment
								driver.findElement(By.className("global_btn2_rt")).click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
							break;	
							}}
						} else
						{
							System.out.println("slot not available");
						}
					}
					catch(Exception e)
					{
						Log.info("Exception "+e.getMessage());
					}
}


					

@AfterSuite
public void end(){
	
	 driver.close();
  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}}