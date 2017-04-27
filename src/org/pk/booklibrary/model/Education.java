package org.pk.booklibrary.model;

/**
 * education class.
 * 
 * @author PKORP
 * @since 26/04/2017
 */
public class Education {

	private int educationId;
	private int userId;
	private String degree;
	private String college;
	private String board;
	private float percentage;
	private int year;

	public Education() {
	}

	/**
	 * @param educationId
	 * @param degree
	 * @param college
	 * @param board
	 * @param percentage
	 * @param year
	 */
	public Education(int educationId, String degree, String college, String board, float percentage, int year) {
		super();
		this.educationId = educationId;
		this.degree = degree;
		this.college = college;
		this.board = board;
		this.percentage = percentage;
		this.year = year;
	}

	/**
	 * @param educationId
	 * @param userId
	 * @param degree
	 * @param college
	 * @param board
	 * @param percentage
	 * @param year
	 */
	public Education(int educationId, int userId, String degree, String college, String board, float percentage,
			int year) {
		super();
		this.educationId = educationId;
		this.userId = userId;
		this.degree = degree;
		this.college = college;
		this.board = board;
		this.percentage = percentage;
		this.year = year;
	}

	/**
	 * @return the educationId
	 */
	public int getEducationId() {
		return educationId;
	}

	/**
	 * @param educationId
	 *            the educationId to set
	 */
	public void setEducationId(int educationId) {
		this.educationId = educationId;
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
	 * @return the degree
	 */
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree
	 *            the degree to set
	 */
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the college
	 */
	public String getCollege() {
		return college;
	}

	/**
	 * @param college
	 *            the college to set
	 */
	public void setCollege(String college) {
		this.college = college;
	}

	/**
	 * @return the board
	 */
	public String getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(String board) {
		this.board = board;
	}

	/**
	 * @return the percentage
	 */
	public float getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage
	 *            the percentage to set
	 */
	public void setPercentage(float percentage) {
		this.percentage = percentage;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", userId=" + userId + ", degree=" + degree + ", college="
				+ college + ", board=" + board + ", percentage=" + percentage + ", year=" + year + "]";
	}

}