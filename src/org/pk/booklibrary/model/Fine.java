package org.pk.booklibrary.model;

/**
 * @author PKORP
 * @since 26/04/2017
 */
public class Fine {

	private int fineId;
	private String title;
	private int bookIssueId;
	private String comment;
	private double fineAmount;
	private String dateTime;

	public Fine() {
	}

	/**
	 * @param fineId
	 * @param bookIssueId
	 * @param comment
	 * @param fineAmount
	 * @param dateTime
	 */
	public Fine(int fineId, int bookIssueId, String comment, double fineAmount, String dateTime) {
		super();
		this.fineId = fineId;
		this.bookIssueId = bookIssueId;
		this.comment = comment;
		this.fineAmount = fineAmount;
		this.dateTime = dateTime;
	}

	/**
	 * @return the fineId
	 */
	public int getFineId() {
		return fineId;
	}

	/**
	 * @param fineId
	 *            the fineId to set
	 */
	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	/**
	 * @return the bookIssueId
	 */
	public int getBookIssueId() {
		return bookIssueId;
	}

	/**
	 * @param bookIssueId
	 *            the bookIssueId to set
	 */
	public void setBookIssueId(int bookIssueId) {
		this.bookIssueId = bookIssueId;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the fineAmount
	 */
	public double getFineAmount() {
		return fineAmount;
	}

	/**
	 * @param fineAmount
	 *            the fineAmount to set
	 */
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime
	 *            the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Fine [fineId=" + fineId + ", title=" + title + ", bookIssueId=" + bookIssueId + ", comment=" + comment
				+ ", fineAmount=" + fineAmount + ", dateTime=" + dateTime + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
