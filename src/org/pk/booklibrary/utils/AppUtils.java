package org.pk.booklibrary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author PKORP
 * @since 26/04/2017
 */
public class AppUtils {

	/**
	 * @param str
	 * @return false if mobile not 10 digit
	 */
	public static boolean isValidMobileNumber(String str) {
		if (str == null)
			return false;
		else if ((str.length() < 11 && str.length() > 9) && TextUtils.isDigit(str))
			return true;
		return false;
	}

	/**
	 * This method is used to validate input emailId
	 * 
	 * @param inputEmail
	 *            the emailId to validate
	 * @return true if emailId is valid (in proper format), false otherwise
	 */
	public static boolean isEmailValid(String inputEmail) {
		/*
		 * String regExpn = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
		 * + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" +
		 * "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\." +
		 * "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?" +
		 * "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|" +
		 * "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
		 */
		if (inputEmail == null)
			return false;
		String regExpn = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		CharSequence inputStr = inputEmail;
		Object pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
		Object matcher = ((Pattern) pattern).matcher(inputStr);
		return ((Matcher) matcher).matches();
	}
}