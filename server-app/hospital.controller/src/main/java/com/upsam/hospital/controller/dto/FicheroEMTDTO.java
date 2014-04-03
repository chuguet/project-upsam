package com.upsam.hospital.controller.dto;


// TODO: Auto-generated Javadoc
/**
 * The Class FicheroEMTDTO.
 */
public class FicheroEMTDTO extends AbstractDTO {

	/** The ciclos. */
	private Integer ciclos;

	/** The fecha. */
	private String fecha;

	/** The tabla datos. */
	private TablaDatosDTO tablaDatos;

	/** The tipo medida. */
	private String tipoMedida;

	/** The unidad medida. */
	private String unidadMedida;

	/**
	 * Gets the ciclos.
	 * 
	 * @return the ciclos
	 */
	public Integer getCiclos() {
		return ciclos;
	}

	/**
	 * Gets the fecha.
	 * 
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Gets the tabla datos.
	 * 
	 * @return the tabla datos
	 */
	public TablaDatosDTO getTablaDatos() {
		return tablaDatos;
	}

	/**
	 * Gets the tipo medida.
	 * 
	 * @return the tipo medida
	 */
	public String getTipoMedida() {
		return tipoMedida;
	}

	/**
	 * Gets the unidad medida.
	 * 
	 * @return the unidad medida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}

	/**
	 * Sets the ciclos.
	 * 
	 * @param ciclos
	 *            the new ciclos
	 */
	public void setCiclos(Integer ciclos) {
		this.ciclos = ciclos;
	}

	/**
	 * Sets the fecha.
	 * 
	 * @param fecha
	 *            the new fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Sets the tabla datos.
	 * 
	 * @param tablaDatos
	 *            the new tabla datos
	 */
	public void setTablaDatos(TablaDatosDTO tablaDatos) {
		this.tablaDatos = tablaDatos;
	}

	/**
	 * Sets the tipo medida.
	 * 
	 * @param tipoMedida
	 *            the new tipo medida
	 */
	public void setTipoMedida(String tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	/**
	 * Sets the unidad medida.
	 * 
	 * @param unidadMedida
	 *            the new unidad medida
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
}
