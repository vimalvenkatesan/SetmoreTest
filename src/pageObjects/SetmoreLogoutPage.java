
package pageObjects;

    import org.openqa.selenium.By;

    import org.openqa.selenium.WebDriver;

    import org.openqa.selenium.WebElement;

 public class SetmoreLogoutPage {

 private static WebElement element = null;

 public static WebElement Calendar(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='startCalendar']"));

    return element;

    }
 public static WebElement Customer(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='headerNav']/ul/li[4]/a']"));

    return element;

    }

 public static WebElement Profile(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='online_booking']/a']"));

    return element;

    }
 public static WebElement Settings(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='settings_new']/a']"));

	    return element;

	    }
 public static WebElement Account_Menu(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='account_menu']"));

    return element;

    }

 public static WebElement SignOut(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='sign_out']"));

 return element;

    }



}

