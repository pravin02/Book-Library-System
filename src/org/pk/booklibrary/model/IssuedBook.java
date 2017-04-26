package org.pk.booklibrary.model;

import java.sql.Timestamp;

/**
 * @author SHREE
 * 
 */
public class IssuedBook {

	private int bookIssueId;
	private int bookId;
	private BookCategory bookCategory;
	private String title;
	private String author;
	private String ISBN;
	private String publication;
	private int year;
	private String image;
	private String description;
	private int copies;
	private int availableCopies;
	private int userId;
	private Timestamp issuedDateTime;
	private int issuedBy;
	private Timestamp leagleReturnDateTime;
	private Timestamp actualReturnDateTime;
	private String comment;
	private BookIssueStatus status;
	private User user;

	public IssuedBook() {
	}

	/**
	 * @param bookId
	 * @param bookCategory
	 * @param title
	 * @param author
	 * @param iSBN
	 * @param publication
	 * @param year
	 * @param image
	 * @param description
	 * @param copies
	 * @param availableCopies
	 * @param userId
	 * @param issuedDateTime
	 * @param issuedBy
	 * @param leagleReturnDateTime
	 * @param actualReturnDateTime
	 * @param comment
	 * @param status
	 */
	public IssuedBook(int bookId, BookCategory bookCategory, String title, String author, String iSBN,
			String publication, int year, String image, String description, int copies, int availableCopies, int userId,
			Timestamp issuedDateTime, int issuedBy, Timestamp leagleReturnDateTime, Timestamp actualReturnDateTime,
			String comment, BookIssueStatus status) {
		super();
		this.bookId = bookId;
		this.bookCategory = bookCategory;
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.publication = publication;
		this.year = year;
		this.image = image;
		this.description = description;
		this.copies = copies;
		this.availableCopies = availableCopies;
		this.userId = userId;
		this.issuedDateTime = issuedDateTime;
		this.issuedBy = issuedBy;
		this.leagleReturnDateTime = leagleReturnDateTime;
		this.actualReturnDateTime = actualReturnDateTime;
		this.comment = comment;
		this.status = status;
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
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 *            the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookCategory
	 */
	public BookCategory getBookCategory() {
		return bookCategory;
	}

	/**
	 * @param bookCategory
	 *            the bookCategory to set
	 */
	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @param iSBN
	 *            the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @return the publication
	 */
	public String getPublication() {
		return publication;
	}

	/**
	 * @param publication
	 *            the publication to set
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the copies
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * @param copies
	 *            the copies to set
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}

	/**
	 * @return the availableCopies
	 */
	public int getAvailableCopies() {
		return availableCopies;
	}

	/**
	 * @param availableCopies
	 *            the availableCopies to set
	 */
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}

	/**
	 * @return the issuedDateTime
	 */
	public Timestamp getIssuedDateTime() {
		return issuedDateTime;
	}

	/**
	 * @param issuedDateTime
	 *            the issuedDateTime to set
	 */
	public void setIssuedDateTime(Timestamp issuedDateTime) {
		this.issuedDateTime = issuedDateTime;
	}

	/**
	 * @return the issuedBy
	 */
	public int getIssuedBy() {
		return issuedBy;
	}

	/**
	 * @param issuedBy
	 *            the issuedBy to set
	 */
	public void setIssuedBy(int issuedBy) {
		this.issuedBy = issuedBy;
	}

	/**
	 * @return the leagleReturnDateTime
	 */
	public Timestamp getLeagleReturnDateTime() {
		return leagleReturnDateTime;
	}

	/**
	 * @param leagleReturnDateTime
	 *            the leagleReturnDateTime to set
	 */
	public void setLeagleReturnDateTime(Timestamp leagleReturnDateTime) {
		this.leagleReturnDateTime = leagleReturnDateTime;
	}

	/**
	 * @return the actualReturnDateTime
	 */
	public Timestamp getActualReturnDateTime() {
		return actualReturnDateTime;
	}

	/**
	 * @param actualReturnDateTime
	 *            the actualReturnDateTime to set
	 */
	public void setActualReturnDateTime(Timestamp actualReturnDateTime) {
		this.actualReturnDateTime = actualReturnDateTime;
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
	 * @return the status
	 */
	public BookIssueStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(BookIssueStatus status) {
		this.status = status;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IssuedBook [bookIssueId=" + bookIssueId + ", bookId=" + bookId + ", bookCategory=" + bookCategory
				+ ", title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", publication=" + publication
				+ ", year=" + year + ", image=" + image + ", description=" + description + ", copies=" + copies
				+ ", availableCopies=" + availableCopies + ", userId=" + userId + ", issuedDateTime=" + issuedDateTime
				+ ", issuedBy=" + issuedBy + ", leagleReturnDateTime=" + leagleReturnDateTime
				+ ", actualReturnDateTime=" + actualReturnDateTime + ", comment=" + comment + ", status=" + status
				+ ", user=" + user + "]";
	}

}