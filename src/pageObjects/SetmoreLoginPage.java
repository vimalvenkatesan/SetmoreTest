
package pageObjects;

    import org.openqa.selenium.By;

    import org.openqa.selenium.WebDriver;

    import org.openqa.selenium.WebElement;

 public class SetmoreLoginPage {

 private static WebElement element = null;
    

 public static WebElement UserName(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='username']"));

    return element;

    }

 public static WebElement Pwd(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='password']"));

 return element;

    }


 public static WebElement Sign_in(WebDriver driver){

    element = driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input"));

 return element;

    }
 

 public static WebElement Google_signin(WebDriver driver){

    element = driver.findElement(By.xpath(".//*[@id='Login_Form_id']/div/div[2]/div[1]/div/div[2]"));

 return element;

    }
 public static WebElement Facebook_signin(WebDriver driver){

	    element = driver.findElement(By.xpath(".//*[@id='Login_Form_id']/div/div[2]/div[1]/div/div[1]"));

	 return element;

	    }
}

