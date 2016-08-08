package LearningSection;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.apache.jasper.tagplugins.jstl.core.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utility.Constant;
import Utility.Reporter;
import appModule.signout;
import Utility.Reporter;

@Listeners(Reporter.class)
public class uploadCsv {
	
	  	String filepath = "/Users/user/Downloads/SampleCSVFile_11kb.csv";
	    public static WebDriver driver=new FirefoxDriver();
     	private static Logger Log = Logger.getLogger(uploadCsv.class.getName());
	
	
	  @BeforeClass
		public void opensetmore()
		{
	    	Log.info("Web application launched");	    	
	    	driver.get(Constant.URL);
	    	driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
	    	driver.findElement(By.id("password")).sendKeys("setmore");
	    	driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
	  @Test(priority=1)
	    public void one()
	     {
		driver.findElement(By.xpath(".//*[@id='headerNav']/ul/li[4]/a")).click();
		Log.info("cusotmer Tab Clicked ");
	     }
	    

	 @Test(priority=2)
	    public void two() throws IOException{
	    
		 Log.info("Upload CSV file Method runs ");
		 
		 String handle= driver.getWindowHandle();
	        System.out.println(handle);
	        
		 driver.findElement(By.xpath("//div[@id='sortLabel']")).click();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          // until this submenu is found

			//identify menu option from the resulting menu display and click
			WebElement menuOption = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]"));
			menuOption.click();
	
		    WebElement Csvupload_link = driver.findElement(By.xpath(".//*[@id='importCSVContacts']/div"));
		    Csvupload_link.click();
		    
		    
		//	Runtime.getRuntime().exec("osascript"+"//Users/user/Desktop/Applescr.scpt");
		    
		Runtime runtime = Runtime.getRuntime();
		String applescriptCommand = "tell app\"System Events\"\n"+
	
				"keystroke\"G\" using {command down, Shift down}\n"+
				"delay 2\n" +
				"keystroke\""+filepath+"\"\n" +
				"delay 1\n" +
				"keystroke return\n" +
				"delay 1\n" +
				"keystroke return\n" +
				"end tell";
				
				String[]args = {"osascript", "-e",applescriptCommand};
		        Process process =runtime.exec(args);
		
				

//
//		    try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    
		    
		    System.out.println("First name");
			  driver.findElement(By.xpath(".//*[@id='import-window']")).click();
			  driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[2]/div/a")).click();
			  driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[2]/div/ul/li[2]")).click();
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
//			  System.out.println("Last name");
//			  driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[4]/div/a")).click();
//			  driver.findElement(By.xpath(".//*[@id='import-window']/div[2]/ul[1]/li/div[4]/div/ul/li[3]")).click();
			  System.out.println("Import contacts");
			  driver.findElement(By.xpath(".//*[@id='AddCustomerInFile']")).click();
//			  driver.findElement(By.xpath("")).click();
			 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		 		
	    	System.out.println("Click Import contacts");
		    driver.findElement(By.xpath(".//*[@id='AddCustomerInFile']")).click(); 
		    
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    driver.findElement(By.xpath(".//*[@id='alertContent']")).click();
		    driver.findElement(By.id("alertOk")).click();
		    		    
		    try {
				Thread.sleep(3000);
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
	  