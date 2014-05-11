package com.upsam.hospital.controller.dto;

public class AntecedentesQuirurgicosOrtopedicosDTO extends AbstractDTO {

	private String fecha;
	private String descripcion;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}