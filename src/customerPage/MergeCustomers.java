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
			public class MergeCustomers {
			
			
			
			public static WebDriver driver=new FirefoxDriver();
			private static Logger Log = Logger.getLogger(MergeCustomers.class.getName());
			
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
			Log.info("cusotmer Tab Clicked ");
			 }
			
		
		    @Test(priority=2)
			 public void mergecustomers() throws InterruptedException 
		     {
		     
		     Log.info("mergecustomers");
		     driver.navigate().refresh();
			 
			//mergecustomerscustomers
			 java.util.List<org.openqa.selenium.WebElement> checkbox=driver.findElements(By.className("jqTransformCheckbox"));
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				       
				int limit = 2;
				for (int i = 0; i < limit; i++) {
					checkbox.get(i).click();
					
			 System.out.println(" Cutomer" + i + " ToMergeSelected");
			}
				
//				 try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e){
//						// TODO Auto-generated catch block
//					e.printStackTrace();
//				}			
			 
		    driver.findElement(By.xpath(".//*[@id='mergeAllCustomer']")).click();
			driver.findElement(By.xpath(".//*[@id='MergeSelectedCustomer']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
		//	driver.findElement(By.xpath(".//*[@id='alertContent']")).click();	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath(".//*[@id='mergeCustomer_Okay']")).click();	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Customers Merged successfully");
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				}


		    @AfterTest
		    public void Logout()
		    {	
		    signout.Execute(driver);
		    Log.info("Logout buddy :) ");
	}	   
	}
