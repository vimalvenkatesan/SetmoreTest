package bookingPage;

import org.testng.annotations.Test;

import Utility.Bookingpage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
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



public class BookingAvailablslots {

	private final static Logger log = Logger.getLogger("BookingAvailablslots");
	WebDriver driver;
	String st="No Slots Available";
//	baseUrl="http://staging.setmore.com/",
//	css_currentdate="td.datepickerSelected > a > span",
//	xpath_slots="//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a",
//	sr;
	

	
	@BeforeSuite
	 public void setUp(){
		 driver = new FirefoxDriver();
//		 System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
//		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		    ChromeOptions options = new ChromeOptions();
//		    options.addArguments("test-type");
//		    capabilities.setCapability("chrome.binary","/Applications/chromedriver");
//		    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		    driver = new ChromeDriver(capabilities);
//		    Point targetPosition = new Point(0, 0);
//			driver.manage().window().setPosition(targetPosition);
//			Dimension targetSize = new Dimension(1440, 900); 
//			driver.manage().window().setSize(targetSize);
//			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//			driver.get("http://live12345.setmore.com");		  
			 driver.get("http://rrr.setmore.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

  @Test
  public void booking() {
	            
            	// click to choose book services
//				driver.findElement(By.xpath(Bookingpage.BookTab)).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Gonna click services");
				// Click to choose service    
//				driver.findElement(By.xpath(Bookingpage.Service)).click();
//				For bookinge page Reminder@setmore.com
				driver.findElement(By.xpath(".//*[@id='sbfd99b1b14e3f3ed67fcede9b397ea17d71eee06']")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
			
			//Click to choose date
	        //List<WebElement> date = driver.findElements(By.xpath(""));
		      List<WebElement> date = driver.findElements(By.xpath("//div[@class='datepickerSaturday datepickerSelected' or @class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
			//List<WebElement> date = driver.findElements(By.xpath("//td[@class='']"));
//			String selectedDate		=	date.get(0).getText();
		      String selectedDate		=	date.get(0).getText();
			driver.findElement(By.linkText(selectedDate)).click();
			System.out.println("selectedDate :: " + selectedDate);
					//List the timeslots
					List<WebElement> availslots = driver.findElements(By.xpath("//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a"));
//					System.out.println("Available Slots :: " + availslots);
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
//								System.out.println(slots1[j]);
								j++;
							}

							for (String SelectedSlot : slots1) {
								System.out.println("Selected SLot :: " + SelectedSlot);
								driver.findElement(By.linkText(SelectedSlot)).click();

								driver.findElement(By.id("cust-IName")).sendKeys(
										"SundayGym");
								driver.findElement(By.xpath(".//*[@id='cust-IEmailId']")).sendKeys(
										"jacksrone@gmail.com");
								driver.findElement(By.xpath(".//*[@id='cust-PhoneNo']")).sendKeys(
										"9791171017");
								// Click on continue
								driver.findElement(
										By.xpath(".//*[@id='cust-continue']")).click();
								// Book My Appointment
								driver.findElement(By.className("global_btn2_rt")).click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								// Book another appointment
								driver.findElement(By.xpath(".//*[@id='another_appt']")).click();
								booking();
							}
						}else
							
						{
							System.out.println("slot not available");
						}
					}
					catch(Exception e)
					{
						log.info("Exception "+e.getMessage());
					}
}
  

					

@AfterSuite
public void end(){
	
	 driver.quit();
  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}}