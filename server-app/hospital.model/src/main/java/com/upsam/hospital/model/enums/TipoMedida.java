package com.upsam.hospital.model.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum TipoMedida.
 */
public enum TipoMedida {

	/** The angle cycles. */
	ANGLE_CYCLES("Angle cycles");

	/**
	 * Gets the value.
	 * 
	 * @param value
	 *            the value
	 * @return the value
	 */
	public static TipoMedida getValue(String value) {
		TipoMedida result = null;
		for (TipoMedida tipoMedida : TipoMedida.values()) {
			if (tipoMedida.getNameId().equals(value)) {
				result = tipoMedida;
				break;
			}
		}
		return result;
	}

	/** The name id. */
	private String nameId;

	/**
	 * Instantiates a new tipo medida.
	 * 
	 * @param pNameId
	 *            the name id
	 */
	private TipoMedida(String pNameId) {
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
