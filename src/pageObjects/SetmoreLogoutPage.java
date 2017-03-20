
package pageObjects;

    import org.openqa.selenium.By;

    import org.openqa.selenium.WebDriver;

    import org.openqa.selenium.WebElement;

 public class SetmoreLogoutPage {

 private static WebElement element = null;
 
 public static WebElement DashBoard(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='startDashboard']"));

	    return element;
 }

 public static WebElement Calendar(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='startCalendar']"));

    return element;

    }
 public static WebElement Customer(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='side-nav-customers']"));

    return element;

    }

 public static WebElement Profile(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='side-profile']/a"));

    return element;

    }
 public static WebElement Settings(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='settings_new']/a"));

	    return element;

	    }
 public static WebElement Account_Menu(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='account_menu']/a"));

    return element;

    }

 public static WebElement SignOut(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='sign_out']/a/div[2]"));

 return element;

    }



}

