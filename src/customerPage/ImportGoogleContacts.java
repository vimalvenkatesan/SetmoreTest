package customerPage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utility.Constant;
import Utility.Reporter;
import appModule.signout;
import Utility.Reporter;

@Listeners(Reporter.class)
public class ImportGoogleContacts {
	  
	    public static WebDriver driver=new FirefoxDriver();
     	private static Logger Log = Logger.getLogger(CustomerPageFull.class.getName());
	
	
	  @BeforeClass
		public void opensetmore()
		{
	    	Log.info("Web application launched");
		  //driver.get("https://www.setmore.com/");
		  //driver.get("https://my.setmore.com/");
          //driver.get("https://staging.setmore.com");
          //driver.get(Constant.Staging_URL);
	    	
	    	driver.get(Constant.URL);
	    	driver.findElement(By.id("username")).sendKeys("jacksrone@gmail.com");
	    	driver.findElement(By.id("password")).sendKeys("Setmore");
	    	driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}
	  @Test(priority=1)
	    public void one()
	     {
		driver.findElement(By.xpath(".//*[@id='side-nav-customers']")).click();
		Log.info("cusotmer Tab Clicked ");
	     }
	    

	 @Test(priority=2)
	    public void two(){
	    
		 Log.info("Import Cusotmer ");
		 
		 String handle= driver.getWindowHandle();
	        System.out.println(handle);
	        
		 driver.findElement(By.xpath(".//*[@id='sortLabel']")).click();
//		 try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		 
		 //identify menu option from the resulting menu display and click
//			WebElement menuOption = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]/div/div[1]/div[1]/div[3]/div[2]/ul/li[3]"));
//			menuOption.click();
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[5]/div[1]/div[1]/div[1]/div[3]/div[2]/ul[1]/li[3]")).click();
			
	
		    WebElement Googleimport = driver.findElement(By.id("importGoogleContacts"));
		    Googleimport.click();
		    
		    java.util.Set<String> handles = driver.getWindowHandles();
		    System.out.println(handles); 
		    
		    for (String handle1 : driver.getWindowHandles())
		    {

	        System.out.println(handle1);
        	driver.switchTo().window(handle1);

	        }
		    
		    
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
		
	 

//		    @AfterClass
//		    public void Logout()
//		    {	
//		    signout.Execute(driver);
//		    Log.info("Logout buddy :) ");
//			}	   
}	   } 
	  