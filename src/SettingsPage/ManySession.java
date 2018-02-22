package SettingsPage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Bookingpage;
import Utility.Constant;
import Utility.Reporter;
import customerPage.AddCustomer;

@Listeners(Reporter.class)
public class ManySession {

	public static WebDriver driver = new FirefoxDriver();
	private static Logger Log = Logger.getLogger(ManySession.class.getName());

	@BeforeClass
	public void Login() {

		Log.info("Web application launched");

		driver.get(Constant.URL);
		Log.info("Singin started");
		driver.findElement(By.id("username")).sendKeys("sports@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void SettingsTab() {

		Log.info("Settings Tab Clicked ");

		driver.findElement(By.xpath(".//*[@id='settings_new']/a")).click();
		WebElement ele = driver.findElement(By.xpath(".//*[@id='settings_new']/ul/li[4]/a/div[2]"));
		Actions Builder = new Actions(driver);
		Builder.click(ele).perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	@Test(priority = 2)
	public void createservices() {
		Log.info("Create class");

		// Boolean isPresent =
		// driver.findElements(By.xpath(".//*[@id='noClass']/button")).size() > 0;

		// System.out.println(isPresent);

		if (driver.findElements(By.xpath(".//*[@id='noClass']/button")).size() > 0) {

			driver.findElement(By.xpath(".//*[@id='noClass']/button")).click();

			driver.findElement(By.xpath(".//*[@id='class_title']")).click();
			driver.findElement(By.xpath(".//*[@id='class_title']")).sendKeys("Class One");

			driver.findElement(By.xpath(".//*[@id='class_cost']")).click();
			driver.findElement(By.xpath(".//*[@id='class_cost']")).sendKeys("100");

			driver.findElement(By.xpath(".//*[@id='class_duration']")).click();
			driver.findElement(By.xpath(".//*[@id='class_duration']")).sendKeys("15");

			driver.findElement(By.xpath(".//*[@id='class_slots']")).click();
			driver.findElement(By.xpath(".//*[@id='class_duration']")).sendKeys("100");

			driver.findElement(By.xpath(".//*[@id='saveNewClass']")).click();

		} else {
			// class id
			driver.findElement(By.xpath(".//*[@id='cafd651470643859287']/div[3]")).click();
			driver.findElement(By.xpath(".//*[@id='addClassSession']")).click();

			// click session pop-up
			driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]")).click();
			driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[6]/input")).click();
			driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[6]/input")).sendKeys("1000");

			// Click Never
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]")).click();
			driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li/div[1]")).click();

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Click Daily

			System.out.println("Check for Daily");
			driver.findElement(By.xpath(".//*[@id='repeatType-daily']")).click();
			driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li[3]/div[1]"))
					.click();

			// New code
			System.out.println("Check for List");
			// List<WebElement> dates =
			// driver.findElements(By.xpath("//div[@class='datepickerSaturday
			// datepickerSelected' or
			// @class='datepicker']/div/table/tbody/tr/td/table/tbody[2]/tr/td[@class='' or
			// @class='datepickerSaturday' or @class='datepickerSunday']/a/span"));
			// List<WebElement> dates =
			// driver.findElements(By.xpath(".//*[@id='datepicker_302']/div[9]/table/tbody/tr/td/table/tbody[@class='datepickerYears']/tr[2]/td[3]"));

			// ***********//
			List<WebElement> dates = driver.findElements(By.xpath(""));
			int Totaldates = dates.size();
			System.out.println(" Total Dates  :: " + Totaldates);

			for (int i = 0; i < Totaldates; i++) {
				String date = dates.get(i).getText();
				if (date.equalsIgnoreCase("30"))
					;
				{
					dates.get(i).click();
					break;
				}
			}
			// **********//
			// Save
			driver.findElement(By.xpath(".//*[@id='addClassSession']")).click();

		}

	}
}
