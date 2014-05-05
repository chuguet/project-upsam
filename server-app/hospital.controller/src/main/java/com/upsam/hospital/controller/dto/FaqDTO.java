package com.upsam.hospital.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class FaqDTO.
 */
public class FaqDTO extends AbstractDTO {

	/** The id sintoma. */
	private Integer idSintoma;

	/** The pregunta. */
	private String pregunta;

	/** The respuesta. */
	private String respuesta;

	/**
	 * Gets the id sintoma.
	 * 
	 * @return the id sintoma
	 */
	public Integer getIdSintoma() {
		return idSintoma;
	}

	/**
	 * Gets the pregunta.
	 * 
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * Gets the respuesta.
	 * 
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Sets the id sintoma.
	 * 
	 * @param idSintoma
	 *            the new id sintoma
	 */
	public void setIdSintoma(Integer idSintoma) {
		this.idSintoma = idSintoma;
	}

	/**
	 * Sets the pregunta.
	 * 
	 * @param pregunta
	 *            the new pregunta
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * Sets the respuesta.
	 * 
	 * @param respuesta
	 *            the new respuesta
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}
