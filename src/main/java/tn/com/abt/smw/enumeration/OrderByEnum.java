package tn.com.abt.smw.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum OrderByEnum {

	/**
	 * ASC
	 */
	A,

	/**
	 * DESC
	 */
	D;

	/**
	 * get Order By Enum
	 * 
	 * @return
	 */
	public static List<String> getOrderByEnum() {
		List<String> items = new ArrayList<>();
		for (OrderByEnum e : values()) {
			items.add(e.name());
		}

		return items;
	}

}
