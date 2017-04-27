package org.pk.booklibrary.utils;

/**
 * Utility class for Text
 * @author PKORP
 * @since 26/04/2017
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
	 * method to check passed string is digit or not
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