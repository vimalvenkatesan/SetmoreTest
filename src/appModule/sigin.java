package appModule;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.Constant;
import pageObjects.SetmoreLoginPage;

public class sigin {
   
    public static void Execute(WebDriver driver, String sUsername, String sPassword)
   { 
//    	Log.info("Lets Sign_in");
//  driver = new FirefoxDriver();
    driver.get(Constant.URL);
	driver.manage().window().maximize();
	
  
    SetmoreLoginPage.UserName(driver).sendKeys(sUsername);
    SetmoreLoginPage.Pwd(driver).sendKeys(sPassword);
    //driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
    SetmoreLoginPage.Sign_in(driver).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    }
  }
