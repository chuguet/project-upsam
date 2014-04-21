package com.upsam.hospital.controller.dto;

import java.util.List;
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
	private Integer escolarizacion;

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
	private Integer sexo;

	/** The telefono. */
	private String telefono;

	private List<ExploracionDTO> exploraciones;

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
	public Integer getEscolarizacion() {
		return escolarizacion;
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
	public Integer getSexo() {
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
	public void setEscolarizacion(Integer escolarizacion) {
		this.escolarizacion = escolarizacion;
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
	public void setSexo(Integer sexo) {
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

	public List<ExploracionDTO> getExploraciones() {
		return exploraciones;
	}

	public void setExploraciones(List<ExploracionDTO> exploraciones) {
		this.exploraciones = exploraciones;
	}

}
