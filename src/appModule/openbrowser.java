package appModule;
import Utility.Constant;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openbrowser {

   public static void Execute(WebDriver driver)
   
  {
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get(Constant.URL);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }
      
     }