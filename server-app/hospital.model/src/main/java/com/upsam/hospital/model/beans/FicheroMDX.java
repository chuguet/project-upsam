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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroMDX.
 */
@Entity
@Table(name = "FICHERO_MDX")
public class FicheroMDX implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4200185823989932569L;

	/** The fecha. */
	@Basic
	@Column(name = "FECHA")
	private Long fecha;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FICHERO_MDX")
	private Integer id;

	/** The nombre. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/** The paciente. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	/**
	 * Gets the fecha.
	 * 
	 * @return the fecha
	 */
	public Long getFecha() {
		return fecha;
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
	 * Gets the nombre.
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Gets the paciente.
	 * 
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * Sets the fecha.
	 * 
	 * @param fecha
	 *            the new fecha
	 */
	public void setFecha(Long fecha) {
		this.fecha = fecha;
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
	 * Sets the paciente.
	 * 
	 * @param paciente
	 *            the new paciente
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
