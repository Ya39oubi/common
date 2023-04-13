package tn.com.abt.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class SaltedMD5Example {

	private static String getSecurePassword(String passwordToHash,
			String salt) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Add password bytes to digest
			md.update(salt.getBytes());

			// Get the hash's bytes
			byte[] bytes = md.digest(passwordToHash.getBytes());

			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	public static void main(String[] args)
			throws NoSuchAlgorithmException, NoSuchProviderException {
		String passwordToHash = "651";
		String salt = "fc1e04fa85534185bdebcb5b8dc291b4";

		String securePassword = getSecurePassword(passwordToHash, salt);

		System.out.println(securePassword);

		salt = "fc1e04fa85534185bdebcb5b8dc291b5";
		String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, salt);

		System.out.println(regeneratedPassowrdToVerify);
	}
}