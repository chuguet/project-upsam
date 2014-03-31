package com.upsam.hospital.model.exceptions;

public class NotFoundException extends ControlledException {
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new app exception.
	 */
	public NotFoundException() {
		super();
	}

	/**
	 * Instantiates a new data base exception.
	 * 
	 * @param e
	 *            the e
	 */
	public NotFoundException(Exception e) {
		super(e);
	}

	/**
	 * Instantiates a new app exception.
	 * 
	 * @param message
	 *            the message
	 */
	public NotFoundException(String message) {
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
	public NotFoundException(String message, Exception exception) {
		super(message, exception);
	}
}