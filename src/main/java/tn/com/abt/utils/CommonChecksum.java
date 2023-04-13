package tn.com.abt.utils;

import java.security.NoSuchAlgorithmException;

import org.jboss.logging.Logger.Level;
import org.springframework.http.HttpStatus;

/***
 * 
 * @author AMMAR.MAHER
 *
 */
public class CommonChecksum {

	public static String getChecksum(String algorithm, String salt, String... params) throws Exception {

		String msgToHash = null;
		for (String param : params) {
			if (msgToHash == null) {
				msgToHash = "checksum:" + param;
			} else {
				msgToHash = msgToHash + "|" + param;
			}
		}
		return CommonSHA.getHash(msgToHash, algorithm, salt);
	}

	public static boolean checksumControl(Long idAccessClient, boolean withChecksumControl, String checksumPassword,
			String receivedChecksum, String... params) {

		if (withChecksumControl == false) {
			return true;
		}

		if (!CommonValidFormat.isValidStringHexBinary(receivedChecksum)) {
			return false;
		}

		try {
			String checksum = CommonChecksum.getChecksum("SHA-256", checksumPassword, params);
			if (receivedChecksum == null || !checksum.equals(receivedChecksum.toUpperCase())) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			CommonLogger.logger(Level.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, idAccessClient, "tn.com.abt.utils.CommonChecksum",
					"checksumControl", e.toString(), e, "receivedChecksum=" + receivedChecksum);
			return false;
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		try {
			// String salt = "7b03739dd43d9ad558eb25d09d20cb36";// Salt NMR
			String salt = "d263542f4d137c0390f623cf7ae773a3";
			String hash = CommonChecksum.getChecksum("SHA-256", salt, "1000");
			// String hash = CommonChecksum.getChecksum("SHA-256", salt, "11", "39");
			System.out.println(hash);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
