package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements IModelHospital {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/** The nombre. */
	@Basic
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;

	/** The apellidos. */
	@Basic
	@Column(name = "apellidos", nullable = false, length = 200)
	private String apellidos;

	/** The email. */
	@Basic
	@Column(name = "email", unique = true, length = 200)
	private String email;

	@Basic
	@Column(name = "usuario", unique = true, nullable = false, length = 20)
	private String usuario;

	/** The password. */
	@Basic
	@Column(name = "pwd", nullable = false, length = 200)
	private String password;

	@Basic
	@Column(name = "rol_id", nullable = false)
	private Rol rol;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}