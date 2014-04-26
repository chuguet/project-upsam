package com.upsam.hospital.model.beans;

import java.util.Date;
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

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANTECEDENTES_PERSONALES")
	private Integer id;

	@Column(name = "EPILEPSIA")
	private Boolean epilepsia;

	@Column(name = "TIPO_EPILEPSIA")
	private String tipoEpilepsia;

	@Column(name = "FECHA_ULTIMA_CRISIS")
	private Date fechaUltimaCrisis;

	@Column(name = "FECHA_ULTIMA_CONVULSION")
	private Date fechaUltimaConvulsion;

	@Column(name = "NUMERO_CRISIS")
	private Integer numeroCrisis;

	@Column(name = "CAIDAS")
	private Boolean caidas;

	@Column(name = "NUMERO_CAIDAS")
	private Integer numeroCaidas;

	@Column(name = "FECHA_ULTIMA_CAIDA")
	private Date fechaUltimaCaida;

	@Column(name = "AUDICION")
	private String audicion;

	@Column(name = "VISION")
	private String vision;

	@Column(name = "LENGUAJE_COGNICION")
	private Boolean lenguajeCognicion;

	@Column(name = "COMPRESION")
	private String comprension;

	@Column(name = "ENTIENDE_ORDENES_SIMPLES")
	private Boolean entiendeOrdenesSimples;

	@Column(name = "ENTIENDE_ORDENES_COMPLEJAS")
	private Boolean entiendeOrdenesComplejas;

	@Column(name = "EXPRESAR_NECESIDAD_DOLOR")
	private Boolean expresarNecesidadDolor;

	@Column(name = "NUMERO_INYECCIONES")
	private Integer numeroInyecciones;

	@Column(name = "FECHA_ULTIMA_SESION")
	private Date fechaUltimaSesion;

	@Column(name = "FECHA_PENULTIMA_SESION")
	private Date fechaPenultimaSesion;

	@Column(name = "LOCALIZACION_TRATAMIENTO")
	private Integer localizacionTratamiento;

	@Column(name = "ALERGIAS")
	private String alergias;

	@Column(name = "TRATAMIENTO")
	private String tratamiento;

	/** The exploracion. */
	@OneToOne
	@JoinColumn(name = "ID_EXPLORACION", unique = true)
	private Exploracion exploracion;

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

	public AntecedentesPersonales(Integer id, Boolean epilepsia, String tipoEpilepsia, Date fechaUltimaCrisis, Date fechaUltimaConvulsion, Integer numeroCrisis, Boolean caidas, Integer numeroCaidas, Date fechaUltimaCaida, String audicion, String vision, Boolean lenguajeCognicion, String comprension, Boolean entiendeOrdenesSimples, Boolean entiendeOrdenesComplejas, Boolean expresarNecesidadDolor, Integer numeroInyecciones, Date fechaUltimaSesion, Date fechaPenultimaSesion, Integer localizacionTratamiento, String alergias, String tratamiento) {
		super();
		this.id = id;
		this.epilepsia = epilepsia;
		this.tipoEpilepsia = tipoEpilepsia;
		this.fechaUltimaCrisis = fechaUltimaCrisis;
		this.fechaUltimaConvulsion = fechaUltimaConvulsion;
		this.numeroCrisis = numeroCrisis;
		this.caidas = caidas;
		this.numeroCaidas = numeroCaidas;
		this.fechaUltimaCaida = fechaUltimaCaida;
		this.audicion = audicion;
		this.vision = vision;
		this.lenguajeCognicion = lenguajeCognicion;
		this.comprension = comprension;
		this.entiendeOrdenesSimples = entiendeOrdenesSimples;
		this.entiendeOrdenesComplejas = entiendeOrdenesComplejas;
		this.expresarNecesidadDolor = expresarNecesidadDolor;
		this.numeroInyecciones = numeroInyecciones;
		this.fechaUltimaSesion = fechaUltimaSesion;
		this.fechaPenultimaSesion = fechaPenultimaSesion;
		this.localizacionTratamiento = localizacionTratamiento;
		this.alergias = alergias;
		this.tratamiento = tratamiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEpilepsia() {
		return epilepsia;
	}

	public void setEpilepsia(Boolean epilepsia) {
		this.epilepsia = epilepsia;
	}

	public String getTipoEpilepsia() {
		return tipoEpilepsia;
	}

	public void setTipoEpilepsia(String tipoEpilepsia) {
		this.tipoEpilepsia = tipoEpilepsia;
	}

	public Date getFechaUltimaCrisis() {
		return fechaUltimaCrisis;
	}

	public void setFechaUltimaCrisis(Date fechaUltimaCrisis) {
		this.fechaUltimaCrisis = fechaUltimaCrisis;
	}

	public Date getFechaUltimaConvulsion() {
		return fechaUltimaConvulsion;
	}

	public void setFechaUltimaConvulsion(Date fechaUltimaConvulsion) {
		this.fechaUltimaConvulsion = fechaUltimaConvulsion;
	}

	public Integer getNumeroCrisis() {
		return numeroCrisis;
	}

	public void setNumeroCrisis(Integer numeroCrisis) {
		this.numeroCrisis = numeroCrisis;
	}

	public Boolean getCaidas() {
		return caidas;
	}

	public void setCaidas(Boolean caidas) {
		this.caidas = caidas;
	}

	public Integer getNumeroCaidas() {
		return numeroCaidas;
	}

	public void setNumeroCaidas(Integer numeroCaidas) {
		this.numeroCaidas = numeroCaidas;
	}

	public Date getFechaUltimaCaida() {
		return fechaUltimaCaida;
	}

	public void setFechaUltimaCaida(Date fechaUltimaCaida) {
		this.fechaUltimaCaida = fechaUltimaCaida;
	}

	public String getAudicion() {
		return audicion;
	}

	public void setAudicion(String audicion) {
		this.audicion = audicion;
	}

	public String getVision() {
		return vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public Boolean getLenguajeCognicion() {
		return lenguajeCognicion;
	}

	public void setLenguajeCognicion(Boolean lenguajeCognicion) {
		this.lenguajeCognicion = lenguajeCognicion;
	}

	public String getComprension() {
		return comprension;
	}

	public void setComprension(String comprension) {
		this.comprension = comprension;
	}

	public Boolean getEntiendeOrdenesSimples() {
		return entiendeOrdenesSimples;
	}

	public void setEntiendeOrdenesSimples(Boolean entiendeOrdenesSimples) {
		this.entiendeOrdenesSimples = entiendeOrdenesSimples;
	}

	public Boolean getEntiendeOrdenesComplejas() {
		return entiendeOrdenesComplejas;
	}

	public void setEntiendeOrdenesComplejas(Boolean entiendeOrdenesComplejas) {
		this.entiendeOrdenesComplejas = entiendeOrdenesComplejas;
	}

	public Boolean getExpresarNecesidadDolor() {
		return expresarNecesidadDolor;
	}

	public void setExpresarNecesidadDolor(Boolean expresarNecesidadDolor) {
		this.expresarNecesidadDolor = expresarNecesidadDolor;
	}

	public Integer getNumeroInyecciones() {
		return numeroInyecciones;
	}

	public void setNumeroInyecciones(Integer numeroInyecciones) {
		this.numeroInyecciones = numeroInyecciones;
	}

	public Date getFechaUltimaSesion() {
		return fechaUltimaSesion;
	}

	public void setFechaUltimaSesion(Date fechaUltimaSesion) {
		this.fechaUltimaSesion = fechaUltimaSesion;
	}

	public Date getFechaPenultimaSesion() {
		return fechaPenultimaSesion;
	}

	public void setFechaPenultimaSesion(Date fechaPenultimaSesion) {
		this.fechaPenultimaSesion = fechaPenultimaSesion;
	}

	public Integer getLocalizacionTratamiento() {
		return localizacionTratamiento;
	}

	public void setLocalizacionTratamiento(Integer localizacionTratamiento) {
		this.localizacionTratamiento = localizacionTratamiento;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Exploracion getExploracion() {
		return exploracion;
	}

	public void setExploracion(Exploracion exploracion) {
		this.exploracion = exploracion;
	}

}
