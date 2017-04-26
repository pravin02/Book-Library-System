/**
 * 
 */
package org.pk.booklibrary.model;

/**
 * @author SHREE
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
