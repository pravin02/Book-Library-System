package org.pk.booklibrary.model.common;

/**
 * Class to marshal and unmarshal received data from REST API's
 * 
 * @author PKCORP
 * @since 26/04/2017
 */
public class Message {
	/**
	 * 
	 */
	private boolean status;
	/**
	 * represent returns message from API
	 */
	private String message;

	/**
	 * represents data returned from API
	 */
	private Object data;

	/**
	 * @param status
	 * @param message
	 * @param response
	 */
	public Message(boolean status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the response
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
}