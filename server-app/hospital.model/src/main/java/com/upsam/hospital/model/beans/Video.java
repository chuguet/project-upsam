package com.upsam.hospital.model.beans;

import java.util.Date;
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
 * The Class Exploracion3D.
 */
@Entity
@Table(name = "VIDEO")
public class Video implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8823797142615984016L;

	/**
	 * Gets the serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The descripcion. */
	@Basic
	@Column(name = "DESCRIPCION", length = 1000)
	private String descripcion;

	/** The duracion. */
	@Basic
	@Column(name = "DURACION", length = 20)
	private String duracion;

	/** The paciente. */
	@ManyToOne
	@JoinColumn(name = "ID_EXPLORACION")
	private Exploracion exploracion;

	/** The fecha. */
	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VIDEO")
	private Integer id;

	/** The unidad medida. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Gets the descripcion.
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Gets the duracion.
	 * 
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Gets the paciente.
	 * 
	 * @return the paciente
	 */
	public Exploracion getExploracion() {
		return exploracion;
	}

	/**
	 * Gets the fecha.
	 * 
	 * @return the fecha
	 */
	public Date getFecha() {
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
	 * Sets the descripcion.
	 * 
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Sets the duracion.
	 * 
	 * @param duracion
	 *            the new duracion
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * Sets the paciente.
	 * 
	 * @param exploracion
	 *            the new exploracion
	 */
	public void setExploracion(Exploracion exploracion) {
		this.exploracion = exploracion;
	}

	/**
	 * Sets the fecha.
	 * 
	 * @param fecha
	 *            the new fecha
	 */
	public void setFecha(Date fecha) {
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
}