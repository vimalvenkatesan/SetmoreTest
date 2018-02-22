package bookingPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Utility.Bookingpage;

import org.testng.annotations.BeforeClass;

import customerPage.CustomerPageFull;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tests {

	WebDriver driver;
	String ND = "No Dates Available";
	String bookingType = null;

	private static Logger Log = Logger.getLogger(CustomerPageFull.class.getName());

	@BeforeClass
	public void setUp() {

	 	System.setProperty("webdriver.gecko.driver","/Users/user/Downloads/Office/EclipseRD/geckodriver");
	    driver = new FirefoxDriver();
		Log.info("Web application launched");
		driver.get("http://live12345.setmore.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void booking() {
		// try {
		//// Thread.sleep(3000);
		//// } catch (InterruptedException e){
		//// // TODO Auto-generated catch block
		//// e.printStackTrace();
		//// }

		int bookings = 0;
		List<WebElement> availslots = null;
		List<WebElement> date = null;

		if (driver.findElement(By.xpath(Bookingpage.BookTab)).isDisplayed()) {

			bookingType = "appt";

			// click to choose book services
			// driver.findElement(By.xpath(Bookingpage.BookTab)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Log.info("Booking Tab is clicked ");

			// Click to choose service
			driver.findElement(By.xpath(Bookingpage.Service)).click();
			Log.info("Chose a Service");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Click to choose staff
			driver.findElement(By.xpath(Bookingpage.Staff)).click();
			Log.info("Chose a staff");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Click to choose date
			date = driver.findElements(By.xpath(Bookingpage.Timeslot));

			if (date.size() > 0) {
				String selectedDate = date.get(0).getText();
				driver.findElement(By.linkText(selectedDate)).click();
				Log.info("Clicked on a Date");
			} else {
				System.out.println(ND);

			}

			// List the timeslots
			availslots = driver.findElements(
					By.xpath("//div[@class='time_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a"));
			// System.out.println("Available Slots :: " + availslots);
			bookings = availslots.size();
			System.out.println(" Number of slots Available :: " + bookings);

		} else {
			bookingType = "classes";
			driver.findElement(By.xpath(".//*[@id='gt_cls']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Log.info("Class Tab is clicked");

			// Click to choose class
			// /html/body/div[7]/div/div[2]/div[2]/div[2]/div[4]/div[2]/ul/ul[2]/ul/li/div[2]/b
			driver.findElement(
					By.xpath("/html/body/div[7]/div/div[2]/div[2]/div[2]/div[4]/div[2]/ul/ul[2]/ul/li/div[2]/b"))
					.click();
			Log.info("Chose a class");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// List the timeslots
			availslots = driver.findElements(By.xpath(
					"//div[@class='class_sessions_sheet']/ul[@class='morning' or 'afternoon' or 'evening']/li/a"));
			// System.out.println("Available Slots :: " + availslots);

			bookings = availslots.size();
			System.out.println("Number of slots Available :: " + bookings);

		}

		try {
			if (bookings > 0) {
				String[] slots1 = new String[bookings];
				int j = 0;

				for (WebElement avail : availslots) {
					slots1[j] = avail.getText();
					System.out.println(slots1[j]);
					j++;

					for (String SelectedSlot : slots1) {
						System.out.println("The Slot Selected to Book an appointmetnt is :: " + SelectedSlot);
						driver.findElement(By.linkText(SelectedSlot)).click();
						if (bookingType.equalsIgnoreCase("appt")) {
							appt();
						} else {
							classes();
						}

					}
				}
			} else {
				System.out.println("slot not available");
			}
		} catch (Exception e) {
			Log.info("Exception " + e.getMessage());
		}

	}

	public void appt() {
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

	public void classes() {

		Log.info("Enter Customer Name");
		driver.findElement(
				By.xpath("/html/body/div[7]/div/div[2]/div[2]/div[2]/div[4]/div[5]/form/div[1]/ul/li[3]/div[1]/input"))
				.sendKeys("Vimal Tester");
		Log.info("Customer Nameclicked");

		Log.info("Try to click Continue");
		// Click on continue
		driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div[2]/div[4]/div[5]/form/div[3]")).click();
		Log.info("Continue clicked");

		Log.info(" Try to click Book My Appointment");
		// Book My Appointment
		driver.findElement(By.xpath("/html/body/div[7]/div/div[2]/div[2]/div[2]/div[4]/div[6]/div[4]/span")).click();
		Log.info("Book My Appointment clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void end() {

		driver.quit();
		Log.info("Drive quit");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}