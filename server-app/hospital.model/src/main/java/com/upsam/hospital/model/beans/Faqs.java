package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Faqs")
public class Faqs implements IModelHospital {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Basic
	@Column(name = "seccion", nullable = false, length = 250)
	private String seccion;
	
	@Basic
	@Column(name = "titulo", nullable = false, length = 250)
	private String titulo;

	@Basic
	@Column(name = "descripcion", nullable = false, length = 1000)
	private String descripcion;

	@Basic
	@Column(name = "tituloUrl", nullable = false, length = 250)
	private String tituloUrl;

	@Basic
	@Column(name = "fotos",nullable = false, length = 500)
	private String fotos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTituloUrl() {
		return tituloUrl;
	}

	public void setTituloUrl(String tituloUrl) {
		this.tituloUrl = tituloUrl;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}
}