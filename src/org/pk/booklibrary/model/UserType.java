/**
 * 
 */
package org.pk.booklibrary.model;

/**
 * enum for user types.
 * 
 * @author PKCORP
 * @since 26/04/2017
 * 
 */
public enum UserType {
	ADMIN, STUDENT, STAFF;

	public static UserType getUserStatus(String status) {
		for (UserType ut : UserType.values()) {
			if (ut.name().equals(status))
				return ut;
		}
		return null;
	}
}
