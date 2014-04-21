package com.upsam.hospital.controller.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteMovilDTO.
 */
public class PacienteMovilDTO extends AbstractDTO {

	/** The apellidos. */
	private String apellidos;

	/** The curso. */
	private String curso;

	/** The escolarizacion. */
	private Integer escolarizacion;

	/** The numero identificacion. */
	private String fechaNacimiento;

	/** The numero identificacion. */
	private String fechaUltimaEvaluacion;

	/** The nombre. */
	private String nombre;

	/** The numero identificacion. */
	private String numeroIdentificacion;

	/** The sexo. */
	private Integer sexo;

	/** The telefono. */
	private String telefono;

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	public String getCurso() {
		return curso;
	}

	public Integer getEscolarizacion() {
		return escolarizacion;
	}

	/**
	 * Gets the fecha nacimiento.
	 * 
	 * @return the fecha nacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Gets the fecha ultima evaluacion.
	 * 
	 * @return the fecha ultima evaluacion
	 */
	public String getFechaUltimaEvaluacion() {
		return fechaUltimaEvaluacion;
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

	public Integer getSexo() {
		return sexo;
	}

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

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setEscolarizacion(Integer escolarizacion) {
		this.escolarizacion = escolarizacion;
	}

	/**
	 * Sets the fecha nacimiento.
	 * 
	 * @param fechaNacimiento
	 *            the new fecha nacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Sets the fecha ultima evaluacion.
	 * 
	 * @param fechaUltimaEvaluacion
	 *            the new fecha ultima evaluacion
	 */
	public void setFechaUltimaEvaluacion(String fechaUltimaEvaluacion) {
		this.fechaUltimaEvaluacion = fechaUltimaEvaluacion;
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

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
