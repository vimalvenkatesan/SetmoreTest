package customerPage;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.mail.handlers.image_jpeg;

import LearningSection.uploadCsv;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utility.Constant;
import Utility.CreateScreenshot;
import Utility.Reporter;
import appModule.signout;

@Listeners(Reporter.class)
public class CustomerPageFull {

	ExtentReports report;
	ExtentTest logger1;
	WebDriver driver;
	String filepath = "/Users/user/Downloads/SampleCSVFile_11kb.csv";
	// public static WebDriver driver=new FirefoxDriver();

	private static Logger Log = Logger.getLogger(CustomerPageFull.class.getName());

	@BeforeClass
	public void Login() {
		report = new ExtentReports("/Users/user/Downloads/Xslt_reports/customerpage.html");
		logger1 = report.startTest("CustomerPage Full results");
		Log.info("Web application launched");
		System.setProperty("webdriver.gecko.driver", "//Users//user//Downloads//EclipseSeleniumJava//geckodriver");
		driver = new FirefoxDriver();
		driver.get(Constant.URL);
		Log.info("Signin started");
		driver.findElement(By.id("username")).sendKeys("homework@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void CustomerTab() {

		driver.findElement(By.xpath(".//*[@id='headerNav']/ul/li[4]/a")).click();
		Log.info("cusotmer Header Clicked ");
	}

	@Test(priority = 1)
	public void CreateCustomer() {
		Log.info("Create cusotmer");

		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		int customerCount = 3;

		for (int i = 1; i <= customerCount; i++) {
			System.out.println(" Customer created No::" + i);
			// if (i != 4)
			{
				try {
					CustomerInput(i);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	@Test
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
		driver.findElement(By.id("customerNewEmail")).sendKeys("Customer" + i + "@holidaygmail.com");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewMobile")).clear();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("customerNewMobile")).sendKeys("1234567" + i);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("addnewCustomer")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Log.info("Customer created successfully|");

	}

	@Test(priority = 2)
	public void DeleteCusotmer() {

		Log.info("Delete a customer");
		driver.navigate().refresh();

		if (driver.findElement(By.xpath(".//*[@id='cancelNewCustomer']")).isDisplayed())

		{
			driver.findElement(By.xpath(".//*[@id='cancelNewCustomer']")).click();
		}

		// Delete a customer
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[4]/ul/li[1]/code")).click();
		driver.findElement(By.className("delete_btn")).click();
		driver.findElement(By.xpath(".//*[@id='delete-confirmation-btn']")).click();
		System.out.println("Customer Deleted Successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 3)
	public void Deletecustomer_Many()

	{
		driver.navigate().refresh();
		Log.info("Delete many customer");
		driver.navigate().refresh();

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

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void mergecustomers() {

		Log.info("mergecustomers");
		// driver.navigate().refresh();

		// mergecustomerscustomers
		java.util.List<org.openqa.selenium.WebElement> checkbox = driver
				.findElements(By.className("jqTransformCheckbox"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int limit = 2;
		for (int i = 0; i < limit; i++) {
			checkbox.get(i).click();

			System.out.println(" Cutomer" + i + " ToMergeSelected");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("mergeAllCustomer")).click();
		driver.findElement(By.id("MergeSelectedCustomer")).click();

		driver.findElement(By.xpath(".//*[@id='alertContent']")).click();
		driver.findElement(By.xpath(".//*[@id='mergeCustomer_Okay']")).click();
		System.out.println("Customers Merged successfully");

	}

	@Test(priority = 5)
	public void Importcusotmer() {
		Log.info("Import Cusotmer ");

		String handle = driver.getWindowHandle();
		System.out.println(handle);

		driver.findElement(By.xpath("//div[@id='sortLabel']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]")));
		// // until this submenu is found

		// identify menu option from the resulting menu display and click
		WebElement menuOption = driver
				.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]"));
		menuOption.click();

		WebElement Googleimport = driver.findElement(By.id("importGoogleContacts"));
		Googleimport.click();

		java.util.Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);
			driver.switchTo().window(handle1);

		}

		// driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.findElement(By.xpath(" .//*[@id='account-chooser-add-account']"));

		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='Email']")));

		WebElement Emailbutton = driver.findElement(By.xpath(".//*[@id='Email']"));
		Emailbutton.click();

		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("JohnCena");
		driver.findElement(By.id("signIn")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Allowaccess = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/form/button[1]"));
		Allowaccess.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(handle);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("check1");
		driver.findElement(By.xpath(".//*[@id='import-window']")).click();
		driver.findElement(By.xpath(".//*[@id='AddCustomerInFile']")).click();
		driver.findElement(By.xpath(".//*[@id='alertbox']")).click();
		driver.findElement(By.xpath(".//*[@id='alertOk']")).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// driver.switchTo().defaultContent();

		// driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		// WebElement closebutton =
		// driver.findElement(By.xpath(".//*[@id='import-window']/div[1]"));
		// closebutton.click();
	}

	@Test(priority = 6)
	public void ExportCustomer() {

		Log.info("Start Export Cusotmer ");
		driver.navigate().refresh();

		driver.findElement(By.xpath("//div[@id='sortLabel']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// identify menu option from the resulting menu display and click
		WebElement ExportOption = driver
				.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[4]"));
		ExportOption.click();

		driver.findElement(By.xpath(".//*[@id='alertbox']")).click();
		driver.findElement(By.xpath(".//*[@id='alertOk']")).click();
		System.out.println("Customers Merged successfully");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 7)
	public void ConnectMailChimp() throws InterruptedException {

		Log.info("start ConnectToMailChimp");
		driver.navigate().refresh();

		String firstwindow = driver.getWindowHandle();
		System.out.println(firstwindow);

		java.util.List<org.openqa.selenium.WebElement> checkbox = driver
				.findElements(By.className("jqTransformCheckbox"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		int limit = 2;
		for (int i = 0; i < limit; i++) {
			checkbox.get(i).click();

			System.out.println(" Cutomer" + i + " ToExport_in_mailchimp");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.id("exportToMailChimp")).click();
		driver.findElement(By.id("mailchimp-connect")).click();

		java.util.Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		Thread.sleep(3000);

		// driver.findElement(By.xpath(".//*[@id='content']")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='username']")));

		WebElement username = driver.findElement(By.xpath(".//*[@id='username']"));
		username.click();

		Log.info("Login to Mailchimp");
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("setmore");

		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("JohnCena^7");
		driver.findElement(By.xpath(".//*[@id='login-form']/fieldset/div[3]/input")).click();
		driver.switchTo().window(firstwindow);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// if(driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).isDisplayed())
		// {
		// driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
		// }
		//
		//// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//
		// if(driver.findElement(By.id(".//*[@id='login-form']/fieldset/div[4]/input")).isDisplayed())
		// {
		// driver.findElement(By.id(".//*[@id='login-form']/fieldset/div[4]/input")).click();
		// }

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(".//*[@id='customerContent']/div[4]/div")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[4]/div/div/ul/li[2]"))
				.isDisplayed()) {
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[4]/div/div/ul/li[2]")).click();
		}

		driver.findElement(By.xpath(".//*[@id='matchfield-FirstName']/label")).click();
		driver.findElement(By.xpath(".//*[@id='matchfield-FirstName']/div[1]")).click();
		driver.findElement(
				By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[4]/div/div/ul/li[1]/div[1]/ul/li[1]/ul/li[1]"))
				.click();
		driver.findElement(By.xpath(".//*[@id='matchfield-LastName']/label")).click();
		driver.findElement(By.xpath(".//*[@id='matchfield-LastName']/div[1]")).click();
		driver.findElement(By.xpath(".//*[@id='matchfield-LastName']/div[1]/ul/li[1]/ul/li[2]")).click();

		driver.findElement(By.xpath(".//*[@id='renderConfirmView']")).click();

		driver.findElement(By.xpath(".//*[@id='addCutomerToMailChimp']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void BookCustomer() {
		Log.info("Book customer");
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createAppt']")));

		WebElement Bookappt = driver.findElement(By.xpath(" .//*[@id='createAppt']"));
		Bookappt.click();

		// click service scroll
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div[2]/div[3]/ul/li[2]/div[1]/a")).click();
		// Select service
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div[2]/div[3]/ul/li[2]/div[1]/ul/li[1]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// click continue
		driver.findElement(By.xpath(".//*[@id='dup-appt-save-btn']")).click();

		Log.info("Booked Appointment");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)

	public void Uploadcsvfilecontacts() throws IOException {

		Log.info("Upload CSV file Method runs ");

		String handle = driver.getWindowHandle();
		System.out.println(handle);

		driver.findElement(By.xpath("//div[@id='sortLabel']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// until this submenu is found

		// identify menu option from the resulting menu display and click
		WebElement menuOption = driver
				.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]"));
		menuOption.click();

		WebElement Csvupload_link = driver.findElement(By.xpath(".//*[@id='importCSVContacts']/div"));
		Csvupload_link.click();

		// Runtime.getRuntime().exec("osascript"+"//Users/user/Desktop/Applescr.scpt");

		Runtime runtime = Runtime.getRuntime();
		String applescriptCommand = "tell app\"System Events\"\n" +

				"keystroke\"G\" using {command down, Shift down}\n" + "delay 2\n" + "keystroke\"" + filepath + "\"\n"
				+ "delay 1\n" + "keystroke return\n" + "delay 1\n" + "keystroke return\n" + "end tell";

		String[] args = { "osascript", "-e", applescriptCommand };
		Process process = runtime.exec(args);

		System.out.println("First name");
		driver.findElement(By.xpath(".//*[@id='import-window']")).click();
		driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[2]/div/a")).click();
		driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[2]/div/ul/li[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[4]/div/a")).click();
		// driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[4]/div/ul/li[3]")).click();
		System.out.println("Import contacts");
		driver.findElement(By.xpath(".//*[@id='AddCustomerInFile']")).click();
		// driver.findElement(By.xpath("")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Imported csv contacts successfully");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("alertbox")).click();

		driver.findElement(By.id("alertClose")).click();

	}

	@AfterTest
	public void Logout() {
		signout.Execute(driver);
		Log.info("Logout buddy :) ");

	}

	@AfterMethod
	public void tearDown(ITestResult result)

	{
		if (result.getStatus() == ITestResult.FAILURE)

		{
			String path = CreateScreenshot.snap(driver, result.getName());
			String image_jpeg = logger1.addScreenCapture(path);
			logger1.log(LogStatus.FAIL, "Final Result", image_jpeg);
		}

		report.endTest(logger1);
		report.flush();

		driver.get("/Users/user/Downloads/Xslt_reports/customerpage.html");

	}
}
