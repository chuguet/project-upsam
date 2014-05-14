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
 * The Class CampoSugerido.
 */
@Entity
@Table(name = "CAMPO_SUGERIDO")
public class CampoSugerido implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6003302179234667475L;

	/** The campo. */
	@OneToOne
	@JoinColumn(name = "ID_CAMPO")
	private Campo campo;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPO_SUGERIDO")
	private Integer id;

	/** The regla. */
	@ManyToOne
	@JoinColumn(name = "ID_REGLA")
	private Regla regla;

	/**
	 * Gets the campo.
	 * 
	 * @return the campo
	 */
	public Campo getCampo() {
		return campo;
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
	 * Gets the regla.
	 * 
	 * @return the regla
	 */
	public Regla getRegla() {
		return regla;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
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
