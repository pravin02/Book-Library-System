package org.pk.booklibrary.model;

/**
 * @author SHREE
 *
 */
public class Dashboard {

	private int totalStudents;
	private int totalStaffs;
	private int totalBookCategories;
	private int totalBooks;

	/**
	 * @param totalStudents
	 * @param totalStaffs
	 * @param totalBookCategories
	 * @param totalBooks
	 */
	public Dashboard(int totalStudents, int totalStaffs, int totalBookCategories, int totalBooks) {
		super();
		this.totalStudents = totalStudents;
		this.totalStaffs = totalStaffs;
		this.totalBookCategories = totalBookCategories;
		this.totalBooks = totalBooks;
	}

	/**
	 * @return the totalStudents
	 */
	public int getTotalStudents() {
		return totalStudents;
	}

	/**
	 * @param totalStudents
	 *            the totalStudents to set
	 */
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	/**
	 * @return the totalStaffs
	 */
	public int getTotalStaffs() {
		return totalStaffs;
	}

	/**
	 * @param totalStaffs
	 *            the totalStaffs to set
	 */
	public void setTotalStaffs(int totalStaffs) {
		this.totalStaffs = totalStaffs;
	}

	/**
	 * @return the totalBookCategories
	 */
	public int getTotalBookCategories() {
		return totalBookCategories;
	}

	/**
	 * @param totalBookCategories
	 *            the totalBookCategories to set
	 */
	public void setTotalBookCategories(int totalBookCategories) {
		this.totalBookCategories = totalBookCategories;
	}

	/**
	 * @return the totalBooks
	 */
	public int getTotalBooks() {
		return totalBooks;
	}

	/**
	 * @param totalBooks
	 *            the totalBooks to set
	 */
	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dashboard [totalStudents=" + totalStudents + ", totalStaffs=" + totalStaffs + ", totalBookCategories="
				+ totalBookCategories + ", totalBooks=" + totalBooks + "]";
	}
}