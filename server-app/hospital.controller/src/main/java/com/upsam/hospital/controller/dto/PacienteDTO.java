package com.upsam.hospital.controller.dto;

import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDTO.
 */
public class PacienteDTO extends AbstractDTO {

	/** The apellidos. */
	private String apellidos;

	/** The curso. */
	private String curso;

	/** The escolarizacion. */
	private String escolarizacion;

	/** The examinador. */
	private String examinador;

	/** The fecha evaluacion. */
	private String fechaEvaluacion;

	/** The fecha nacimiento. */
	private String fechaNacimiento;

	/** The fichero. */
	private MultipartFile fichero;

	/** The nombre. */
	private String nombre;

	/** The numero identificacion. */
	private String numeroIdentificacion;

	/** The sexo. */
	private String sexo;

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
	 * Gets the fecha evaluacion.
	 * 
	 * @return the fecha evaluacion
	 */
	public String getFechaEvaluacion() {
		return fechaEvaluacion;
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
	 * Gets the fichero.
	 * 
	 * @return the fichero
	 */
	public MultipartFile getFichero() {
		return fichero;
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
	 * Sets the fecha evaluacion.
	 * 
	 * @param fechaEvaluacion
	 *            the new fecha evaluacion
	 */
	public void setFechaEvaluacion(String fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
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
	 * Sets the fichero.
	 * 
	 * @param fichero
	 *            the new fichero
	 */
	public void setFichero(MultipartFile fichero) {
		this.fichero = fichero;
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
