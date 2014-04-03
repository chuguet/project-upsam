package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class AngleDTO.
 */
public class AngleDTO extends AbstractDTO {

	/** The name. */
	private String name;

	/** The points. */
	private List<PointDTO> pointsDTO;

	/**
	 * Adds the point.
	 * 
	 * @param pointDTO
	 *            the point dto
	 */
	public void addPointDTO(PointDTO pointDTO) {
		if (this.getPointsDTO() == null) {
			this.setPointsDTO(new ArrayList<PointDTO>());
		}
		this.getPointsDTO().add(pointDTO);
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the points dto.
	 * 
	 * @return the points dto
	 */
	public List<PointDTO> getPointsDTO() {
		return pointsDTO;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the points dto.
	 * 
	 * @param pointsDTO
	 *            the new points dto
	 */
	public void setPointsDTO(List<PointDTO> pointsDTO) {
		this.pointsDTO = pointsDTO;
	}

}
