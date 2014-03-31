package com.upsam.hospital.model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class AppException.
 */
public class ControlledException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public ControlledException() {
		super();
	}

	/**
	 * Instantiates a new data base exception.
	 *
	 * @param e the e
	 */
	public ControlledException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public ControlledException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new data base exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public ControlledException(String message, Exception exception) {
		super(message, exception);
	}
}