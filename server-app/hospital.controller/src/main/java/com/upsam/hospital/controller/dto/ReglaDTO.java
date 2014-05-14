package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;
import com.upsam.hospital.controller.dto.util.impl.CampoRellenadoDTO;
import com.upsam.hospital.controller.dto.util.impl.CampoSugeridoDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaDTO.
 */
public class ReglaDTO extends AbstractDTO {

	/** The campos rellenados dto. */
	private List<CampoRellenadoDTO> camposRellenadosDTO;

	/** The camposSugeridos. */
	private List<CampoSugeridoDTO> camposSugeridosDTO;

	/** The mensaje. */
	private String mensaje;

	/** The titulo. */
	private String titulo;

	/**
	 * Adds the campo rellenado dto.
	 * 
	 * @param campoRellenadoDTO
	 *            the campo rellenado dto
	 */
	public void addCampoRellenadoDTO(CampoRellenadoDTO campoRellenadoDTO) {
		if (this.getCamposRellenadosDTO() == null) {
			this.setCamposRellenadosDTO(new ArrayList<CampoRellenadoDTO>());
		}
		this.getCamposRellenadosDTO().add(campoRellenadoDTO);
	}

	/**
	 * Adds the campo sugerido dto.
	 * 
	 * @param campoSugeridoDTO
	 *            the campo sugerido dto
	 */
	public void addCampoSugeridoDTO(CampoSugeridoDTO campoSugeridoDTO) {
		if (this.getCamposSugeridosDTO() == null) {
			this.setCamposSugeridosDTO(new ArrayList<CampoSugeridoDTO>());
		}
		this.getCamposSugeridosDTO().add(campoSugeridoDTO);
	}

	/**
	 * Gets the campos rellenados dto.
	 * 
	 * @return the campos rellenados dto
	 */
	public List<CampoRellenadoDTO> getCamposRellenadosDTO() {
		return camposRellenadosDTO;
	}

	/**
	 * Gets the campos sugeridos dto.
	 * 
	 * @return the campos sugeridos dto
	 */
	public List<CampoSugeridoDTO> getCamposSugeridosDTO() {
		return camposSugeridosDTO;
	}

	/**
	 * Gets the mensaje.
	 * 
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the campos rellenados dto.
	 * 
	 * @param camposRellenadosDTO
	 *            the new campos rellenados dto
	 */
	public void setCamposRellenadosDTO(List<CampoRellenadoDTO> camposRellenadosDTO) {
		this.camposRellenadosDTO = camposRellenadosDTO;
	}

	/**
	 * Sets the campos sugeridos dto.
	 * 
	 * @param camposSugeridosDTO
	 *            the new campos sugeridos dto
	 */
	public void setCamposSugeridosDTO(List<CampoSugeridoDTO> camposSugeridosDTO) {
		this.camposSugeridosDTO = camposSugeridosDTO;
	}

	/**
	 * Sets the mensaje.
	 * 
	 * @param mensaje
	 *            the new mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
