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
		
		
		Send send = new Send();
		send.send(to, subject, textMessage);
		
		
	}
	
	

}
