package com.mail.business;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mail.business.PasswordDecription;
import com.send.mail.Messages;



public class Send {
	
	static Properties properties;
	static Session session;
	static MimeMessage mail;
	
	
	private static void setProperties() {
		properties = System.getProperties();
		
		properties.put(Messages.getString("sendMail.6"), Messages.getString("sendMail.7")); 
		properties.put(Messages.getString("sendMail.8"), Messages.getString("sendMail.9")); 
		properties.put(Messages.getString("sendMail.10"), Messages.getString("sendMail.11")); 
		properties.put(Messages.getString("sendMail.12"), Messages.getString("sendMail.13")); 
		
	}
	
	private static void setSession() {
		
		final PasswordDecription password = new PasswordDecription();
		
		session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Messages.getString("sendMail.14"), password.decriptPassword(Messages.getString("sendMail.15"))); //$NON-NLS-1$ //$NON-NLS-2$
			}

		});
		
	}
	
	public static void setEmail(String to, String subject, String message) throws AddressException, MessagingException {
		
		mail = new MimeMessage(session);
		mail.setFrom(new InternetAddress(Messages.getString("sendMail.14")));
		mail.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		mail.setSubject(subject);
		mail.setText(message);
		
	}
	
	public void send(String to, String subject, String message) throws MessagingException {
		
		setProperties();
		setSession();
		setEmail(to, subject, message);
		System.out.println(Messages.getString("sendMail.16")); //$NON-NLS-1$
		Transport.send(mail);
		System.out.println(Messages.getString("sendMail.17")); //$NON-NLS-1$
		
	}
}
