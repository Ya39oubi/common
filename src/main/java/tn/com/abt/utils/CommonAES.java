package tn.com.abt.utils;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/***
 * 
 * @author AMMAR.MAHER
 *
 */
public class CommonAES {

	public static SecretKeySpec generateSecretKey(String secretKey) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		byte[] digest = sha.digest(secretKey.getBytes("UTF-8"));
		return new SecretKeySpec(digest, "AES");
	}

	public static String encrypt(String secretKey, String... params) throws Exception {
		String msgToEncrypt = null;
		for (String param : params) {
			if (msgToEncrypt == null) {
				msgToEncrypt = param;
			} else {
				msgToEncrypt = msgToEncrypt + ":" + param;
			}
		}
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, generateSecretKey(secretKey));
		return DatatypeConverter.printHexBinary(cipher.doFinal(msgToEncrypt.getBytes("UTF-8")));
	}

	public static String decrypt(String secretKey, String msgToDecrypt) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, generateSecretKey(secretKey));
		return new String(cipher.doFinal(DatatypeConverter.parseHexBinary(msgToDecrypt)));
	}

	public static void main(String[] args) {
		try {
			String secretKey = "fc1e04fa85534185bdebcb5b8dc291b4";
			String originalString = "6:190";// DD72F1C40308F81737BA3663853FAABB
			String encryptedString = CommonAES.encrypt(secretKey, originalString);
			System.out.println(encryptedString);
			String decryptedString = CommonAES.decrypt(secretKey, encryptedString);
			System.out.println(decryptedString);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
