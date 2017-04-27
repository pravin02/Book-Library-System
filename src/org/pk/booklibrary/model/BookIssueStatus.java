/**
 * 
 */
package org.pk.booklibrary.model;

/**
 * enum for book issue status.
 * 
 * @author PKORP
 * @since 26/04/2017
 */
public enum BookIssueStatus {
	ISSUED, RETURNED;

	public static BookIssueStatus getBookIssueStatus(String status) {
		for (BookIssueStatus ut : BookIssueStatus.values()) {
			if (ut.name().equals(status))
				return ut;
		}
		return null;
	}
}
