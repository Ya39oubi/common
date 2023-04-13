package tn.com.abt.test;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AES256 {

	private static final String SECRET_KEY = "fc1e04fa85534185bdebcb5b8dc291b4";
	private static final String SALT = "fc1e04fa85534185bdebcb5b8dc291b4";

	public static String encrypt(String strToEncrypt) {
		try {
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			return Base64.getEncoder()
					.encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt) {
		try {
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static void main(String[] args) {

		String originalString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI0Mjc2Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImlkX2FjY19jbGkiOjMsImlkIjoiNDI3NiIsImV4cCI6MTY2MjU3NTQxNSwiYXV0aG9yaXRpZXMiOlsiUk9MRV8yIiwiUk9MRV84IiwiUk9MRV8xOSIsIlJPTEVfNTkiLCJST0xFXzU4IiwiUk9MRV82OSIsIlJPTEVfMTciLCJST0xFXzQ5IiwiUk9MRV83NyIsIlJPTEVfMTAiLCJST0xFXzY1IiwiUk9MRV83NiIsIlJPTEVfNTciLCJST0xFXzU2IiwiUk9MRV83OCIsIlJPTEVfNjIiLCJST0xFXzczIiwiUk9MRV82MSIsIlJPTEVfNzIiLCJST0xFXzY0IiwiUk9MRV82MyIsIlJPTEVfNzQiLCJST0xFXzYwIiwiUk9MRV83MSJdLCJqdGkiOiJkNjYyZGM2OC1jNDc3LTQ4ZDUtOTViNi1kNDg0MWJiZDc5ZDMiLCJjbGllbnRfaWQiOiI1ZDYwZTNkMTRmNWI0OWE1Y2U2ODU2ZWYwZTg3MjY3MiJ9.io2zIdbn2B8bXeVy7_uDvkS5sVQXYSMxkQ4MPrzaus_oZNBcFB-uGmT-WJxo7NN_RuoWAR_ZX9chMuhXYCVZX4Ft3X4kO275s1Y2tINQhHpj2Tm3I0_t5NagWwmWEuDUJHJmGHzUDr3y1Pby9Q0VRHDDGwNSN3IWbrPg_Um3SxHBmN_OiUkReF27HXixrmu2q6wlx3zusjY0SqvaKIlLNFGvC4khO_ygb32hoxnGrU-U2d-urpSq0sdSQlLuQ2MPiJSfAeBoDQxjduOM3EPbfH4Fkxvkq9qmCKhhxOA-Gab1LP2xj0RrOrlrvucvi-iQGKyfYfqqu6m6gBF9fCjkNg";

		String encryptedString = AES256.encrypt(originalString);
		String decryptedString = AES256.decrypt(encryptedString);

		System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);
	}

}