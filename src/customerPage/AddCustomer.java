package customerPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utility.Constant;
import Utility.Reporter;
import appModule.signout;

@Listeners(Reporter.class)
public class AddCustomer {

	public static WebDriver driver;
	private static Logger Log = Logger.getLogger(AddCustomer.class.getName());

	@BeforeClass
	public void Login() {

		Log.info("Web application launched");
		System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/Office/EclipseRD/geckodriver");
		driver = new FirefoxDriver();

		driver.get(Constant.URL);
		driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[5]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void CustomerTab() {

		driver.findElement(By.xpath(".//*[@id='side-nav-customers']")).click();
		Log.info("cusotmer Tab Clicked ");
	}

	@Test(priority = 2)
	public void CreateCustomer() {
		Log.info("Create cusotmer");

		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		int apptCount = 30;

		for (int i = 1; i <= apptCount; i++) {
			System.out.println(" Customer created No::" + i);
			if (i <= 3) {
				try {
					CustomerInput(i);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Test(priority = 3)
	public void CustomerInput(int i) throws InterruptedException {
		Log.info("Cusomter Details Entered");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("newCustomer")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewName")).clear();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewName")).sendKeys("Johns" + i);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewEmail")).clear();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewEmail")).sendKeys("Customer" + i + "@abcgmail.com");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewMobile")).clear();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"customerNewExt\"]")).sendKeys("91");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewMobile")).sendKeys("1234567" + i);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("addnewCustomer")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Log.info("Customer created successfully|");

	}

	@AfterTest
	public void Logout() {
		signout.Execute(driver);
		Log.info("Logout buddy :) ");
	}
}