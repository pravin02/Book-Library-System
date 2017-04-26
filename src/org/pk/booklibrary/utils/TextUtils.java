package org.pk.booklibrary.utils;

/**
 * @author SHREE
 * 
 */
public class TextUtils {

	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str != null) {
			if (!str.equals(""))
				return false;
			return true;
		} else
			return true;
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isDigit(String str) {
		char[] digits = str.toCharArray();
		for (char c : digits)
			if (!Character.isDigit(c))
				return false;
		return true;
	}
}