package org.pk.booklibrary.dao;

import org.pk.booklibrary.model.User;

/**
 * LoginDao interface
 * 
 * @author PKORP
 * @since 26/04/2017
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
	 * @return user object if credentials are valid other wise it will return
	 *         null.
	 */
	User loginUser(String emailId, String password);

	/**
	 * @param emailId
	 * @param password
	 * @return admin object if credentials are valid other wise it will return
	 *         null.
	 */
	User loginAdmin(String emailId, String password);

	/**
	 * @param userId
	 * @param oldPassword
	 * @param newPassword
	 * @return updates password and returns message if success or will return
	 *         fail.
	 */
	String updatePassword(int userId, String oldPassword, String newPassword);
}