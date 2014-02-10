package com.upsam.hospital.controller.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AppException.
 */
public class TransferObjectException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public TransferObjectException() {
		super();
	}

	/**
	 * Instantiates a new data base exception.
	 *
	 * @param e the e
	 */
	public TransferObjectException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public TransferObjectException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new data base exception.
	 *
	 * @param message the message
	 * @param exception the exception
	 */
	public TransferObjectException(String message, Exception exception) {
		super(message, exception);
	}
}