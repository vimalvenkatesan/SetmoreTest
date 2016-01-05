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
			public class ExportMailChimp {
			
			
			
			public static WebDriver driver=new FirefoxDriver();
			private static Logger Log = Logger.getLogger(ExportMailChimp.class.getName());
			
		    @BeforeClass
			public void Login()
			{
		    	
		    Log.info("Web application launched");
	
			
			driver.get(Constant.URL);
			Log.info("Singin started");
			driver.findElement(By.id("username")).sendKeys("sports@setmore.com");
			driver.findElement(By.id("password")).sendKeys("setmore");
			driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
				
			}
			
			@Test(priority=1)
			public void CustomerTab()
			 {	
				
			driver.findElement(By.xpath(".//*[@id='headerNav']/ul/li[4]/a")).click();
			Log.info("cusotmer Tab Clicked ");
			 }
			
			@Test(priority=2)
			 public void mergecustomers() 
		     {
		     
		     Log.info("ExportCustomers");
		     driver.navigate().refresh();		 

			 String handle= driver.getWindowHandle();
		     System.out.println(handle);
		     
			 java.util.List<org.openqa.selenium.WebElement> checkbox=driver.findElements(By.className("jqTransformCheckbox"));
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				       
				int limit = 2;
				for (int i = 0; i < limit; i++) {
					checkbox.get(i).click();
					
			 System.out.println(" Cutomer" + i + " ToExport_in_mailchimp");
			}
				
				 try {
						Thread.sleep(3000);
					} catch (InterruptedException e){
						// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			 
		    driver.findElement(By.id("exportToMailChimp")).click();
			driver.findElement(By.id("mailchimp-connect")).click();
			
			 java.util.Set<String> handles = driver.getWindowHandles();
			    System.out.println(handles); 
			    
			    for (String handle1 : driver.getWindowHandles())
			    {

		        System.out.println(handle1);
	        	driver.switchTo().window(handle1);

		        }
			    
			    WebDriverWait wait1 = new WebDriverWait(driver, 5); 
	     		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("username']")));
	     		WebElement Emailbutton = driver.findElement(By.id("username']"));
	     		Emailbutton.click();
			
	     		driver.findElement(By.id("Email")).clear();
			    driver.findElement(By.id("Email")).sendKeys("setmore");
			   
			    driver.findElement(By.id("password")).clear();
			    driver.findElement(By.id("password")).sendKeys("JohnCena^7");
			    driver.findElement(By.xpath(".//*[@id='login-form']/fieldset/div[3]/input")).click();
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	   
			  	
				  if(driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).isDisplayed())						  
						driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
				  
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				

				  if(driver.findElement(By.id(".//*[@id='login-form']/fieldset/div[4]/input")).isDisplayed())						  
						driver.findElement(By.id(".//*[@id='login-form']/fieldset/div[4]/input")).click();

				  
				  
				  
				  if(driver.findElement(By.xpath("mailchimplist_0")).isDisplayed())						  
						driver.findElement(By.xpath("mailchimplist_0")).click();
				  
				  driver.switchTo().window(handle); 
				  
				  driver.findElement(By.id("matchfield-FirstName")).click();
				  driver.findElement(By.xpath(".//*[@id='matchfield-FirstName']/div[1]/ul/li[1]/ul/li[1]")).click();
				  driver.findElement(By.id("matchfield-LastName")).click();
				  driver.findElement(By.xpath(".//*[@id='matchfield-LastName']/div[1]/ul/li[1]/ul/li[2]")).click();
				  
				  driver.findElement(By.xpath(".//*[@id='renderConfirmView']")).click();
				  
				  driver.findElement(By.xpath(".//*[@id='addCutomerToMailChimp']")).click();
		     }
			
		    @AfterTest
		    public void Logout()
		    {	
		    signout.Execute(driver);
		    Log.info("Logout buddy :) ");
	}	   
	}