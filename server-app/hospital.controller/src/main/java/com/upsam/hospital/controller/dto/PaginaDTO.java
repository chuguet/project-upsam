package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginaDTO.
 */
public class PaginaDTO extends AbstractDTO {

	/** The campos dto. */
	private List<CampoDTO> camposDTO;

	/** The nombre. */
	private String nombre;

	/**
	 * Adds the campo dto.
	 * 
	 * @param campoDTO
	 *            the campo dto
	 */
	public void addCampoDTO(CampoDTO campoDTO) {
		if (this.getCamposDTO() == null) {
			this.setCamposDTO(new ArrayList<CampoDTO>());
		}
		this.getCamposDTO().add(campoDTO);
	}

	/**
	 * Gets the campos dto.
	 * 
	 * @return the campos dto
	 */
	public List<CampoDTO> getCamposDTO() {
		return camposDTO;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the campos dto.
	 * 
	 * @param camposDTO
	 *            the new campos dto
	 */
	public void setCamposDTO(List<CampoDTO> camposDTO) {
		this.camposDTO = camposDTO;
	}

	/**
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
