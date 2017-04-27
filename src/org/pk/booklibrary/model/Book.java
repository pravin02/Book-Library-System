package org.pk.booklibrary.model;

/**
 * model class for book
 * 
 * @author PKORP
 * @since 26/04/2017
 */
public class Book {

	private int bookId;
	private BookCategory bookCategory;
	private String title;
	private String author;
	private String isbn;
	private String publication;
	private int year;
	private String image;
	private String description;
	private int copies;
	private int availableCopies;
	private String rackNo;

	public Book() {
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
	 */
	public Book(int bookId, BookCategory bookCategory, String title, String author, String ISBN, String publication,
			int year, String image, String description, int copies, int availableCopies, String rackNo) {
		super();
		this.bookId = bookId;
		this.bookCategory = bookCategory;
		this.title = title;
		this.author = author;
		this.isbn = ISBN;
		this.publication = publication;
		this.year = year;
		this.image = image;
		this.description = description;
		this.copies = copies;
		this.availableCopies = availableCopies;
		this.rackNo = rackNo;
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
	 * @return the ISBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param ISBN
	 *            the ISBN to set
	 */
	public void setIsbn(String ISBN) {
		this.isbn = ISBN;
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

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getRackNo() {
		return rackNo;
	}

	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookCategory=" + bookCategory + ", title=" + title + ", author=" + author
				+ ", ISBN=" + isbn + ", publication=" + publication + ", year=" + year + ", image=" + image
				+ ", description=" + description + ", copies=" + copies + ", availableCopies=" + availableCopies + "]";
	}
}