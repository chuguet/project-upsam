package com.upsam.hospital.model.beans;

// TODO: Auto-generated Javadoc
/**
 * The Enum Sexo.
 */
public enum Sexo {

	/** The hombre. */
	HOMBRE("Hombre"),
	/** The mujer. */
	MUJER("Mujer");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static Sexo getValue(String value) {
		Sexo result = null;
		for (Sexo sexo : Sexo.values()) {
			if (sexo.getNameId().equals(value)) {
				result = sexo;
				break;
			}
		}
		return result;
	}

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new sexo.
	 * 
	 * @param pNameId
	 *            the name id
	 */
	private Sexo(String pNameId) {
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
