/**
 * 
 */
package org.pk.booklibrary.model;

/**
 * enum for user status.
 * 
 * @author PKORP
 * @since 26/04/2017
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
