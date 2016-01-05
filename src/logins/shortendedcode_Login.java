package logins;

import org.testng.annotations.Test;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import appModule.sigin;
import appModule.signout;
import Utility.Constant;
import Utility.Reporter;

@Listeners(Reporter.class)
public class shortendedcode_Login {
	
	private static Logger Log = Logger.getLogger(Log4j.class.getName());
    private static WebDriver driver;
    
	@BeforeTest
	public void login()
    {	
     driver=new FirefoxDriver();	     
    }
	
	@Test
	public void login1()
	{
    sigin.Execute(driver,Constant.Username,Constant.Password);
	}
	

    @AfterTest
    public void Logout()
    
    {	
    signout.Execute(driver);
	}
	
    }
  
  