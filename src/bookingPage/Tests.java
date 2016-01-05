package bookingPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import customerPage.Customer;
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
import org.openqa.selenium.support.ui.WebDriverWait;



public class Tests {
	private final static Logger log = Logger.getLogger("Tests");
	WebDriver driver;
	String ND="No Dates Available";
	String bookingType = null;
	
	private static Logger Log = Logger.getLogger(Customer.class.getName());
//	baseUrl="http://staging.setmore.com/",
//	css_currentdate="td.datepickerSelected > a > span",
//	xpath_slots="//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a",
//	sr;
	

	@BeforeMethod
	@BeforeClass
	 public void setUp(){
		   driver = new FirefoxDriver();
		 	
		    Log.info("Web application launched");
			driver.get("http://live12345.setmore.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	    @Test
      public void booking() {
	    	 try {
					Thread.sleep(3000);
				} catch (InterruptedException e){
					// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    	 
	 //   	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	
	    	int bookings = 0;
	    	List<WebElement> availslots = null;
	    	
	  if(driver.findElement(By.xpath(".//*[@id='gt_sr']")).isDisplayed())
	  {    bookingType = "appt";
		    //click to choose book services		  
			driver.findElement(By.xpath(".//*[@id='gt_sr']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Log.info("Booking Tab is clicked ");
			
			//Click to choose service                          
			driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[2]/div[2]/div[3]/div[3]/ul[1]/ul/li")).click();
			Log.info("Chose a Service");
		   //driver.findElement(By.xpath(".//*[@id='se2c31440052067209']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			

			
			  //Click to choose date
		//	List<WebElement> date = driver.findElements(By.xpath("//td[@class='datepickerSelected']"));
			  List<WebElement> date = driver.findElements(By.xpath("//div[@class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
			  //List<WebElement> date = driver.findElements(By.xpath("//td[@class='']"));
			
			  if(date.size() > 0)
			  { 
				  String selectedDate		=	date.get(0).getText();
				  driver.findElement(By.linkText(selectedDate)).click();
				  Log.info("Clicked on a Date");
			  }
			  else
			  {
				  System.out.println(ND);
				  
			  }
			
			
			//List the timeslots
			 availslots = driver.findElements(By.xpath("//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a"));
			//				System.out.println("Available Slots :: " + availslots);
			 bookings = availslots.size();
			System.out.println(" Number of slots Available :: " + bookings);

	  } else 
	  {    bookingType = "classes";
		   driver.findElement(By.xpath(".//*[@id='gt_cls']")).click();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   Log.info("Class Tab is clicked");
		   
		   // Click to choose class     		
		   driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[2]/div[2]/div[4]/div[2]/ul/ul[2]/ul/li")).click();
		   Log.info("Chose a class");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		   //List the timeslots
			 availslots = driver.findElements(By.xpath("//div[@class='class_sessions_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a"));
//			System.out.println("Available Slots :: " + availslots);
			
			 bookings = availslots.size();
			System.out.println("Number of slots Available :: " + bookings);		

		}
	  
	  

		try
		{
			if (bookings > 0) 
			{
				String[] slots1 = new String[bookings];
				int j = 0;
				
				for (WebElement avail : availslots) 
				{
					slots1[j] = avail.getText();
					System.out.println(slots1[j]);
					j++;
				

				for (String SelectedSlot : slots1)
				{
					System.out.println("The Slot Selected to Book an appointmetnt is :: " + SelectedSlot);
					driver.findElement(By.linkText(SelectedSlot)).click();
					if(bookingType.equalsIgnoreCase("appt")) 	{		 			 
						appt();		
				}else
			{
					classes();					
			}	
					
				}
				}
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
public void appt()
{
	Log.info("Enter Customer Name");					
	driver.findElement(By.xpath(".//*[@id='cust-IName']")).click();
	driver.findElement(By.xpath(".//*[@id='cust-IName']")).sendKeys("Vimal Tester");					
	Log.info("Customer Nameclicked");
	
	Log.info("Try to click Continue");
	// Click on continue
	driver.findElement(By.xpath(".//*[@id='cust-continue']")).click();
	Log.info("Continue clicked");
	
	Log.info(" Try to click Book My Appointment");
	// Book My Appointment
	driver.findElement(By.className("global_btn2_rt")).click();
	Log.info("Book My Appointment clicked");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}		

public void classes()
{
	
	Log.info("Enter Customer Name");					
	driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[2]/div[2]/div[4]/div[5]/form/div[1]/ul/li[3]/div[1]/input")).sendKeys("Vimal Tester");					
	Log.info("Customer Nameclicked");
	
	Log.info("Try to click Continue");
	// Click on continue
	driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[2]/div[2]/div[4]/div[5]/form/div[3]")).click();
	Log.info("Continue clicked");
	
	Log.info(" Try to click Book My Appointment");
	// Book My Appointment
	driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div[2]/div[2]/div[4]/div[6]/div[4]/span")).click();
	Log.info("Book My Appointment clicked");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@AfterClass
public void end(){
	
	 driver.quit();
	 Log.info("Drive quit");
  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
}}