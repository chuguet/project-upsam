package com.upsam.hospital.model.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum UnidadMedida.
 */
public enum UnidadMedida {

	/** The deg. */
	DEG("deg");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static UnidadMedida getValue(String value) {
		UnidadMedida result = null;
		for (UnidadMedida unidadMedida : UnidadMedida.values()) {
			if (unidadMedida.getNameId().equals(value)) {
				result = unidadMedida;
				break;
			}
		}
		return result;
	}

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new unidad medida.
	 * 
	 * @param pNameId
	 *            the name id
	 */
	private UnidadMedida(String pNameId) {
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
