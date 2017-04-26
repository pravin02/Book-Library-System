/**
 * 
 */
package org.pk.booklibrary.model;

/**
 * @author SHREE
 * 
 */
public enum UserStatus {
	ACTIVE, INACTIVE, DELETED;

	public static UserStatus getUserStatus(String status) {
		for (UserStatus ut : UserStatus.values()) {
			if (ut.name().equals(status))
				return ut;
		}
		return null;
	}
}
