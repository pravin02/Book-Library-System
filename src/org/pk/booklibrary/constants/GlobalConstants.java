package org.pk.booklibrary.constants;

/**
 * @author PKORP
 * @since 26/04/2017
 */
public interface GlobalConstants {
	/**
	 * For response message for record insert success or failure.
	 */
	public static final String ADD_SUCCESS = "Record added successfully.";
	public static final String ADD_FAULURE = "Error while adding record, Please try again.";
	/**
	 * For response message for record update success or failure.
	 */
	public static final String UPDATE_SUCCESS = "Record updated successfully.";
	public static final String UPDATE_FAILURE = "Error while updating record.";
	/**
	 * For response message for record delete success or failure.
	 */
	public static final String DELETE_SUCCESS = "Record deleted successully.";
	public static final String DELETE_FAILURE = "Error while deleting record.";
	/**
	 * For response message for if no record found.
	 */
	public static final String NO_RECORD = "No record's found.";
	/**
	 * For response message for book image invalid or file format invalid.
	 */
	public static final String INVALID_FILE_FORMAT = "Invalid file format.";
	public static final String IMAGE_ALLOWED = "Only png, jpg, jpeg formats acceptable.";
	/**
	 * directory names to store profile images and book images.
	 */
	public static final String PROFILE_DIR = "profiles";
	public static final String BOOK_DIR = "books";
}