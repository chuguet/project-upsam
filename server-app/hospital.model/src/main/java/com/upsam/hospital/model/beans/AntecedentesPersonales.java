package com.upsam.hospital.model.beans;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonales.
 */
@Entity
@Table(name = "ANTECEDENTES_PERSONALES")
public class AntecedentesPersonales implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5538437859089564825L;

	/** The alergias medicamentosas conocidas. */
	@Basic
	@Column(name = "ALERGIAS_MEDICAMENTOSAS_CONOCIDAS")
	private String alergiasMedicamentosasConocidas;

	/** The antecedentes medicos. */
	@Basic
	@Column(name = "ANTECEDENTES_MEDICOS")
	private String antecedentesMedicos;

	/** The audicion. */
	@Basic
	@Column(name = "AUDICION")
	private String audicion;

	/** The caidas ultimo anno. */
	@Basic
	@Column(name = "CAIDAS_ULTIMO_ANNO")
	private Integer caidasUltimoAnno;

	/** The epilepsia. */
	@Basic
	@Column(name = "EPILEPSIA")
	private Boolean epilepsia;

	/** The exploracion. */
	@OneToOne
	@JoinColumn(name = "ID_EXPLORACION", unique = true)
	private Exploracion exploracion;

	/** The fecha penultima sesion. */
	@Basic
	@Column(name = "FECHA_PENULTIMA_SESION")
	private Date fechaPenultimaSesion;

	/** The fecha ultima caida. */
	@Basic
	@Column(name = "FECHA_ULTIMA_CAIDA")
	private Date fechaUltimaCaida;
	/** The fecha ultima sesion. */
	@Basic
	@Column(name = "FECHA_ULTIMA_SESION")
	private Date fechaUltimaSesion;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANTECEDENTES_PERSONALES")
	private Integer id;

	/** The lenguaje cognicion. */
	@Basic
	@Column(name = "LENGUAJE_COGNICION")
	private Boolean lenguajeCognicion;

	/** The localizacion tratamiento. */
	@Basic
	@Column(name = "LOCALIZACION_TRATAMIENTO")
	private String localizacionTratamiento;

	/** The numero aproximado. */
	@Basic
	@Column(name = "NUMERO_APROXIMADO")
	private Integer numeroAproximado;

	/** The tratamiento actual. */
	@Basic
	@Column(name = "TRATAMIENTO_ACTUAL")
	private String tratamientoActual;

	/** The vision. */
	@Basic
	@Column(name = "VISION")
	private String vision;

	/**
	 * Instantiates a new antecedentes personales.
	 */
	public AntecedentesPersonales() {
		super();
	}

	/**
	 * Instantiates a new antecedentes personales.
	 * 
	 * @param id
	 *            the id
	 */
	public AntecedentesPersonales(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new antecedentes personales.
	 * 
	 * @param alergiasMedicamentosasConocidas
	 *            the alergias medicamentosas conocidas
	 * @param antecedentesMedicos
	 *            the antecedentes medicos
	 * @param audicion
	 *            the audicion
	 * @param caidasUltimoAnno
	 *            the caidas ultimo anno
	 * @param epilepsia
	 *            the epilepsia
	 * @param fechaPenultimaSesion
	 *            the fecha penultima sesion
	 * @param fechaUltimaCaida
	 *            the fecha ultima caida
	 * @param fechaUltimaSesion
	 *            the fecha ultima sesion
	 * @param id
	 *            the id
	 * @param lenguajeCognicion
	 *            the lenguaje cognicion
	 * @param localizacionTratamiento
	 *            the localizacion tratamiento
	 * @param numeroAproximado
	 *            the numero aproximado
	 * @param tratamientoActual
	 *            the tratamiento actual
	 * @param vision
	 *            the vision
	 */
	public AntecedentesPersonales(String alergiasMedicamentosasConocidas, String antecedentesMedicos, String audicion, Integer caidasUltimoAnno, Boolean epilepsia, Date fechaPenultimaSesion, Date fechaUltimaCaida, Date fechaUltimaSesion, Integer id, Boolean lenguajeCognicion, String localizacionTratamiento, Integer numeroAproximado, String tratamientoActual, String vision) {
		super();
		this.alergiasMedicamentosasConocidas = alergiasMedicamentosasConocidas;
		this.antecedentesMedicos = antecedentesMedicos;
		this.audicion = audicion;
		this.caidasUltimoAnno = caidasUltimoAnno;
		this.epilepsia = epilepsia;
		this.fechaPenultimaSesion = fechaPenultimaSesion;
		this.fechaUltimaCaida = fechaUltimaCaida;
		this.fechaUltimaSesion = fechaUltimaSesion;
		this.id = id;
		this.lenguajeCognicion = lenguajeCognicion;
		this.localizacionTratamiento = localizacionTratamiento;
		this.numeroAproximado = numeroAproximado;
		this.tratamientoActual = tratamientoActual;
		this.vision = vision;
	}

	/**
	 * Gets the alergias medicamentosas conocidas.
	 * 
	 * @return the alergias medicamentosas conocidas
	 */
	public String getAlergiasMedicamentosasConocidas() {
		return alergiasMedicamentosasConocidas;
	}

	/**
	 * Gets the antecedentes medicos.
	 * 
	 * @return the antecedentes medicos
	 */
	public String getAntecedentesMedicos() {
		return antecedentesMedicos;
	}

	/**
	 * Gets the audicion.
	 * 
	 * @return the audicion
	 */
	public String getAudicion() {
		return audicion;
	}

	/**
	 * Gets the caidas ultimo anno.
	 * 
	 * @return the caidas ultimo anno
	 */
	public Integer getCaidasUltimoAnno() {
		return caidasUltimoAnno;
	}

	/**
	 * Gets the epilepsia.
	 * 
	 * @return the epilepsia
	 */
	public Boolean getEpilepsia() {
		return epilepsia;
	}

	/**
	 * Gets the exploracion.
	 * 
	 * @return the exploracion
	 */
	public Exploracion getExploracion() {
		return exploracion;
	}

	/**
	 * Gets the fecha penultima sesion.
	 * 
	 * @return the fecha penultima sesion
	 */
	public Date getFechaPenultimaSesion() {
		return fechaPenultimaSesion;
	}

	/**
	 * Gets the fecha ultima caida.
	 * 
	 * @return the fecha ultima caida
	 */
	public Date getFechaUltimaCaida() {
		return fechaUltimaCaida;
	}

	/**
	 * Gets the fecha ultima sesion.
	 * 
	 * @return the fecha ultima sesion
	 */
	public Date getFechaUltimaSesion() {
		return fechaUltimaSesion;
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
	 * Gets the lenguaje cognicion.
	 * 
	 * @return the lenguaje cognicion
	 */
	public Boolean getLenguajeCognicion() {
		return lenguajeCognicion;
	}

	/**
	 * Gets the localizacion tratamiento.
	 * 
	 * @return the localizacion tratamiento
	 */
	public String getLocalizacionTratamiento() {
		return localizacionTratamiento;
	}

	/**
	 * Gets the numero aproximado.
	 * 
	 * @return the numero aproximado
	 */
	public Integer getNumeroAproximado() {
		return numeroAproximado;
	}

	/**
	 * Gets the tratamiento actual.
	 * 
	 * @return the tratamiento actual
	 */
	public String getTratamientoActual() {
		return tratamientoActual;
	}

	/**
	 * Gets the vision.
	 * 
	 * @return the vision
	 */
	public String getVision() {
		return vision;
	}

	/**
	 * Sets the alergias medicamentosas conocidas.
	 * 
	 * @param alergiasMedicamentosasConocidas
	 *            the new alergias medicamentosas conocidas
	 */
	public void setAlergiasMedicamentosasConocidas(String alergiasMedicamentosasConocidas) {
		this.alergiasMedicamentosasConocidas = alergiasMedicamentosasConocidas;
	}

	/**
	 * Sets the antecedentes medicos.
	 * 
	 * @param antecedentesMedicos
	 *            the new antecedentes medicos
	 */
	public void setAntecedentesMedicos(String antecedentesMedicos) {
		this.antecedentesMedicos = antecedentesMedicos;
	}

	/**
	 * Sets the audicion.
	 * 
	 * @param audicion
	 *            the new audicion
	 */
	public void setAudicion(String audicion) {
		this.audicion = audicion;
	}

	/**
	 * Sets the caidas ultimo anno.
	 * 
	 * @param caidasUltimoAnno
	 *            the new caidas ultimo anno
	 */
	public void setCaidasUltimoAnno(Integer caidasUltimoAnno) {
		this.caidasUltimoAnno = caidasUltimoAnno;
	}

	/**
	 * Sets the epilepsia.
	 * 
	 * @param epilepsia
	 *            the new epilepsia
	 */
	public void setEpilepsia(Boolean epilepsia) {
		this.epilepsia = epilepsia;
	}

	/**
	 * Sets the exploracion.
	 * 
	 * @param exploracion
	 *            the new exploracion
	 */
	public void setExploracion(Exploracion exploracion) {
		this.exploracion = exploracion;
	}

	/**
	 * Sets the fecha penultima sesion.
	 * 
	 * @param fechaPenultimaSesion
	 *            the new fecha penultima sesion
	 */
	public void setFechaPenultimaSesion(Date fechaPenultimaSesion) {
		this.fechaPenultimaSesion = fechaPenultimaSesion;
	}

	/**
	 * Sets the fecha ultima caida.
	 * 
	 * @param fechaUltimaCaida
	 *            the new fecha ultima caida
	 */
	public void setFechaUltimaCaida(Date fechaUltimaCaida) {
		this.fechaUltimaCaida = fechaUltimaCaida;
	}

	/**
	 * Sets the fecha ultima sesion.
	 * 
	 * @param fechaUltimaSesion
	 *            the new fecha ultima sesion
	 */
	public void setFechaUltimaSesion(Date fechaUltimaSesion) {
		this.fechaUltimaSesion = fechaUltimaSesion;
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
	 * Sets the lenguaje cognicion.
	 * 
	 * @param lenguajeCognicion
	 *            the new lenguaje cognicion
	 */
	public void setLenguajeCognicion(Boolean lenguajeCognicion) {
		this.lenguajeCognicion = lenguajeCognicion;
	}

	/**
	 * Sets the localizacion tratamiento.
	 * 
	 * @param localizacionTratamiento
	 *            the new localizacion tratamiento
	 */
	public void setLocalizacionTratamiento(String localizacionTratamiento) {
		this.localizacionTratamiento = localizacionTratamiento;
	}

	/**
	 * Sets the numero aproximado.
	 * 
	 * @param numeroAproximado
	 *            the new numero aproximado
	 */
	public void setNumeroAproximado(Integer numeroAproximado) {
		this.numeroAproximado = numeroAproximado;
	}

	/**
	 * Sets the tratamiento actual.
	 * 
	 * @param tratamientoActual
	 *            the new tratamiento actual
	 */
	public void setTratamientoActual(String tratamientoActual) {
		this.tratamientoActual = tratamientoActual;
	}

	/**
	 * Sets the vision.
	 * 
	 * @param vision
	 *            the new vision
	 */
	public void setVision(String vision) {
		this.vision = vision;
	}

}
