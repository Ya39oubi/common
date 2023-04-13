package tn.com.abt.test;

import java.util.HashMap;

public class TestClass {

	public static void main(String[] args) {
//		System.out.println("00121".substring(2, 5));
//		Double lg = new Double("-10.18944520");
//		System.out.println(lg);
//		Double la = new Double("36.8460705"); 
//		System.out.println(la);
		try {

//		System.out.println(CommonCalendrier.getDateAsString(CommonConstants.FORMAT_DATE_ISO_8601_3,
//				CommonCalendrier.getStringAsDate(CommonConstants.FORMAT_DATE_ISO_8601_3, "05/08/2021 09:43")));

			HashMap<String, Object> capitalCities = new HashMap<String, Object>();
			capitalCities.put("p1", 1);
			capitalCities.put("p2", true);
			capitalCities.put("p3", "London");
			System.out.println(capitalCities);

			String strMain = "06:12365";
			String[] arrSplit = strMain.split(":");
			System.out.println(strMain.split(":")[0]);
			for (int i = 0; i < arrSplit.length; i++) {
				System.out.println(arrSplit[i]);
			}

			/*
			 * 
			 * 
			 * String strMain = "3|1547";
			 * String[] arrSplit = strMain.split("|");
			 * for (int i = 0; i < arrSplit.length; i++) {
			 * System.out.println(arrSplit[i]);
			 * }
			 * 
			 */

			String accountNumber = "1250027999880";
			System.out.println(accountNumber.substring(0, 3));
			System.out.println(accountNumber.substring(3, 13));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
