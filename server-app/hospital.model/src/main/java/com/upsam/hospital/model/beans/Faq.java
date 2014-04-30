package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Faq.
 */
@Entity
@Table(name = "FAQ")
public class Faq implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3736054644363229796L;

	/** The descripcion. */
	@Basic
	@Column(name = "DESCRIPCION", nullable = false, length = 1000)
	private String descripcion;

	/** The fotos. */
	@Basic
	@Column(name = "FOTOS", nullable = false, length = 500)
	private String fotos;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FAQ")
	private Integer id;

	/** The seccion. */
	@Basic
	@Column(name = "SECCION", nullable = false, length = 250)
	private String seccion;

	/** The titulo. */
	@Basic
	@Column(name = "TITULO", nullable = false, length = 250)
	private String titulo;

	/** The titulo url. */
	@Basic
	@Column(name = "TITULO_URL", nullable = false, length = 250)
	private String tituloUrl;

	/**
	 * Instantiates a new faq.
	 */
	public Faq() {
		super();
	}

	/**
	 * Gets the descripcion.
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Gets the fotos.
	 * 
	 * @return the fotos
	 */
	public String getFotos() {
		return fotos;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the seccion.
	 * 
	 * @return the seccion
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Gets the titulo url.
	 * 
	 * @return the titulo url
	 */
	public String getTituloUrl() {
		return tituloUrl;
	}

	/**
	 * Sets the descripcion.
	 * 
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Sets the fotos.
	 * 
	 * @param fotos
	 *            the new fotos
	 */
	public void setFotos(String fotos) {
		this.fotos = fotos;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the seccion.
	 * 
	 * @param seccion
	 *            the new seccion
	 */
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Sets the titulo url.
	 * 
	 * @param tituloUrl
	 *            the new titulo url
	 */
	public void setTituloUrl(String tituloUrl) {
		this.tituloUrl = tituloUrl;
	}
}