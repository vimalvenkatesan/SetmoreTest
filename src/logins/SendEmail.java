
package logins;

import java.util.Properties;
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

import Utility.EmailReport;

import java.util.logging.Logger;

public class SendEmail {

	public static  void execute(String reportFileName) throws Exception {

		final String username = "vimal.venkat@a-cti.com";
		final String password = "Love123*";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "false");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vimal.venkat@a-cti.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("vimal.venkat@anywhere.co"));
			message.setSubject("SETMORE WEBAPP AUTOMATION REPORTS!");
			message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String file = "/Users/user/git/SetmoreTestNGNew/test-output/index.html";
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