package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FaqDTO.
 */
public class FaqDTO {

	/** The info messages. */
	private List<String> infoMessages;

	/** The warning messages. */
	private List<String> warningMessages;

	/**
	 * Adds the info message.
	 * 
	 * @param message
	 *            the message
	 */
	public void addInfoMessage(String message) {
		if (this.getInfoMessages() == null) {
			this.setInfoMessages(new ArrayList<String>());
		}
		this.getInfoMessages().add(message);
	}

	/**
	 * Adds the warning message.
	 * 
	 * @param message
	 *            the message
	 */
	public void addWarningMessage(String message) {
		if (this.getWarningMessages() == null) {
			this.setWarningMessages(new ArrayList<String>());
		}
		this.getWarningMessages().add(message);
	}

	/**
	 * Gets the info messages.
	 * 
	 * @return the info messages
	 */
	public List<String> getInfoMessages() {
		return infoMessages;
	}

	/**
	 * Gets the warning messages.
	 * 
	 * @return the warning messages
	 */
	public List<String> getWarningMessages() {
		return warningMessages;
	}

	/**
	 * Sets the info messages.
	 * 
	 * @param infoMessages
	 *            the new info messages
	 */
	public void setInfoMessages(List<String> infoMessages) {
		this.infoMessages = infoMessages;
	}

	/**
	 * Sets the warning messages.
	 * 
	 * @param warningMessages
	 *            the new warning messages
	 */
	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

}
