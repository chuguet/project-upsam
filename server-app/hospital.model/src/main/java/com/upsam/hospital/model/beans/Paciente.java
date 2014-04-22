package com.upsam.hospital.model.beans;

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
import com.upsam.hospital.model.enums.Escolarizacion;
import com.upsam.hospital.model.enums.Sexo;

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
	private Escolarizacion escolarizacion;

	/** The examinador. */
	@Basic
	@Column(name = "EXAMINADOR")
	private String examinador;
	
	/** The exploracion3d. */
	@OneToMany(mappedBy = "paciente")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Exploracion> exploraciones;

	/** The email. */
	@Basic
	@Column(name = "FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	/** The fecha evaluacion. */
	@Basic
	@Column(name = "FECHA_ULTIMA_EVALUACION")
	private Date fechaUltimaEvaluacion;

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
	private Sexo sexo;

	/** The telefono. */
	@Basic
	@Column(name = "TELEFONO")
	private String telefono;

	/**
	 * Instantiates a new paciente.
	 */
	public Paciente() {

	}

	// /** The fichero mdx. */
	// @OneToMany(mappedBy = "paciente")
	// @Cascade(value = CascadeType.SAVE_UPDATE)
	// @LazyCollection(LazyCollectionOption.FALSE)
	// private List<FicheroMDX> ficheroMDX;

	/**
	 * Instantiates a new paciente.
	 * 
	 * @param id
	 *            the id
	 * @param numeroIdentificacion
	 *            the numero identificacion
	 * @param nombre
	 *            the nombre
	 * @param apellidos
	 *            the apellidos
	 * @param fechaNacimiento
	 *            the fecha nacimiento
	 * @param fechaUltimaEvaluacion
	 *            the fecha ultima evaluacion
	 */
	public Paciente(Integer id, String numeroIdentificacion, String nombre, String apellidos, Date fechaNacimiento, Date fechaUltimaEvaluacion) {
		this.id = id;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaUltimaEvaluacion = fechaUltimaEvaluacion;
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
	public Escolarizacion getEscolarizacion() {
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
	 * Gets the exploraciones.
	 * 
	 * @return the exploraciones
	 */
	public List<Exploracion> getExploraciones() {
		return exploraciones;
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
	 * Gets the fecha ultima evaluacion.
	 * 
	 * @return the fecha ultima evaluacion
	 */
	public Date getFechaUltimaEvaluacion() {
		return fechaUltimaEvaluacion;
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
	public Sexo getSexo() {
		return sexo;
	}

	/**
	 * Gets the telefono.
	 * 
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
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
	public void setEscolarizacion(Escolarizacion escolarizacion) {
		this.escolarizacion = escolarizacion;
	}

	/**
	 * Sets the examinador.
	 *
	 * @param examinador the new examinador
	 */
	public void setExaminador(String examinador) {
		this.examinador = examinador;
	}

	/**
	 * Sets the exploraciones.
	 * 
	 * @param exploraciones
	 *            the new exploraciones
	 */
	public void setExploraciones(List<Exploracion> exploraciones) {
		this.exploraciones = exploraciones;
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
	 * Sets the fecha ultima evaluacion.
	 * 
	 * @param fechaUltimaEvaluacion
	 *            the new fecha ultima evaluacion
	 */
	public void setFechaUltimaEvaluacion(Date fechaUltimaEvaluacion) {
		this.fechaUltimaEvaluacion = fechaUltimaEvaluacion;
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
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	/**
	 * Sets the telefono.
	 * 
	 * @param telefono
	 *            the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
