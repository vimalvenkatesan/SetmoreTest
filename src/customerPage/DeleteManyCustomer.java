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
public class DeleteManyCustomer {

	public static WebDriver driver;
	private static Logger Log = Logger.getLogger(DeleteManyCustomer.class.getName());

	@BeforeClass
	public void Login() {

		Log.info("Web application launched");
		System.setProperty("webdriver.gecko.driver", "/Users/user/Downloads/Office/EclipseRD/geckodriver");
		driver = new FirefoxDriver();
		driver.get(Constant.URL);
		Log.info("Singin started");
		driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void CustomerTab() {

		driver.findElement(By.xpath(".//*[@id='side-nav-customers']")).click();
		Log.info("cusotmer Tab Clicked ");
	}

	@Test(priority = 2)
	public void Deletecustomer_Many()

	{
		driver.navigate().refresh();
		Log.info("Delete many customer");

		// Delete a many customers
		java.util.List<org.openqa.selenium.WebElement> checkbox = driver
				.findElements(By.className("jqTransformCheckbox"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int limit = 2;
		for (int i = 0; i < limit; i++) {
			checkbox.get(i).click();

			System.out.println(" Customter" + i + "ToDelte Selected");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath(".//*[@id='deleteAllCustomer']")).click();
		driver.findElement(By.xpath(".//*[@id='deleteSelectedCustomer']")).click();
		System.out.println(" deleteAllCustomer Successfully");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void Logout() {
		signout.Execute(driver);
		Log.info("Logout buddy :) ");
	}
}
