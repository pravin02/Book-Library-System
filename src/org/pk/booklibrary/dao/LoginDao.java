package org.pk.booklibrary.dao;

import org.pk.booklibrary.model.User;

/**
 * @author PKCorp
 * 
 */
public interface LoginDao {

	/**
	 * @param mobileNumber
	 * @param emailId
	 * @return
	 */
	String isMobileOrEmailAllreadyExists(String mobileNumber, String emailId);

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	User loginUser(String emailId, String password);
	
	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	User loginAdmin(String emailId, String password);

	/**
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	String updatePassword(int userId, String oldPassword, String newPassword);

}