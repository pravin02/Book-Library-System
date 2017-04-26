package org.pk.booklibrary.model;

/**
 * @author SHREE
 * 
 */
public class BookCategory {

	private int categoryId;
	private String category;
	private String description;
	private String image;

	public BookCategory() {
	}

	/**
	 * @param categoryId
	 * @param category
	 * @param description
	 */
	public BookCategory(int categoryId, String category, String description) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.description = description;
	}

	/**
	 * @param categoryId
	 * @param category
	 * @param description
	 * @param image
	 */
	public BookCategory(int categoryId, String category, String description, String image) {
		super();
		this.categoryId = categoryId;
		this.category = category;
		this.description = description;
		this.image = image;
	}

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookCategory [categoryId=" + categoryId + ", category=" + category + ", description=" + description
				+ "]";
	}
}