package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Faq.
 */
@Entity
@Table(name = "FAQ")
public class Faq implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3736054644363229796L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_FAQ")
	private Integer id;

	/** The pregunta. */
	@Basic
	@Column(name = "PREGUNTA")
	private String pregunta;

	/** The respuesta. */
	@Basic
	@Column(name = "RESPUESTA")
	private String respuesta;

	/** The seccion. */
	@ManyToOne
	@JoinColumn(name = "ID_SINTOMA")
	private Sintoma sintoma;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the pregunta.
	 * 
	 * @return the pregunta
	 */
	public String getPregunta() {
		return pregunta;
	}

	/**
	 * Gets the respuesta.
	 * 
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * Gets the sintoma.
	 * 
	 * @return the sintoma
	 */
	public Sintoma getSintoma() {
		return sintoma;
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
	 * Sets the pregunta.
	 * 
	 * @param pregunta
	 *            the new pregunta
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * Sets the respuesta.
	 * 
	 * @param respuesta
	 *            the new respuesta
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * Sets the sintoma.
	 * 
	 * @param sintoma
	 *            the new sintoma
	 */
	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}

}