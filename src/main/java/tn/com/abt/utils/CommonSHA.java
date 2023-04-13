package tn.com.abt.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * 
 * @author AMMAR.MAHER
 *
 */
public class CommonSHA {

	/* algorithm : SHA-1, SHA-256, SHA-384, SHA-512 */

	public static String getHash(String msgToHash, String algorithm, String salt) throws Exception {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		md.update(salt.getBytes());
		byte[] bytes = md.digest(msgToHash.getBytes());
		return DatatypeConverter.printHexBinary(bytes);
	}

	public static String getHash(String msgToHash, String algorithm) throws Exception {
		MessageDigest md = MessageDigest.getInstance(algorithm);
		byte[] bytes = md.digest(msgToHash.getBytes());
		return DatatypeConverter.printHexBinary(bytes);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		try {
			String msgToHash = "1";
			String salt = "fc1e04fa85534185bdebcb5b8dc291b4";

			String hash = getHash(msgToHash, "SHA-256", salt);
			System.out.println(hash);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
