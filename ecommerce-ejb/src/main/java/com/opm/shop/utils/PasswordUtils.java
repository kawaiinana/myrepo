package com.opm.shop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtils {

	public static String encript(String pass) throws NoSuchAlgorithmException {
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] data = digest.digest(pass.getBytes());
		return Base64.getEncoder().encodeToString(data);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(encript("admin"));
			System.out.println(encript("user"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
