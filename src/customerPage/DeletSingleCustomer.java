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
			public class DeletSingleCustomer {
			
			
			
			public static WebDriver driver=new FirefoxDriver();
			private static Logger Log = Logger.getLogger(DeletSingleCustomer.class.getName());
			
		    @BeforeClass
			public void Login()
			{
		    	
		    Log.info("Web application launched");

			
			driver.get(Constant.URL);
			Log.info("Singin started");
			driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
			driver.findElement(By.id("password")).sendKeys("setmore");
			driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
				
			}
			
			@Test(priority=1)
			public void CustomerTab()
			 {	
				
			driver.findElement(By.xpath(".//*[@id='headerNav']/ul/li[4]/a")).click();
			Log.info("cusotmer Tab Clicked ");
			 }
			
			@Test(priority=2)
			public void DeleteCusotmer()
			 {
		
			Log.info("Delete a customer");
			driver.navigate().refresh();
			 
			//Delete a customer
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[4]/ul/li[1]/code")).click();		
			driver.findElement(By.className("delete_btn")).click();
			driver.findElement(By.xpath(".//*[@id='delete-confirmation-btn']")).click();
			System.out.println("Customer Deleted Successfully");
			
			
			 try
			 {
					Thread.sleep(3000);
			 } 
			 catch (InterruptedException e) 
			 {
				e.printStackTrace();
			 }
	       
			 }

		    @AfterTest
		    public void Logout()
		    {	
		    signout.Execute(driver);
		    Log.info("Logout buddy :) ");
	}	   
	}
