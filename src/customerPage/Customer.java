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
			public class Customer {
			
			
			
			public static WebDriver driver=new FirefoxDriver();
			private static Logger Log = Logger.getLogger(Customer.class.getName());
			
		    @BeforeClass
			public void Login()
			{
		    	
		    Log.info("Web application launched");
			// driver.get("https://www.setmore.com/");
			//driver.get("https://my.setmore.com/");
			//driver.get("https://staging.setmore.com");
			//driver.get(Constant.Staging_URL);
			
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
			public void CreateCustomer()
			 { 
			 Log.info("Create cusotmer");
				
				
//				 try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				
			int apptCount = 4;
			
			for (int i = 1; i <= apptCount; i++) 
			{	
				System.out.println(" Customer created No::" + i);
			if (i != 4) 
			{
				try 
				{
					CustomerInput( i ); 
					
				} catch (InterruptedException e)
				{
				  e.printStackTrace();
				}
			   }
			
		      }
	        }
			
			@Test
			public void CustomerInput( int i ) throws InterruptedException 
			{
			Log.info("Cusomter Details Entered");
			
			driver.findElement(By.id("newCustomer")).click();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customerNewName")).clear();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customerNewName")).sendKeys("Johns"+i);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customerNewEmail")).clear();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
			driver.findElement(By.id("customerNewEmail")).sendKeys("Customer"+i+"@holidaygmail.com");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customerNewMobile")).clear();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("customerNewMobile")).sendKeys("1234567"+i);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("addnewCustomer")).click();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Log.info("Customer created successfully|");
			
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
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			 }
			   
					
		    @Test(priority=3)
			public void Deletecustomer_Many()
			
	       {
		    driver.navigate().refresh();
		    Log.info("Delete many customer");
			
			//Delete a many customers
			java.util.List<org.openqa.selenium.WebElement> checkbox=driver.findElements(By.className("jqTransformCheckbox"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					       
					int limit = 2;
					for (int i = 0; i < limit; i++) {
						checkbox.get(i).click();
						
			 System.out.println(" Customter" + i + "ToDelte Selected");
			 }
					
			 try
			 {
					Thread.sleep(3000);
			 } 
			 catch (InterruptedException e) 
			 {
				e.printStackTrace();
			 }			
				 
			 driver.findElement(By.xpath(".//*[@id='deleteAllCustomer']")).click();
			 driver.findElement(By.xpath(".//*[@id='deleteSelectedCustomer']")).click();							
			 System.out.println(" deleteAllCustomer Successfully");
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			     }
			 
			    
		    @Test(priority=4)
			 public void mergecustomers() 
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
				
				 try {
						Thread.sleep(3000);
					} catch (InterruptedException e){
						// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			 
		    driver.findElement(By.id("mergeAllCustomer")).click();
			driver.findElement(By.id("MergeSelectedCustomer")).click();
			
			
			driver.findElement(By.xpath(".//*[@id='alertContent']")).click();						
			driver.findElement(By.xpath(".//*[@id='mergeCustomer_Okay']")).click();					
			System.out.println("Customers Merged successfully");
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				}
			    
			  
		    @Test(priority=5)
		    public void ImportCustomer(){
			    
			 Log.info("Import Cusotmer ");
			 driver.navigate().refresh();
			 
			 String handle= driver.getWindowHandle();
		     System.out.println(handle);
		        
			 driver.findElement(By.xpath("//div[@id='sortLabel']")).click();
			 try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
               //WebDriverWait wait = new WebDriverWait(driver, 5); 
               //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]")));  // until this submenu is found

				//identify menu option from the resulting menu display and click
				WebElement Importmenu = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]"));
				Importmenu.click();
		
			    WebElement Googleimport = driver.findElement(By.id("importGoogleContacts"));
			    Googleimport.click();
			    
			    java.util.Set<String> handles = driver.getWindowHandles();
			    System.out.println(handles); 
			    
			    for (String handle1 : driver.getWindowHandles())
			    {

		        System.out.println(handle1);
	        	driver.switchTo().window(handle1);

		        }
			    
				//driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
			    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    //driver.findElement(By.xpath(" .//*[@id='account-chooser-add-account']"));
			    
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
			   	    
			    //driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
			    WebElement closebutton = driver.findElement(By.xpath(".//*[@id='import-window']/div[1]"));
			    closebutton.click();
		 }
		 
		    @Test(priority=6)
		    public void ExportCustomer(){
			    
				 Log.info("Export Cusotmer ");
				 driver.navigate().refresh();
			        
				 driver.findElement(By.xpath("//div[@id='sortLabel']")).click();
				 try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

					//identify menu option from the resulting menu display and click 
					WebElement ExportOption = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[4]"));
					ExportOption.click();
		    
					
					driver.findElement(By.xpath(".//*[@id='alertbox']")).click();						
					driver.findElement(By.xpath(".//*[@id='alertOk']")).click();					
					System.out.println("Customers Merged successfully");
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
						}
		    
		    
				    @AfterTest
				    public void Logout()
				    {	
				    signout.Execute(driver);
				    Log.info("Logout buddy :) ");
			}	   
			}
