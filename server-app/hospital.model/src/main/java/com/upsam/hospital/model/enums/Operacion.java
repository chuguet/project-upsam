package com.upsam.hospital.model.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum Operacion.
 */
public enum Operacion {

	/** The igual. */
	IGUAL("igual"),
	/** The mayor. */
	MAYOR("mayor"),
	/** The mayor igual. */
	MAYOR_IGUAL("mayor o igual"),
	/** The menor. */
	MENOR("menor"),
	/** The menor igual. */
	MENOR_IGUAL("menor o igual");

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new operacion.
	 * 
	 * @param nameId
	 *            the name id
	 */
	private Operacion(String nameId) {
		this.nameId = nameId;
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
