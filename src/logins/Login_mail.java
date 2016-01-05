package logins;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import appModule.openbrowser;
import appModule.signout;
import Utility.Constant;
import Utility.Reporter;


@Listeners(Reporter.class)
public class Login_mail {		
	
	private static WebDriver driver;
	 
	private static Logger Log = Logger.getLogger(Log4j.class.getName());
 
	//DOMConfigurator.configure("log4j.xml");
	
	@BeforeClass
	public void login()
	
	{	
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		Log.info("Implicit wait applied on the driver for 30 seconds");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);      
	}

	@Test(priority=1)
	public void SetmoreLogin()
	
	{	
	driver.findElement(By.id("username")).sendKeys("love12345@setmore.com");
	driver.findElement(By.id("password")).sendKeys("Setmore");
	driver.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/ul[1]/li[6]/div[3]/input")).click();
	}
	
	
    @Test(priority=2)
    public void Logout()
    
    {	
    signout.Execute(driver);
	}
	
    	
    @AfterClass
    public static void execute(String reportFileName) throws Exception {

	  final String username = "jacksrone@gmail.com";
	  final String password = "JohnCena";

	   Properties props = new Properties();
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.debug", "false");
	   props.put("mail.smtp.port", "4723");
	   
	
	   Session session = Session.getInstance(props,
	    new javax.mail.Authenticator() {
	     protected PasswordAuthentication getPasswordAuthentication() {
	      return new PasswordAuthentication(username, password);
	     }
	    });

	   try {

	    Message message = new MimeMessage(session);
	   message.setFrom(new InternetAddress("vimal.venkat@a-cti.com"));
	   message.setRecipients(Message.RecipientType.TO,
	     InternetAddress.parse("jacksrone@gmail.com"));
	   message.setSubject("SETMORE WEBAPP AUTOMATION REPORTS!");
	   message.setText("Dear Mail Crawler,"
	     + "\n\n No spam to my email, please!");

	    MimeBodyPart messageBodyPart = new MimeBodyPart();

	    Multipart multipart = new MimeMultipart();

	    messageBodyPart = new MimeBodyPart();
	    String file = "/Users/user/Documents/workspace/TestNg/test-output/";
	   String fileName = reportFileName;
	   DataSource source = new FileDataSource(file + fileName);
	   messageBodyPart.setDataHandler(new DataHandler(source));
	   messageBodyPart.setFileName(fileName);
	   multipart.addBodyPart(messageBodyPart);

	    message.setContent(multipart);
	   System.out.println("Sending");
	   Transport.send(message);
	   System.out.println("Done");
	  } catch (MessagingException e) {
	   throw new RuntimeException(e);
	  }
	 }
}
    
