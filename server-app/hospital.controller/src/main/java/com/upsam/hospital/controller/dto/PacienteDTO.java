package com.upsam.hospital.controller.dto;

import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioDTO.
 */
public class PacienteDTO extends AbstractDTO {

	/** The apellidos. */
	private String apellidos;

	/** The email. */
	private String email;

	/** The password. */
	private String expediente;

	/** The fichero. */
	private MultipartFile fichero;

	/** The nombre. */
	private String nombre;

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
	 * Gets the multipart file.
	 * 
	 * @return the multipart file
	 */
	public MultipartFile getMultipartFile() {
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
	 * Sets the multipart file.
	 * 
	 * @param fichero
	 *            the new multipart file
	 */
	public void setMultipartFile(MultipartFile fichero) {
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

}
