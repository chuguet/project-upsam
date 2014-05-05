package com.upsam.hospital.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class SintomaDTO.
 */
public class SintomaDTO extends AbstractDTO {

	/** The id parte cuerpo. */
	private Integer idParteCuerpo;

	/** The sintoma. */
	private String sintoma;

	/**
	 * Gets the id parte cuerpo.
	 * 
	 * @return the id parte cuerpo
	 */
	public Integer getIdParteCuerpo() {
		return idParteCuerpo;
	}

	/**
	 * Gets the sintoma.
	 * 
	 * @return the sintoma
	 */
	public String getSintoma() {
		return sintoma;
	}

	/**
	 * Sets the id parte cuerpo.
	 * 
	 * @param idParteCuerpo
	 *            the new id parte cuerpo
	 */
	public void setIdParteCuerpo(Integer idParteCuerpo) {
		this.idParteCuerpo = idParteCuerpo;
	}

	/**
	 * Sets the sintoma.
	 * 
	 * @param sintoma
	 *            the new sintoma
	 */
	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}

}
