package com.upsam.hospital.model.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class Paciente.
 */
@Entity
@Table(name = "PACIENTE")
public class Paciente implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4317366090024096036L;

	/** The apellidos. */
	@Basic
	@Column(name = "APELLIDOS")
	private String apellidos;

	/** The email. */
	@Basic
	@Column(name = "EMAIL", unique = true)
	private String email;

	/** The expediente. */
	@Basic
	@Column(name = "EXPEDIENTE", unique = true)
	private String expediente;

	/** The exploracion3 d. */
	@OneToMany(mappedBy = "paciente")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Exploracion3D> exploracion3D;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PACIENTE")
	private Integer id;

	/** The nombre. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/**
	 * Adds the exploracion3 d.
	 * 
	 * @param exploracion3D
	 *            the exploracion3 d
	 */
	public void addExploracion3D(Exploracion3D exploracion3D) {
		if (this.getExploracion3D() == null) {
			this.setExploracion3D(new ArrayList<Exploracion3D>());
		}
		this.getExploracion3D().add(exploracion3D);
	}

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the expediente.
	 * 
	 * @return the expediente
	 */
	public String getExpediente() {
		return expediente;
	}

	/**
	 * Gets the exploracion3 d.
	 * 
	 * @return the exploracion3 d
	 */
	public List<Exploracion3D> getExploracion3D() {
		return exploracion3D;
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
	 * Sets the apellidos.
	 * 
	 * @param apellidos
	 *            the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the expediente.
	 * 
	 * @param expediente
	 *            the new expediente
	 */
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}

	/**
	 * Sets the exploracion3 d.
	 * 
	 * @param exploracion3d
	 *            the new exploracion3 d
	 */
	public void setExploracion3D(List<Exploracion3D> exploracion3d) {
		exploracion3D = exploracion3d;
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
