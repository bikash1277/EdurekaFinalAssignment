/*package com.edureka.email;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.edureka.seleniumHelper.BaseClass;
import com.edureka.utility.PropertyFileReader;

public class MailerClass extends BaseClass {
	static String password;
	static String userName;
	static String name;
	static String toList;
	static String ccList;
	static String host;
	static String port;

	public MailerClass() throws Exception {
		userName = PropertyFileReader.getProperty("fromMailId");
		password = PropertyFileReader.getProperty("mailPassword");
		name = PropertyFileReader.getProperty("name");
		toList = PropertyFileReader.getProperty("toMail");
		ccList = PropertyFileReader.getProperty("ccMail");
		host = PropertyFileReader.getProperty("emailHostName");// "mailrelaytest.pnat.com";//"172.16.0.57";
		port = PropertyFileReader.getProperty("port");
	}

	public void mailReports() {
		System.out.println("Enter to mailer ======");
		System.out.println(userName);
		System.out.println(password);
		System.out.println(name);
		System.out.println(toList);
		System.out.println(ccList);
		System.out.println(host);
		System.out.println(port);

		try {
			if (PropertyFileReader.getProperty("isEmailSend").equalsIgnoreCase("yes")) {
				// String zippedReports = zipReports();
				Properties properties = System.getProperties();
				properties.put("mail.transport.protocol", "smtp");
				properties.put("mail.smtp.starttls.enable", "true");

				// set the port of socket factory
				properties.put("mail.smtp.socketFactory.port", port);

				// this will set host of server- you can change based on your requirement
				properties.setProperty("mail.smtp.host", host);

				// set the port of SMTP server
				properties.setProperty("mail.smtp.port", port);

				properties.setProperty("mail.smtp.ehlo", "false");
				// properties.put("mail.debug", "true");

				// set the authentication to true
				properties.put("mail.smtp.auth", "true");

				properties.put("mail.smtp.ssl", "true");

				// set socket factory
				properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

				Authenticator auth = new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName, password);
					}
				};
				Session session = Session.getDefaultInstance(properties, auth);//

				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(userName));
				message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(toList));
				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccList));
				message.setSubject("Execution reports");
				BodyPart messageBodyPart1 = new MimeBodyPart();
				messageBodyPart1.setText("Hi,\n\tPlease find the attached reports.\nRegards\n" + name);

				MimeBodyPart messageBodyPart2 = new MimeBodyPart();
				String attachment = System.getProperty("user.dir") + "/src/main/java/com/edureka/reports/report.html";
				DataSource source = new FileDataSource(attachment);
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart2.setFileName("HTML Report");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart1);
				multipart.addBodyPart(messageBodyPart2);
				message.setContent(multipart);

				Transport transport = session.getTransport("smtp");
				transport.connect();
				message.saveChanges();
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				System.out.println("reports sent in mail to: " + toList + " and cc: " + ccList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
*/