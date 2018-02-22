package bookingPage;

import org.testng.annotations.Test;
import Utility.Bookingpage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Book_withoutSS {

	private static Logger Log = Logger.getLogger(Book_withoutSS.class.getName());

	WebDriver driver;
	String st = "No Slots Available";

	@BeforeTest
	public void setUp() {

	 	System.setProperty("webdriver.gecko.driver","/Users/user/Downloads/Office/EclipseRD/geckodriver");
	    driver = new FirefoxDriver();
//		driver.get("http://live12345.setmore.com");
	    driver.get("http://speed-dot-staging-cochii-hrd.appspot.com/bookingpage/754a7090-c7e4-4c4e-8310-7de156fbf7ee?min=false");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void booking() {

		// click to choose book services
		// driver.findElement(By.xpath(".//*[@id='gt_sr']")).click();
		

		// Click to choose service
		driver.findElement(By.xpath(Bookingpage.Service)).click();
		

		// Click to choose staff
		driver.findElement(By.xpath(Bookingpage.Staff1)).click();
		
		//If Multiple Service is displayed
		
		 try   
		  {    
			 if (driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[4]/div")).isDisplayed())    
		    {      
				 driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[4]/div/div[3]/a[1]")).click();
		    }    
		  }      
		  catch(Exception e)     
		  {       
		   System.out.println("Not a Multiple service ");   
		  }       
		
	

		// Click to choose date
		List<WebElement> date = driver.findElements(By.xpath(Bookingpage.TodayDate));

		String selectedDate = date.get(0).getText();
		driver.findElement(By.linkText(selectedDate)).click();

		// List the timeslots
		List<WebElement> availslots = driver.findElements(By.xpath(Bookingpage.Timeslot));
		int bookings = availslots.size();
		System.out.println(" Time slots size :: " + bookings);
		try {
			if (bookings > 0) {
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

						driver.findElement(By.id("cust-IName")).sendKeys("Vimal Tester");

						// Click on continue
						driver.findElement(By.xpath(".//*[@id='cust-continue']")).click();
						
						// Book My Appointment
						driver.findElement(By.className("global_btn2_rt")).click();
						

					}

					break;
				}
			} else {
				System.out.println("slot not available");
			}
		} catch (Exception e) {
			Log.info("Exception " + e.getMessage());
		}
	}

	public void end() {

		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}