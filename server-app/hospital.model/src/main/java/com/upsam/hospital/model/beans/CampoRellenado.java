package com.upsam.hospital.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoRellenado.
 */
@Entity
@Table(name = "CAMPO_RELLENADO")
public class CampoRellenado implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5292847699192580972L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPO_RELLENADO")
	private Integer id;

	/** The campo. */
	@OneToOne
	@JoinColumn(name = "ID_CAMPO")
	private Campo campo;

	/** The regla. */
	@ManyToOne
	@JoinColumn(name = "ID_REGLA")
	private Regla regla;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * Gets the campo.
	 * 
	 * @return the campo
	 */
	public Campo getCampo() {
		return campo;
	}

	/**
	 * Sets the campo.
	 * 
	 * @param campo
	 *            the new campo
	 */
	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	/**
	 * Gets the regla.
	 * 
	 * @return the regla
	 */
	public Regla getRegla() {
		return regla;
	}

	/**
	 * Sets the regla.
	 * 
	 * @param regla
	 *            the new regla
	 */
	public void setRegla(Regla regla) {
		this.regla = regla;
	}
}
