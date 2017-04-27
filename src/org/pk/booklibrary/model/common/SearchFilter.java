package org.pk.booklibrary.model.common;

/**
 * Class to define Search Filter common criteria.
 * 
 * @author PKCORP
 * @since 26/04/2017
 */
public class SearchFilter {
	private int id;
	private String startDate;
	private String endDate;
	private String columnName;
	private String order = "ASC";
	private String search = "";
	private int index;
	private String noOfItems;

	public SearchFilter() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search
	 *            the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the noOfRows
	 */
	public String getNoOfItems() {
		return noOfItems;
	}

	/**
	 * @param noOfRows
	 *            the noOfRows to set
	 */
	public void setNoOfItems(String noOfItems) {
		this.noOfItems = noOfItems;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchFilter [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", columnName="
				+ columnName + ", order=" + order + ", search=" + search + ", index=" + index + ", noOfItems="
				+ noOfItems + "]";
	}
}