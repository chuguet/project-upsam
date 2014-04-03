package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TablaDatosDTO.
 */
public class TablaDatosDTO extends AbstractDTO {

	/** The angles. */
	private List<AngleDTO> anglesDTO;

	/**
	 * Adds the angle dto.
	 * 
	 * @param angleDTO
	 *            the angle dto
	 */
	public void addAngleDTO(AngleDTO angleDTO) {
		if (this.getAnglesDTO() == null) {
			this.setAnglesDTO(new ArrayList<AngleDTO>());
		}
		this.getAnglesDTO().add(angleDTO);
	}

	/**
	 * Gets the angles dto.
	 * 
	 * @return the angles dto
	 */
	public List<AngleDTO> getAnglesDTO() {
		return anglesDTO;
	}

	/**
	 * Sets the angles dto.
	 * 
	 * @param anglesDTO
	 *            the new angles dto
	 */
	public void setAnglesDTO(List<AngleDTO> anglesDTO) {
		this.anglesDTO = anglesDTO;
	}

}
