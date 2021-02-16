package com.send.mail;


import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mail.business.PasswordDecription;
import com.mail.business.Send;

public class sendMail {

	public static void main(String[] args) throws MessagingException {
		// TODO Auto-generated method stub
		
		String from = Messages.getString("sendMail.0"); //$NON-NLS-1$
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(Messages.getString("sendMail.1")); //$NON-NLS-1$
		String to = scanner.nextLine().replaceAll("\\s+", "");
		
		System.out.println(Messages.getString("sendMail.4")); //$NON-NLS-1$
		String subject = scanner.nextLine();
		
		System.out.println(Messages.getString("sendMail.5")); //$NON-NLS-1$
		String textMessage = scanner.nextLine();
		
//		AQUI YA TENGO TODA LA IFORMACIÓN QUE LE PIDO AL USUARIO
		
		Send send = new Send();
		send.send(to, subject, textMessage);
		
		
		
//		Properties properties = System.getProperties();
		
//		final PasswordDecription password = new PasswordDecription();
		
//		properties.put(Messages.getString("sendMail.6"), Messages.getString("sendMail.7")); //$NON-NLS-1$ //$NON-NLS-2$
//		properties.put(Messages.getString("sendMail.8"), Messages.getString("sendMail.9")); //$NON-NLS-1$ //$NON-NLS-2$
//		properties.put(Messages.getString("sendMail.10"), Messages.getString("sendMail.11")); //$NON-NLS-1$ //$NON-NLS-2$
//		properties.put(Messages.getString("sendMail.12"), Messages.getString("sendMail.13")); //$NON-NLS-1$ //$NON-NLS-2$
		
//		Send properties = new Send();
//		
//		Session session = Session.getInstance(Send.getProperties(), new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(Messages.getString("sendMail.14"), password.decriptPassword(Messages.getString("sendMail.15"))); //$NON-NLS-1$ //$NON-NLS-2$
//			}
//
//		});
		
//		session.setDebug(false);
//		
//		
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(from));
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			message.setSubject(subject);
//			message.setText(textMessage);
//			System.out.println(Messages.getString("sendMail.16")); //$NON-NLS-1$
//			Transport.send(message);
//			System.out.println(Messages.getString("sendMail.17")); //$NON-NLS-1$
//		} catch(MessagingException mex) {
//			mex.printStackTrace();
//		}
		
	}
	
	

}
