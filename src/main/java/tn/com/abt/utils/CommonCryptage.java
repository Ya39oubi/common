package tn.com.abt.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CommonCryptage {

	public CommonCryptage() {
	}

	public static String crypter(String pwd, String input) throws Exception {
		try {
			DESKeySpec keySpec = new DESKeySpec(pwd.getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(keySpec);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] crypt = cipher.doFinal(input.getBytes("UTF8"));
			String base64Encoded = new String(Base64.encodeBase64(crypt));
			return new String(base64Encoded.getBytes("UTF-8"));
		} catch (Exception e) {
			throw e;
		}
	}

	public static String decrypter(String pwd, String input) throws Exception {
		try {
			DESKeySpec keySpecd = new DESKeySpec(pwd.getBytes("UTF8"));
			SecretKeyFactory keyFactoryd = SecretKeyFactory.getInstance("DES");
			SecretKey keyd = keyFactoryd.generateSecret(keySpecd);
			byte[] decrypt = Base64.decodeBase64(input);
			Cipher cipherd = Cipher.getInstance("DES");
			cipherd.init(Cipher.DECRYPT_MODE, keyd);
			byte[] retour = cipherd.doFinal(decrypt);
			return new String(retour, "UTF8");

		} catch (Exception e) {
			throw e;
		}
	}

	public static void main(String[] args) {
		try {
			String text = "éàè";
			String crypter = CommonCryptage.crypter("0123456789abcdef0123456789abcdef", text);
			System.out.println(crypter);
			System.out.println(CommonCryptage.decrypter("0123456789abcdef0123456789abcdef", crypter));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
