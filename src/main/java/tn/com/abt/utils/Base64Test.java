package tn.com.abt.utils;

import java.util.Base64;

public class Base64Test {

	public static void main(String[] args) {

		byte[] encodedBytes = Base64.getEncoder().encode("[B@66048bfd".getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
		byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
		System.out.println("decodedBytes " + new String(decodedBytes));

	}

}
