package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Sintoma.
 */
@Entity
@Table(name = "CAMPO")
public class Campo implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -327851549309517586L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPO")
	private Integer id;

	/** The sintoma. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/** The parte cuerpo. */
	@ManyToOne
	@JoinColumn(name = "ID_PAGINA")
	private Pagina pagina;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the pagina.
	 * 
	 * @return the pagina
	 */
	public Pagina getPagina() {
		return pagina;
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
	 * Sets the nombre.
	 * 
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Sets the pagina.
	 * 
	 * @param pagina
	 *            the new pagina
	 */
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

}