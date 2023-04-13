package tn.com.abt.test;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/**
 * Possible KEY_SIZE values are 128, 192 and 256
 * Possible T_LEN values are 128, 120, 112, 104 and 96
 */

public class AES {

	private SecretKey key;
	private final int KEY_SIZE = 128;
	private final int T_LEN = 128;
	private Cipher encryptionCipher;

	public void init() throws Exception {
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		generator.init(KEY_SIZE);
		key = generator.generateKey();
	}

	public String encrypt(String message) throws Exception {
		byte[] messageInBytes = message.getBytes();
		encryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
		encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
		return encode(encryptedBytes);
	}

	public String decrypt(String encryptedMessage) throws Exception {
		byte[] messageInBytes = decode(encryptedMessage);
		Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
		GCMParameterSpec spec = new GCMParameterSpec(T_LEN, encryptionCipher.getIV());
		decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
		byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
		return new String(decryptedBytes);
	}

	private String encode(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	private byte[] decode(String data) {
		return Base64.getDecoder().decode(data);
	}

	public static void main(String[] args) {
		try {
			AES aes = new AES();
			aes.init();
			String encryptedMessage = aes.encrypt(
					"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiI0Mjc2Iiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImlkX2FjY19jbGkiOjMsImlkIjoiNDI3NiIsImV4cCI6MTY2MjU3NTQxNSwiYXV0aG9yaXRpZXMiOlsiUk9MRV8yIiwiUk9MRV84IiwiUk9MRV8xOSIsIlJPTEVfNTkiLCJST0xFXzU4IiwiUk9MRV82OSIsIlJPTEVfMTciLCJST0xFXzQ5IiwiUk9MRV83NyIsIlJPTEVfMTAiLCJST0xFXzY1IiwiUk9MRV83NiIsIlJPTEVfNTciLCJST0xFXzU2IiwiUk9MRV83OCIsIlJPTEVfNjIiLCJST0xFXzczIiwiUk9MRV82MSIsIlJPTEVfNzIiLCJST0xFXzY0IiwiUk9MRV82MyIsIlJPTEVfNzQiLCJST0xFXzYwIiwiUk9MRV83MSJdLCJqdGkiOiJkNjYyZGM2OC1jNDc3LTQ4ZDUtOTViNi1kNDg0MWJiZDc5ZDMiLCJjbGllbnRfaWQiOiI1ZDYwZTNkMTRmNWI0OWE1Y2U2ODU2ZWYwZTg3MjY3MiJ9.io2zIdbn2B8bXeVy7_uDvkS5sVQXYSMxkQ4MPrzaus_oZNBcFB-uGmT-WJxo7NN_RuoWAR_ZX9chMuhXYCVZX4Ft3X4kO275s1Y2tINQhHpj2Tm3I0_t5NagWwmWEuDUJHJmGHzUDr3y1Pby9Q0VRHDDGwNSN3IWbrPg_Um3SxHBmN_OiUkReF27HXixrmu2q6wlx3zusjY0SqvaKIlLNFGvC4khO_ygb32hoxnGrU-U2d-urpSq0sdSQlLuQ2MPiJSfAeBoDQxjduOM3EPbfH4Fkxvkq9qmCKhhxOA-Gab1LP2xj0RrOrlrvucvi-iQGKyfYfqqu6m6gBF9fCjkNg");
			String decryptedMessage = aes.decrypt(encryptedMessage);

			System.err.println("Encrypted Message : " + encryptedMessage);
			System.err.println("Decrypted Message : " + decryptedMessage);
		} catch (Exception ignored) {
		}
	}

}
