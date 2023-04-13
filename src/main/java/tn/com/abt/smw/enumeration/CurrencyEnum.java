package tn.com.abt.smw.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum CurrencyEnum {

	C012("012", "DZD", "DINAR ALGERIEN"),
	C048("048", "BHD", "DINAR BAHREINI"),
	C124("124", "CAD", "DOLLAR CANADIEN"),
	C156("156", "CNY", "YUAN"),
	C208("208", "DKK", "COURONNE DANOISE"),
	C220("220", "LEC", "LIVRE ECOSSAISE"),
	C392("392", "JPY", "YEN JAPONAIS"),
	C414("414", "KWD", "DINAR KOWEITIEN"),
	C434("434", "LYD", "DINAR LIBYEN"),
	C478("478", "MRO", "OUGUIYA MAURITANIEN"),
	C504("504", "MAD", "DIRHAM MAROCAIN"),
	C578("578", "NOK", "COURONNE NORVEGIENNE"),
	C634("634", "QAR", "RIYAL QATARI"),
	C682("682", "SAR", "RIYAL SAOUDIEN"),
	C752("752", "SEK", "COURONNE SUEDOISE"),
	C756("756", "CHF", "FRANC SUISSE"),
	C784("784", "AED", "DIRHAM DES E.A.U"),
	C788("788", "TND", "DINAR TUNISIEN"),
	C826("826", "GBP", "LIVRE STERLING"),
	C840("840", "USD", "DOLLAR DES USA"),
	C978("978", "EUR", "EURO");

	private final String num;
	private final String alpha3;
	private final String designation;

	private CurrencyEnum(String num, String alpha3, String designation) {
		this.num = num;
		this.alpha3 = alpha3;
		this.designation = designation;
	}

	/**
	 * get get Currency Enum as list of string
	 * 
	 * @return
	 */
	public static List<String> getCurrencyAlpha3Enum() {
		List<String> items = new ArrayList<>();
		for (CurrencyEnum currencyEnum : values()) {
			items.add(currencyEnum.name());
		}

		return items;
	}

	public String getNum() {
		return num;
	}

	public String getAlpha3() {
		return alpha3;
	}

	public String getDesignation() {
		return designation;
	}

}
