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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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

	/** The duracion. */
	@Basic
	@Column(name = "DURACION", length = 20)
	private String duracion;

	/** The fecha. */
	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VIDEO")
	private Integer id;

	/** The unidad medida. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/** The paciente. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	/**
	 * Gets the duracion.
	 * 
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
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
	 * Gets the paciente.
	 * 
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
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
