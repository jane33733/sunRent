package com.sun.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailUtils {
	
//	private static Properties mailServerProperties = null;

	private static Logger logger = Logger.getLogger(MailUtils.class);

	public static void sendMail(List<String> receiverList, String subject, String content) throws Exception {

//		if (mailServerProperties == null) {
//			// Step1
//			logger.info("\n 1st ===> setup Mail Server Properties..");
//			mailServerProperties = System.getProperties();
//			mailServerProperties.put("mail.smtp.port", "587");
//			mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//			mailServerProperties.put("mail.smtp.auth", "true");
//			mailServerProperties.put("mail.smtp.starttls.enable", "true");
//			logger.info("Mail Server Properties have been setup successfully..");
//
//		}
		
		// Step1
		logger.info("\n 1st ===> setup Mail Server Properties..");
		Properties mailServerProperties = new Properties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		logger.info("Mail Server Properties have been setup successfully..");
		
		
		// Step2
		logger.info("\n\n 2nd ===> get Mail Session..");
		Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		MimeMessage generateMailMessage = new MimeMessage(getMailSession);
		for (String receiver : receiverList) {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		}
		// 副本如下
		// generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
		generateMailMessage.setSubject(subject);
		String emailBody = content;
		generateMailMessage.setContent(emailBody, "text/html; charset=UTF-8");
		logger.info("Mail Session has been created successfully..");

		// Step3
		logger.info("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");

		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", 587, "janeJSsun33733@gmail.com", "zxcv3+bnm,");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	
	public static void sendSimpleMail(List<String> receiverList, String subject, String content) throws Exception{
		
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.user", "janeJSsun33733@gmail.com");
        props.setProperty("mail.password", "zxcv3+bnm,");
       
        
        Session mailSession = Session.getDefaultInstance(props, null);
        Transport transport = mailSession.getTransport();
        
//        SmtpAuthenticator authenticator = new SmtpAuthenticator();
        MimeMessage message = new MimeMessage(mailSession);
        message.setSubject(subject);
        message.setContent(content, "text/plain");
        for (String receiver : receiverList) {
        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		}
        
        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
	    
	}
	
	public static void main(String args[]) throws AddressException, MessagingException {
		
	}
}
