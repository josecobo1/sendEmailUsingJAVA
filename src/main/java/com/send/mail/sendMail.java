package com.send.mail;

import java.util.Base64;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendMail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String from = "cobogarciaj@gmail.com";
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("To:");
		String to = scanner.nextLine().replaceAll("\\s+", "");
		
		System.out.println("Subject:");
		String subject = scanner.nextLine();
		
		System.out.println("Message:");
		String textMessage = scanner.nextLine();
		
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sendingemailusingjava@gmail.com", decriptPassword("c2FnZW0xNTl1Mg=="));
			}

		});
		
		session.setDebug(false);
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(textMessage);
			System.out.println("sending...");
			Transport.send(message);
			System.out.println("Message sent :)");
		} catch(MessagingException mex) {
			mex.printStackTrace();
		}
		
	}
	
	private static String encriptPassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	private static String decriptPassword(String encriptedPassword) {
		return new String(Base64.getMimeDecoder().decode(encriptedPassword));
	}

}
