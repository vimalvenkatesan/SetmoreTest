package Appium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class testing {
	WebDriver driver;

	@BeforeMethod
	@BeforeClass
    public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "5.1"); 
		capabilities.setCapability("deviceName","9396aa06");
		capabilities.setCapability("platformName","Android"); 
	    capabilities.setCapability("appPackage", "com.adaptavant.setmore");
	    capabilities.setCapability("appActivity", "com.adaptavant.setmore.ui.StartActivity");
	    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       
}

    
@Test(priority=1)

public void login(){
	driver.findElement(By.id("com.adaptavant.setmore:id/Setmore_LoginButton")).click();

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	driver.findElement(By.id("com.adaptavant.setmore:id/Login_Email")).sendKeys("jacksrone@gmail.com");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	driver.findElement(By.id("com.adaptavant.setmore:id/Login_Password")).sendKeys("setmore");

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	driver.findElement(By.id("com.adaptavant.setmore:id/remember_me")).click();

	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	driver.findElement(By.id("com.adaptavant.setmore:id/Login_LoginButton")).click();
	try {
		Thread.sleep(6000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Test(priority=2)
public void NewCustomedr(){


driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_addmenu")).click();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

driver.findElement(By.id("com.adaptavant.setmore:id/create_newappointment")).click();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[contains(@text, 'All Services')]")).click();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.Button[2]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).click();
HashMap<String, Integer> tapObject = new HashMap<String, Integer>();
//r
tapObject.put("x", 267); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//e
tapObject.put("x", 193); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//n
tapObject.put("x", 541); // in pixels from left
tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[3]")).click();
//s
tapObject.put("x", 154); // in pixels from left

tapObject.put("y", 880); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//a
tapObject.put("x", 78); // in pixels from left

tapObject.put("y", 880); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//t
tapObject.put("x", 343); // in pixels from left

tapObject.put("y", 760); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

//@
tapObject.put("x", 150); // in pixels from left

tapObject.put("y", 1117); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

//r
tapObject.put("x", 267); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//e
tapObject.put("x", 193); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//n
tapObject.put("x", 541); // in pixels from left
tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//.
tapObject.put("x", 615); // in pixels from left

tapObject.put("y", 1121); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//c
tapObject.put("x", 302); // in pixels from left

tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//o
tapObject.put("x", 648); // in pixels from left

tapObject.put("y", 760); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//m
tapObject.put("x", 613); // in pixels from left

tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

((AppiumDriver) driver).hideKeyboard();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.TextView[2]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.Button[1]")).click();
try {
	Thread.sleep(12000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}



@Test(priority=2)
public void NewCustomer(){


driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_addmenu")).click();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

driver.findElement(By.id("com.adaptavant.setmore:id/create_newappointment")).click();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[contains(@text, 'All Services')]")).click();

//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.Button[2]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).click();
HashMap<String, Integer> tapObject = new HashMap<String, Integer>();
//r
tapObject.put("x", 267); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//e
tapObject.put("x", 193); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//n
tapObject.put("x", 541); // in pixels from left
tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[3]")).click();
//s
tapObject.put("x", 154); // in pixels from left

tapObject.put("y", 880); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//a
tapObject.put("x", 78); // in pixels from left

tapObject.put("y", 880); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//t
tapObject.put("x", 343); // in pixels from left

tapObject.put("y", 760); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

//@
tapObject.put("x", 150); // in pixels from left

tapObject.put("y", 1117); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

//r
tapObject.put("x", 267); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//e
tapObject.put("x", 193); // in pixels from left
tapObject.put("y", 760); // in pixels from top
((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//n
tapObject.put("x", 541); // in pixels from left
tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//.
tapObject.put("x", 615); // in pixels from left

tapObject.put("y", 1121); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//c
tapObject.put("x", 302); // in pixels from left

tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//o
tapObject.put("x", 648); // in pixels from left

tapObject.put("y", 760); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);
//m
tapObject.put("x", 613); // in pixels from left

tapObject.put("y", 1000); // in pixels from top

((AppiumDriver) driver).executeScript("mobile: tap", tapObject);

((AppiumDriver) driver).hideKeyboard();

driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.TextView[2]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.Button[1]")).click();
try {
	Thread.sleep(12000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

@Test(priority=3)
public void ExistingCustomer(){

//driver.findElement(By.id("com.adaptavant.setmore:id/myschedule_addmenu")).click();

//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.id("com.adaptavant.setmore:id/create_newappointment")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[contains(@text, 'All Services')]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.Button[3]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.FrameLayout[1]")).click();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.findElement(By.xpath("//android.widget.Button[1]")).click();

try {
	Thread.sleep(12000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
@AfterClass
public void teardown(){

    driver.quit();
} 
}

