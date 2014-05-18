package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.upsam.hospital.model.enums.Operacion;

// TODO: Auto-generated Javadoc
/**
 * The Class CampoInfo.
 */
@Entity
@Table(name = "CAMPO_INFO")
public class CampoInfo implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6193233850974338629L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CAMPO_INFO")
	private Integer id;

	/** The campo. */
	@OneToOne
	@JoinColumn(name = "ID_CAMPO")
	private Campo campo;

	/** The regla. */
	@ManyToOne
	@JoinColumn(name = "ID_REGLA")
	private Regla regla;

	/** The operacion. */
	@Basic
	@Column(name = "OPERACION")
	private Operacion operacion;

	/** The valor. */
	@Basic
	@Column(name = "VALOR")
	private Double valor;

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

	/**
	 * Gets the operacion.
	 * 
	 * @return the operacion
	 */
	public Operacion getOperacion() {
		return operacion;
	}

	/**
	 * Sets the operacion.
	 * 
	 * @param operacion
	 *            the new operacion
	 */
	public void setOperacion(Operacion operacion) {
		this.operacion = operacion;
	}

	/**
	 * Gets the valor.
	 * 
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 * 
	 * @param valor
	 *            the new valor
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
