package SettingsPage;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utility.Constant;
import Utility.Reporter;
@Listeners(Reporter.class)
public class singlesession {
	//WebDriverWait(driver,5000);
	
	    WebDriverWait wait=new  WebDriverWait(driver,30);

	
	    public static WebDriver driver=new FirefoxDriver();
	    private static Logger Log = Logger.getLogger(singlesession.class.getName());
	
	    @BeforeClass
		public void Login()
		{
	    	
	    Log.info("Web application launched");
		
		driver.get(Constant.URL);
		Log.info("Singin started");
		driver.findElement(By.id("username")).sendKeys("sports@setmore.com");
		driver.findElement(By.id("password")).sendKeys("setmore");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
        }
	    
	    @Test(priority=1)
	    public void SettingsTab()
	    {	
		 
	     Log.info("Settings Tab Clicked ");     
	     driver.findElement(By.xpath(".//*[@id='settings_new']/a")).click();
	     WebElement ele = driver.findElement(By.xpath(".//*[@id='settings_new']/ul/li[4]/a/div[2]"));
	     Actions Builder=new Actions(driver);
	     Builder.click(ele).perform();
	    
	
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    
	    
	    
		@Test(priority=2)
	    public void createservices() throws InterruptedException
	    { 
	    	
	    Log.info("Create class");  
	    //Boolean isPresent = driver.findElements(By.xpath(".//*[@id='noClass']/button")).size() > 0;   
	    // System.out.println(isPresent);
    
	    if(driver.findElements(By.xpath(".//*[@id='noClass']/button")).size() > 0){
	  
	    	driver.findElement(By.xpath(".//*[@id='noClass']/button")).click();
    
	    
	    driver.findElement(By.xpath(".//*[@id='class_title']")).click();
	    driver.findElement(By.xpath(".//*[@id='class_title']")).sendKeys("Class One");
	  
	    
	    driver.findElement(By.xpath(".//*[@id='class_cost']")).click();
	    driver.findElement(By.xpath(".//*[@id='class_cost']")).clear();
	    driver.findElement(By.xpath(".//*[@id='class_cost']")).sendKeys("100");
	  
	    
	    driver.findElement(By.xpath(".//*[@id='class_duration']")).click();
	    driver.findElement(By.xpath(".//*[@id='class_duration']")).sendKeys("15");
	    
	    
	    driver.findElement(By.xpath(".//*[@id='class_slots']")).click();
	    driver.findElement(By.xpath(".//*[@id='class_duration']")).sendKeys("100");
	   
	    
	    driver.findElement(By.xpath(".//*[@id='saveNewClass']")).click();
	    
	    
	    }else
	    	
	    {
	    	
	    //Click class id 
	    driver.findElement(By.xpath(".//*[@id='caa90c1470897188384']/div[3]")).click(); 
	    
	    for(int j = 1; j <= 3; j++)
	    {
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addClassSession']")));    
	    driver.findElement(By.xpath(".//*[@id='addClassSession']")).click();
	    Thread.sleep(10000);
	    
	    //Update seats
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[6]/input")));
	    driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[6]/input")).click();  
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[6]/input")).clear();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[6]/input")).sendKeys("10000");
	    Thread.sleep(2000);
	  
	    //Click Never select Box
	    // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]")).click();
	    driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li/div[1]")).click();
	   
	        try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	        
	        //Click Daily
	   
	     System.out.println("Click  Daily"); 
	    /*driver.findElement(By.xpath(".//*[@id='repeatType-daily']")).click();
	     driver.findElement(By.xpath(".//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li[3]/div[1]")).click();*/
	    
	    driver.findElement(By.xpath("//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li/div[1]/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li/div[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='repeatType-daily']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id='editClassApptPopup']/div[2]/ul/li[5]/div[1]/ul/li[3]/div[1]")).click();
	    Thread.sleep(2000);
	   
	    List<WebElement> datepickers =	driver.findElements(By.className("datepicker"));
	    
	    for(WebElement elem : datepickers)
	    {
	    	System.out.println(elem.getAttribute("id"));
	    }
	      WebElement lastPicker	=	 datepickers.get(datepickers.size()  - 1);
	      System.out.println(lastPicker.getAttribute("id"));
	      WebElement nextArrow	=   lastPicker.findElement(By.xpath(".//div[@class='datepickerContainer']/table/tbody/tr/td/table/thead/tr[1]/th[3]/a"));
	    
	      
	      for(int i = 1; i <= 30;i++)
	      {
	    	  nextArrow.click();
	      }														 
	  //    WebElement date30May = lastPicker.findElement(By.xpath(".//div[@class='datepickerContainer']/table/tbody/tr/td/table/tbody[2]/tr[4]/td[2]"));
	      
	      WebElement July = lastPicker.findElement(By.xpath(".//div[@class='datepickerContainer']/table/tbody/tr/td/table/tbody[2]/tr[5]/td[3]/a"));
	      July.click();
	      
	    //Save;
	    driver.findElement(By.className("class-popup-details-save-btn")).click();
	    System.out.println("Booking in process");
	    Thread.sleep(120000);
	    System.out.println("Next Iterations");
	  
	    }
	    
	    }
	   
	    }
}
