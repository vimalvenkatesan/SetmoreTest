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
		public class Bookcustomer {
		
		
		
		public static WebDriver driver=new FirefoxDriver();
		private static Logger Log = Logger.getLogger(Bookcustomer.class.getName());
		
		@BeforeClass
		public void Login()
		{
			
		Log.info("Web application launched");
		
		driver.get(Constant.URL);
		Log.info("Singin started");
		driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Setmore");
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
		}
		
		@Test(priority=1)
		public void CustomerTab()
		 {	
			
		driver.findElement(By.xpath(".//*[@id='side-nav-customers']")).click();
		Log.info("customer Tab Clicked ");
		 }
		
		@Test(priority=2)
		public void BookCustomer()
		 { 
		 Log.info("Book customer");
		 
		 WebDriverWait wait = new WebDriverWait(driver, 5); 
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='createAppt']")));  
		 
		WebElement Bookappt = driver.findElement(By.xpath(" .//*[@id='createAppt']"));
		Bookappt.click();
		
		//click service scroll        
		 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[3]/ul/li[2]/div[1]/a")).click();
		//Select service 
		 driver.findElement(By.xpath(".//*[@id='editApptPopup']/div[3]/ul/li[2]/div[1]/ul")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  //click continue
		 driver.findElement(By.xpath(".//*[@id='dup-appt-save-btn']")).click();
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
			