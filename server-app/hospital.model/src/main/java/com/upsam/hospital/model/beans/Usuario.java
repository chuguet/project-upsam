package com.upsam.hospital.model.beans;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.upsam.hospital.model.enums.Rol;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5147827634279571103L;

	/** The apellidos. */
	@Basic
	@Column(name = "APELLIDOS", nullable = false, length = 200)
	private String apellidos;

	/** The email. */
	@Basic
	@Column(name = "EMAIL", unique = true, length = 200)
	private String email;

	/** The generate_token. */
	@Basic
	@Column(name = "GENERATE_TOKEN")
	private Date generate_token;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	/** The nombre. */
	@Basic
	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	/** The password. */
	@Basic
	@Column(name = "PWD", nullable = false, length = 200)
	private String password;

	/** The rol. */
	@Basic
	@Column(name = "ROL_ID", nullable = false)
	private Rol rol;

	/** The token. */
	@Basic
	@Column(name = "TOKEN", unique = true)
	private String token;

	/** The usuario. */
	@Basic
	@Column(name = "USUARIO", unique = true, nullable = false, length = 20)
	private String usuario;

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
		super();
	}

	/**
	 * Instantiates a new usuario.
	 * 
	 * @param id
	 *            the id
	 */
	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new usuario.
	 * 
	 * @param apellidos
	 *            the apellidos
	 * @param id
	 *            the id
	 * @param nombre
	 *            the nombre
	 */
	public Usuario(String apellidos, Integer id, String nombre) {
		super();
		this.apellidos = apellidos;
		this.id = id;
		this.nombre = nombre;
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
	 * Gets the generate_token.
	 * 
	 * @return the generate_token
	 */
	public Date getGenerate_token() {
		return generate_token;
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
	 * Gets the nombre completo.
	 * 
	 * @return the nombre completo
	 */
	public String getNombreCompleto() {
		String nombreCompleto = this.nombre;
		if (apellidos != null && apellidos.length() > 0) {
			nombreCompleto += " " + this.apellidos;
		}
		return nombreCompleto;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the rol.
	 * 
	 * @return the rol
	 */
	public Rol getRol() {
		return rol;
	}

	/**
	 * Gets the token.
	 * 
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Gets the usuario.
	 * 
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
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
	 * Sets the generate_token.
	 * 
	 * @param generate_token
	 *            the new generate_token
	 */
	public void setGenerate_token(Date generate_token) {
		this.generate_token = generate_token;
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
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the rol.
	 * 
	 * @param rol
	 *            the new rol
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}

	/**
	 * Sets the token.
	 * 
	 * @param token
	 *            the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Sets the usuario.
	 * 
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}