package com.upsam.hospital.model.beans;

import java.util.ArrayList;
import java.util.Date;
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

	/** The curso. */
	@Basic
	@Column(name = "CURSO")
	private String curso;

	/** The escolarizacion. */
	@Basic
	@Column(name = "ESCOLARIZACION")
	private String escolarizacion;

	/** The examinador. */
	@Basic
	@Column(name = "EXAMINADOR")
	private String examinador;

	/** The exploracion3 d. */
	@OneToMany(mappedBy = "paciente")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Exploracion3D> exploracion3D;

	/** The fecha evaluacion. */
	@Basic
	@Column(name = "FECHA_EVALUACION")
	private Date fechaEvaluacion;

	/** The email. */
	@Basic
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PACIENTE")
	private Integer id;

	/** The nombre. */
	@Basic
	@Column(name = "NOMBRE")
	private String nombre;

	/** The expediente. */
	@Basic
	@Column(name = "NUMERO_IDENTIFICACION", unique = true)
	private String numeroIdentificacion;

	/** The sexo. */
	@Basic
	@Column(name = "SEXO")
	private String sexo;

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
	 * Gets the curso.
	 * 
	 * @return the curso
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Gets the escolarizacion.
	 * 
	 * @return the escolarizacion
	 */
	public String getEscolarizacion() {
		return escolarizacion;
	}

	/**
	 * Gets the examinador.
	 * 
	 * @return the examinador
	 */
	public String getExaminador() {
		return examinador;
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
	 * Gets the fecha evaluacion.
	 * 
	 * @return the fecha evaluacion
	 */
	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	/**
	 * Gets the fecha nacimiento.
	 * 
	 * @return the fecha nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
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
	 * Gets the numero identificacion.
	 * 
	 * @return the numero identificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * Gets the sexo.
	 * 
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
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
	 * Sets the curso.
	 * 
	 * @param curso
	 *            the new curso
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Sets the escolarizacion.
	 * 
	 * @param escolarizacion
	 *            the new escolarizacion
	 */
	public void setEscolarizacion(String escolarizacion) {
		this.escolarizacion = escolarizacion;
	}

	/**
	 * Sets the examinador.
	 * 
	 * @param examinador
	 *            the new examinador
	 */
	public void setExaminador(String examinador) {
		this.examinador = examinador;
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
	 * Sets the fecha evaluacion.
	 * 
	 * @param fechaEvaluacion
	 *            the new fecha evaluacion
	 */
	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	/**
	 * Sets the fecha nacimiento.
	 * 
	 * @param fechaNacimiento
	 *            the new fecha nacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	 * Sets the numero identificacion.
	 * 
	 * @param numeroIdentificacion
	 *            the new numero identificacion
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * Sets the sexo.
	 * 
	 * @param sexo
	 *            the new sexo
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
