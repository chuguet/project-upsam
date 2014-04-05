package com.upsam.hospital.model.exceptions;

public class DataBaseException extends ControlledException {
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public DataBaseException() {
		super();
	}

	/**
	 * Instantiates a new data base exception.
	 * 
	 * @param e
	 *            the e
	 */
	public DataBaseException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public DataBaseException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new data base exception.
	 * 
	 * @param message
	 *            the message
	 * @param exception
	 *            the exception
	 */
	public DataBaseException(String message, Exception exception) {
		super(message, exception);
	}
}