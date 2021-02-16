package com.mail.business;

import java.util.Base64;

public class PasswordDecription {
	
	public static String encriptPassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	public static String decriptPassword(String encriptedPassword) {
		return new String(Base64.getMimeDecoder().decode(encriptedPassword));
	}

}
