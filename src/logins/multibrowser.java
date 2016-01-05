package logins;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import java.util.logging.Logger;
import org.testng.annotations.Test;
import Utility.Reporter;

@Listeners(Reporter.class)
public class multibrowser {
 
	public WebDriver driver;
	private static Logger Log = Logger.getLogger(Log4j.class.getName());
	
  @Parameters("browser")
 
  @BeforeClass
 
  // Passing Browser parameter from TestNG xml
 
  public void beforeTest(String browser) {
 
  // If the browser is Firefox, then do this
 
  if(browser.equalsIgnoreCase("firefox")) 
  {
 
	  driver = new FirefoxDriver();
  } 
  
  else if (browser.equalsIgnoreCase("Chrome")) 
  { 
	  System.setProperty("webdriver.ie.driver","//Applications/chromedriver");
	  driver = new ChromeDriver();
	  System.out.println("ChromeDriver: is launched ");  
	  
  } 
  else if (browser.equalsIgnoreCase("Safari")) 
  {   
	  driver = new SafariDriver();
	  System.out.println("SafariDriver: is launched ");
  } 
 
 
  // Doesn't the browser type, lauch the Website
 
  driver.get("http://www.store.demoqa.com"); 
 
  }
 
  // Once Before method is completed, Test method will start
 
  @Test public void login() throws InterruptedException {
 
	driver.findElement(By.xpath(".//*[@id='account']/a")).click();
 
    driver.findElement(By.id("log")).sendKeys("testuser_1");
 
    driver.findElement(By.id("pwd")).sendKeys("Test@123");
 
    driver.findElement(By.id("login")).click();
 
	}  
 
  @AfterClass public void afterTest() {
 
		driver.quit();
 
	}
 
}