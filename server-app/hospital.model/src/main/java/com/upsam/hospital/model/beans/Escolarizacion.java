package com.upsam.hospital.model.beans;

// TODO: Auto-generated Javadoc
/**
 * The Enum Escolarizacion.
 */
public enum Escolarizacion {

	/** The educacion especial. */
	EDUCACION_ESPECIAL("Educaci&oacute;n especial"),
	/** The integracion. */
	INTEGRACION("Integraci&oacute;n"),
	/** The sin adaptaciones. */
	SIN_ADAPTACIONES("Sin adaptaciones");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static Escolarizacion getValue(String value) {
		Escolarizacion result = null;
		for (Escolarizacion escolarizacion : Escolarizacion.values()) {
			if (escolarizacion.getNameId().equals(value)) {
				result = escolarizacion;
				break;
			}
		}
		return result;
	}

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new escolarizacion.
	 * 
	 * @param pNameId
	 *            the name id
	 */
	private Escolarizacion(String pNameId) {
		this.nameId = pNameId;
	}

	/**
	 * Gets the name id.
	 * 
	 * @return the name id
	 */
	public String getNameId() {
		return this.nameId;
	}
}
