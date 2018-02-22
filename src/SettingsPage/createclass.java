package SettingsPage;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Constant;
import Utility.Reporter;

@Listeners(Reporter.class)
public class createclass {

	public static WebDriver driver = new FirefoxDriver();
	private static Logger Log = Logger.getLogger(createclass.class.getName());

	@BeforeClass
	public void Login() {

		Log.info("Web application launched");

		// driver.get(Constant.Staging_URL);

		driver.get(Constant.URL);
		Log.info("Singin started");
		driver.findElement(By.id("username")).sendKeys("sports@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void SettingsTab() {

		Log.info("Settings Tab Clicked ");

		driver.findElement(By.xpath(".//*[@id='settings_new']/a")).click();
		WebElement ele = driver.findElement(By.xpath(".//*[@id='settings_new']/ul/li[4]/a/div[2]/h3"));
		Actions Builder = new Actions(driver);
		Builder.click(ele).perform();
	}

	@Test(priority = 2)
	public void createservices() {
		Log.info("Create class");

		Log.info("Class Name");

		if (driver.findElement(By.xpath(".//*[@id='noClass']/button")).isDisplayed())

			driver.findElement(By.xpath(".//*[@id='noClass']/button")).click();

		else {
			driver.findElement(By.id("addNewClass")).click();

			driver.findElement(By.xpath(".//*[@id='class_title']")).click();
			driver.findElement(By.xpath(".//*[@id='class_title']")).sendKeys("Class One");

			driver.findElement(By.xpath(".//*[@id='class_cost']")).click();
			driver.findElement(By.xpath(".//*[@id='class_cost']")).sendKeys("100");

			driver.findElement(By.xpath(".//*[@id='class_duration']")).click();
			driver.findElement(By.xpath(".//*[@id='class_duration']")).sendKeys("15");

			driver.findElement(By.xpath(".//*[@id='class_slots']")).click();
			driver.findElement(By.xpath(".//*[@id='class_duration']")).sendKeys("100");

			driver.findElement(By.xpath(".//*[@id='saveNewClass']")).click();

		}
	}
}
