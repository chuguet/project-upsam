package com.upsam.hospital.controller.dto;

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
	 * @param infoMessages the new info messages
	 */
	public void setInfoMessages(List<String> infoMessages) {
		this.infoMessages = infoMessages;
	}

	/**
	 * Sets the warning messages.
	 *
	 * @param warningMessages the new warning messages
	 */
	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

}
