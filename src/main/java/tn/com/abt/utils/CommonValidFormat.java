package tn.com.abt.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

public class CommonValidFormat {

	public static boolean isValidEmailAddress(String email) {
		try {
			String regex = "^[a-zA-Z0-9_!#$%&�*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&�*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isValidStringTimeIn24HourFormat(String time, boolean withSecond) {
		try {
			String regex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
			if (withSecond == true) {
				regex = "(([0-1]?[0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9]";
			}
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(time);
			return matcher.matches();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isValidStringHexBinary(String msg) {
		try {
			DatatypeConverter.parseHexBinary(msg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(isValidStringTimeIn24HourFormat("01:09:10", false));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
