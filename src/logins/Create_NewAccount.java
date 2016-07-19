package logins;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utility.Constant;
import appModule.signout;


public class Create_NewAccount {
	
  
	public static WebDriver driver=new FirefoxDriver();
	private static Logger Log = Logger.getLogger(Create_NewAccount.class.getName());
	
    @BeforeClass
	public void opensetmore()
	
    {
    	Log.info("Web application launched");
    	driver.get(Constant.URL);	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
    
    @Test(priority=1)
	public void createaccount()
	
	{
    	Log.info("createaccount");
		driver.findElement(By.xpath(".//*[@id='login_header']/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='name-signup']")).sendKeys("Create");
		driver.findElement(By.xpath(".//*[@id='email-signup']")).sendKeys("Create013@setmore.com");
		driver.findElement(By.xpath(".//*[@id='password-signup']")).sendKeys("setmore");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='signup-popup-form']/a")).click();
	}
    
    @Test(priority=2)
	public void businessname()
	
	{	
    	Log.info("businessname");
		driver.findElement(By.xpath(".//*[@id='setup-companyname']")).sendKeys("Business");
		driver.findElement(By.xpath(".//*[@id='industry-type']")).sendKeys("industry");
		driver.findElement(By.xpath(".//*[@id='setup-phoneNo']")).sendKeys("1234567890");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='setup-welcome-continue']")).click();	
	}
    
    @Test(priority=3)
	public void businesshours()
	
	{

//		driver.findElement(By.xpath(".//*[@id='setup-business-day-6']/span[2]")).click();
//		//driver.findElement(By.xpath("")).sendKeys("");
//		
//		//	To select and List all available options
//	Select select = new Select( driver.findElement(By.xpath(".//*[@id='setup-business-sa']/div[1]/div[1]/a")));
//	select.selectByVisibleText("09:00 AM");
//	java.util.List<WebElement> options = select.getOptions();
//	System.out.println(options.size());
//	for (int i=0; i<options.size(); i++)
//	{
//	System.out.println(options.get(i).getText());
    	
    Log.info("businesshours");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='setup-hours-continue']")).click();
	
	}

    @Test(priority=4)
	public void staff()
	
	{
    	
//	driver.findElement(By.xpath(".//*[@id='setup-staffname']")).sendKeys("Staff Two");
//	driver.findElement(By.xpath(".//*[@id='setup-staffemail']")).sendKeys("StaffTwo@StaffTwoemails.com");
//	driver.findElement(By.id("setupAddNewStaff")).click();
    Log.info("staff");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='setup-staff-continue']")).click();
	}
    
    @Test(priority=5)
	public void service()
	
	{   
    	Log.info("service");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='setup-service-continue']")).click();			
	}
    
    @Test(priority=6)
	public void calendarlink()
	
	{
    	Log.info("calendarlink");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElement(By.xpath(".//*[@id='setupContentHolder']/div/div[2]/div[1]")).click();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
    
    @AfterTest
    public void Logout()
    
    {	
    	 Log.info("Logout Buddy");
    	 signout.Execute(driver);

	}
	
    	}
	
	

