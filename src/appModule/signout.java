package appModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class signout {
	   
	
public static void Execute(WebDriver driver){ 
	
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
driver.findElement(By.id("account_menu")).click();
WebElement ele = driver.findElement(By.xpath("//li[@id='sign_out']/a/div"));
Actions Builder=new Actions(driver);
Builder.click(ele).perform();

try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

}
}
}