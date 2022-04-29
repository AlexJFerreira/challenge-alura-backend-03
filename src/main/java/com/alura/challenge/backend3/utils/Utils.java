package com.alura.challenge.backend3.utils;

import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

public class Utils {
	
	private static final Random RANDOM = new Random();
	
	public static String encryptPassword(final String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(11));
	}
	
	public static String generateRandomDefaultPassword() {
		final Integer password = RANDOM.nextInt(0,999999);
		return encryptPassword(password.toString());
	}

}
