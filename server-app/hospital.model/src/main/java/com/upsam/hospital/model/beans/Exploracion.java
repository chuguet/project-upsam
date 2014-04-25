package com.upsam.hospital.model.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.upsam.hospital.model.enums.AnalisisObservacionalMarcha;

// TODO: Auto-generated Javadoc
/**
 * The Class Exploracion.
 */
@Entity
@Table(name = "EXPLORACION")
public class Exploracion implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6079197394341566835L;

	/** The analisis observacional marcha. */
	@Basic
	@Column(name = "ANALISIS_OBSERVACIONAL_MARCHA")
	private AnalisisObservacionalMarcha analisisObservacionalMarcha;

	/** The cadera flexion derecha. */
	@Basic
	@Column(name = "CADERA_FLEXION_DERECHA")
	private String caderaFlexionDerecha;

	/** The cadera flexion izquierda. */
	@Basic
	@Column(name = "CADERA_FLEXION_IZQUIERDA")
	private String caderaFlexionIzquierda;

	/** The cadera inflexion derecha. */
	@Basic
	@Column(name = "CADERA_INFLEXION_DERECHA")
	private String caderaInflexionDerecha;

	/** The cadera inflexion izquierda. */
	@Basic
	@Column(name = "CADERA_INFLEXION_IZQUIERDA")
	private String caderaInflexionIzquierda;

	/** The control motor selectivo. */
	@Basic
	@Column(name = "CONTROL_MOTOR_SELECTIVO")
	private String controlMotorSelectivo;

	/** The evaluacion muscular. */
	@Basic
	@Column(name = "EVALUACION_MUSCULAR")
	private String evaluacionMuscular;

	/** The fecha. */
	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	@Basic
	@Column(name = "FECHA_ACTUALIZACION")
	private Date fechaActualizacion;

	/** The fichero emt. */
	@OneToMany(mappedBy = "exploracion")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<FicheroEMT> ficherosEMT;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPLORACION")
	private Integer id;

	/** The longitud miembro derecho. */
	@Basic
	@Column(name = "LONGITUD_MIEMBRO_DERECHO")
	private Integer longitudMiembroDerecho;

	/** The longitud miembro izquierdo. */
	@Basic
	@Column(name = "LONGITUD_MIEMBRO_IZQUIERDO")
	private Integer longitudMiembroIzquierdo;

	/** The paciente. */
	@ManyToOne
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	/** The puntuacion500 metros. */
	@Basic
	@Column(name = "PUNTUACION_500_METROS")
	private Integer puntuacion500Metros;

	/** The puntuacion50 metros. */
	@Basic
	@Column(name = "PUNTUACION_50_METROS")
	private Integer puntuacion50Metros;

	/** The puntuacion5 metros. */
	@Basic
	@Column(name = "PUNTUACION_5_METROS")
	private Integer puntuacion5Metros;

	/** The rodilla flexion derecha. */
	@Basic
	@Column(name = "RODILLA_FLEXION_DERECHA")
	private String rodillaFlexionDerecha;

	/** The rodilla flexion izquierda. */
	@Basic
	@Column(name = "RODILLA_FLEXION_IZQUIERDA")
	private String rodillaFlexionIzquierda;

	/** The rodilla inflexion derecha. */
	@Basic
	@Column(name = "RODILLA_INFLEXION_DERECHA")
	private String rodillaInflexionDerecha;

	/** The rodilla inflexion izquierda. */
	@Basic
	@Column(name = "RODILLA_INFLEXION_IZQUIERDA")
	private String rodillaInflexionIzquierda;

	/** The tobillo flexion derecha. */
	@Basic
	@Column(name = "TOBILLO_FLEXION_DERECHA")
	private String tobilloFlexionDerecha;

	/** The tobillo flexion izquierda. */
	@Basic
	@Column(name = "TOBILLO_FLEXION_IZQUIERDA")
	private String tobilloFlexionIzquierda;

	/** The tobillo inflexion derecha. */
	@Basic
	@Column(name = "TOBILLO_INFLEXION_DERECHA")
	private String tobilloInflexionDerecha;

	/** The tobillo inflexion izquierda. */
	@Basic
	@Column(name = "TOBILLO_INFLEXION_IZQUIERDA")
	private String tobilloInflexionIzquierda;

	/** The usuario. */
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	/** The videos. */
	@OneToMany(mappedBy = "exploracion")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Video> videos;

	/**
	 * Instantiates a new exploracion.
	 */
	public Exploracion() {
		super();
	}

	/**
	 * Instantiates a new exploracion.
	 * 
	 * @param analisisObservacionalMarcha
	 *            the analisis observacional marcha
	 * @param controlMotorSelectivo
	 *            the control motor selectivo
	 * @param evaluacionMuscular
	 *            the evaluacion muscular
	 * @param fecha
	 *            the fecha
	 * @param id
	 *            the id
	 * @param longitudMiembroDerecho
	 *            the longitud miembro derecho
	 * @param longitudMiembroIzquierdo
	 *            the longitud miembro izquierdo
	 * @param puntuacion500Metros
	 *            the puntuacion500 metros
	 * @param puntuacion50Metros
	 *            the puntuacion50 metros
	 * @param puntuacion5Metros
	 *            the puntuacion5 metros
	 * @param idUsuario
	 *            the id usuario
	 */
	public Exploracion(AnalisisObservacionalMarcha analisisObservacionalMarcha, String controlMotorSelectivo, String evaluacionMuscular, Date fecha, Date fechaActualizacion, Integer id, Integer longitudMiembroDerecho, Integer longitudMiembroIzquierdo, Integer puntuacion500Metros, Integer puntuacion50Metros, Integer puntuacion5Metros, Integer idUsuario, String caderaFlexionIzquierda, String caderaFlexionDerecha, String caderaInflexionIzquierda, String caderaInflexionDerecha, String rodillaFlexionIzquierda, String rodillaFlexionDerecha, String rodillaInflexionIzquierda, String rodillaInflexionDerecha, String tobilloFlexionIzquierda, String tobilloFlexionDerecha, String tobilloInflexionIzquierda, String tobilloInflexionDerecha) {
		super();
		this.analisisObservacionalMarcha = analisisObservacionalMarcha;
		this.controlMotorSelectivo = controlMotorSelectivo;
		this.evaluacionMuscular = evaluacionMuscular;
		this.fecha = fecha;
		this.fechaActualizacion = fechaActualizacion;
		this.id = id;
		this.longitudMiembroDerecho = longitudMiembroDerecho;
		this.longitudMiembroIzquierdo = longitudMiembroIzquierdo;
		this.puntuacion500Metros = puntuacion500Metros;
		this.puntuacion50Metros = puntuacion50Metros;
		this.puntuacion5Metros = puntuacion5Metros;
		this.usuario = new Usuario(idUsuario);
		this.caderaFlexionIzquierda = caderaFlexionIzquierda;
		this.caderaFlexionDerecha = caderaFlexionDerecha;
		this.caderaInflexionIzquierda = caderaInflexionIzquierda;
		this.caderaInflexionDerecha = caderaInflexionDerecha;
		this.rodillaFlexionIzquierda = rodillaFlexionIzquierda;
		this.rodillaFlexionDerecha = rodillaFlexionDerecha;
		this.rodillaInflexionIzquierda = rodillaInflexionIzquierda;
		this.rodillaInflexionDerecha = rodillaInflexionDerecha;
		this.tobilloFlexionIzquierda = tobilloFlexionIzquierda;
		this.tobilloFlexionDerecha = tobilloFlexionDerecha;
		this.tobilloInflexionIzquierda = tobilloInflexionIzquierda;
		this.tobilloInflexionDerecha = tobilloInflexionDerecha;
	}

	/**
	 * Instantiates a new exploracion.
	 * 
	 * @param id
	 *            the id
	 */
	public Exploracion(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new exploracion.
	 * 
	 * @param id
	 *            the id
	 * @param fecha
	 *            the fecha
	 * @param apellidos
	 *            the apellidos
	 * @param idPaciente
	 *            the id paciente
	 * @param nombre
	 *            the nombre
	 */
	public Exploracion(Integer id, Date fecha, String apellidos, Integer idPaciente, String nombre) {
		this.id = id;
		this.fecha = fecha;
		this.usuario = new Usuario(apellidos, idPaciente, nombre);
	}

	/**
	 * Adds the fichero emt.
	 * 
	 * @param ficheroEMT
	 *            the fichero emt
	 */
	public void addFicheroEMT(FicheroEMT ficheroEMT) {
		if (this.getFicherosEMT() == null) {
			this.setFicherosEMT(new ArrayList<FicheroEMT>());
		}
		this.getFicherosEMT().add(ficheroEMT);
	}

	/**
	 * Adds the video.
	 * 
	 * @param video
	 *            the video
	 */
	public void addVideo(Video video) {
		if (this.getVideos() == null) {
			this.setVideos(new ArrayList<Video>());
		}
		this.getVideos().add(video);
	}

	/**
	 * Gets the analisis observacional marcha.
	 * 
	 * @return the analisis observacional marcha
	 */
	public AnalisisObservacionalMarcha getAnalisisObservacionalMarcha() {
		return analisisObservacionalMarcha;
	}

	/**
	 * Gets the cadera flexion derecha.
	 * 
	 * @return the cadera flexion derecha
	 */
	public String getCaderaFlexionDerecha() {
		return caderaFlexionDerecha;
	}

	/**
	 * Gets the cadera flexion izquierda.
	 * 
	 * @return the cadera flexion izquierda
	 */
	public String getCaderaFlexionIzquierda() {
		return caderaFlexionIzquierda;
	}

	/**
	 * Gets the cadera inflexion derecha.
	 * 
	 * @return the cadera inflexion derecha
	 */
	public String getCaderaInflexionDerecha() {
		return caderaInflexionDerecha;
	}

	/**
	 * Gets the cadera inflexion izquierda.
	 * 
	 * @return the cadera inflexion izquierda
	 */
	public String getCaderaInflexionIzquierda() {
		return caderaInflexionIzquierda;
	}

	/**
	 * Gets the control motor selectivo.
	 * 
	 * @return the control motor selectivo
	 */
	public String getControlMotorSelectivo() {
		return controlMotorSelectivo;
	}

	/**
	 * Gets the evaluacion muscular.
	 * 
	 * @return the evaluacion muscular
	 */
	public String getEvaluacionMuscular() {
		return evaluacionMuscular;
	}

	/**
	 * Gets the fecha.
	 * 
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Gets the ficheros emt.
	 * 
	 * @return the ficheros emt
	 */
	public List<FicheroEMT> getFicherosEMT() {
		return ficherosEMT;
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
	 * Gets the longitud miembro derecho.
	 * 
	 * @return the longitud miembro derecho
	 */
	public Integer getLongitudMiembroDerecho() {
		return longitudMiembroDerecho;
	}

	/**
	 * Gets the longitud miembro izquierdo.
	 * 
	 * @return the longitud miembro izquierdo
	 */
	public Integer getLongitudMiembroIzquierdo() {
		return longitudMiembroIzquierdo;
	}

	/**
	 * Gets the paciente.
	 * 
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * Gets the puntuacion500 metros.
	 * 
	 * @return the puntuacion500 metros
	 */
	public Integer getPuntuacion500Metros() {
		return puntuacion500Metros;
	}

	/**
	 * Gets the puntuacion50 metros.
	 * 
	 * @return the puntuacion50 metros
	 */
	public Integer getPuntuacion50Metros() {
		return puntuacion50Metros;
	}

	/**
	 * Gets the puntuacion5 metros.
	 * 
	 * @return the puntuacion5 metros
	 */
	public Integer getPuntuacion5Metros() {
		return puntuacion5Metros;
	}

	/**
	 * Gets the rodilla flexion derecha.
	 * 
	 * @return the rodilla flexion derecha
	 */
	public String getRodillaFlexionDerecha() {
		return rodillaFlexionDerecha;
	}

	/**
	 * Gets the rodilla flexion izquierda.
	 * 
	 * @return the rodilla flexion izquierda
	 */
	public String getRodillaFlexionIzquierda() {
		return rodillaFlexionIzquierda;
	}

	/**
	 * Gets the rodilla inflexion derecha.
	 * 
	 * @return the rodilla inflexion derecha
	 */
	public String getRodillaInflexionDerecha() {
		return rodillaInflexionDerecha;
	}

	/**
	 * Gets the rodilla inflexion izquierda.
	 * 
	 * @return the rodilla inflexion izquierda
	 */
	public String getRodillaInflexionIzquierda() {
		return rodillaInflexionIzquierda;
	}

	/**
	 * Gets the tobillo flexion derecha.
	 * 
	 * @return the tobillo flexion derecha
	 */
	public String getTobilloFlexionDerecha() {
		return tobilloFlexionDerecha;
	}

	/**
	 * Gets the tobillo flexion izquierda.
	 * 
	 * @return the tobillo flexion izquierda
	 */
	public String getTobilloFlexionIzquierda() {
		return tobilloFlexionIzquierda;
	}

	/**
	 * Gets the tobillo inflexion derecha.
	 * 
	 * @return the tobillo inflexion derecha
	 */
	public String getTobilloInflexionDerecha() {
		return tobilloInflexionDerecha;
	}

	/**
	 * Gets the tobillo inflexion izquierda.
	 * 
	 * @return the tobillo inflexion izquierda
	 */
	public String getTobilloInflexionIzquierda() {
		return tobilloInflexionIzquierda;
	}

	/**
	 * Gets the usuario.
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Gets the videos.
	 * 
	 * @return the videos
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * Sets the analisis observacional marcha.
	 * 
	 * @param analisisObservacionalMarcha
	 *            the new analisis observacional marcha
	 */
	public void setAnalisisObservacionalMarcha(AnalisisObservacionalMarcha analisisObservacionalMarcha) {
		this.analisisObservacionalMarcha = analisisObservacionalMarcha;
	}

	/**
	 * Sets the cadera flexion derecha.
	 * 
	 * @param caderaFlexionDerecha
	 *            the new cadera flexion derecha
	 */
	public void setCaderaFlexionDerecha(String caderaFlexionDerecha) {
		this.caderaFlexionDerecha = caderaFlexionDerecha;
	}

	/**
	 * Sets the cadera flexion izquierda.
	 * 
	 * @param caderaFlexionIzquierda
	 *            the new cadera flexion izquierda
	 */
	public void setCaderaFlexionIzquierda(String caderaFlexionIzquierda) {
		this.caderaFlexionIzquierda = caderaFlexionIzquierda;
	}

	/**
	 * Sets the cadera inflexion derecha.
	 * 
	 * @param caderaInflexionDerecha
	 *            the new cadera inflexion derecha
	 */
	public void setCaderaInflexionDerecha(String caderaInflexionDerecha) {
		this.caderaInflexionDerecha = caderaInflexionDerecha;
	}

	/**
	 * Sets the cadera inflexion izquierda.
	 * 
	 * @param caderaInflexionIzquierda
	 *            the new cadera inflexion izquierda
	 */
	public void setCaderaInflexionIzquierda(String caderaInflexionIzquierda) {
		this.caderaInflexionIzquierda = caderaInflexionIzquierda;
	}

	/**
	 * Sets the control motor selectivo.
	 * 
	 * @param controlMotorSelectivo
	 *            the new control motor selectivo
	 */
	public void setControlMotorSelectivo(String controlMotorSelectivo) {
		this.controlMotorSelectivo = controlMotorSelectivo;
	}

	/**
	 * Sets the evaluacion muscular.
	 * 
	 * @param evaluacionMuscular
	 *            the new evaluacion muscular
	 */
	public void setEvaluacionMuscular(String evaluacionMuscular) {
		this.evaluacionMuscular = evaluacionMuscular;
	}

	/**
	 * Sets the fecha.
	 * 
	 * @param fecha
	 *            the new fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Sets the ficheros emt.
	 * 
	 * @param ficherosEMT
	 *            the new ficheros emt
	 */
	public void setFicherosEMT(List<FicheroEMT> ficherosEMT) {
		this.ficherosEMT = ficherosEMT;
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
	 * Sets the longitud miembro derecho.
	 * 
	 * @param longitudMiembroDerecho
	 *            the new longitud miembro derecho
	 */
	public void setLongitudMiembroDerecho(Integer longitudMiembroDerecho) {
		this.longitudMiembroDerecho = longitudMiembroDerecho;
	}

	/**
	 * Sets the longitud miembro izquierdo.
	 * 
	 * @param longitudMiembroIzquierdo
	 *            the new longitud miembro izquierdo
	 */
	public void setLongitudMiembroIzquierdo(Integer longitudMiembroIzquierdo) {
		this.longitudMiembroIzquierdo = longitudMiembroIzquierdo;
	}

	/**
	 * Sets the paciente.
	 * 
	 * @param paciente
	 *            the new paciente
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	/**
	 * Sets the puntuacion500 metros.
	 * 
	 * @param puntuacion500Metros
	 *            the new puntuacion500 metros
	 */
	public void setPuntuacion500Metros(Integer puntuacion500Metros) {
		this.puntuacion500Metros = puntuacion500Metros;
	}

	/**
	 * Sets the puntuacion50 metros.
	 * 
	 * @param puntuacion50Metros
	 *            the new puntuacion50 metros
	 */
	public void setPuntuacion50Metros(Integer puntuacion50Metros) {
		this.puntuacion50Metros = puntuacion50Metros;
	}

	/**
	 * Sets the puntuacion5 metros.
	 * 
	 * @param puntuacion5Metros
	 *            the new puntuacion5 metros
	 */
	public void setPuntuacion5Metros(Integer puntuacion5Metros) {
		this.puntuacion5Metros = puntuacion5Metros;
	}

	/**
	 * Sets the rodilla flexion derecha.
	 * 
	 * @param rodillaFlexionDerecha
	 *            the new rodilla flexion derecha
	 */
	public void setRodillaFlexionDerecha(String rodillaFlexionDerecha) {
		this.rodillaFlexionDerecha = rodillaFlexionDerecha;
	}

	/**
	 * Sets the rodilla flexion izquierda.
	 * 
	 * @param rodillaFlexionIzquierda
	 *            the new rodilla flexion izquierda
	 */
	public void setRodillaFlexionIzquierda(String rodillaFlexionIzquierda) {
		this.rodillaFlexionIzquierda = rodillaFlexionIzquierda;
	}

	/**
	 * Sets the rodilla inflexion derecha.
	 * 
	 * @param rodillaInflexionDerecha
	 *            the new rodilla inflexion derecha
	 */
	public void setRodillaInflexionDerecha(String rodillaInflexionDerecha) {
		this.rodillaInflexionDerecha = rodillaInflexionDerecha;
	}

	/**
	 * Sets the rodilla inflexion izquierda.
	 * 
	 * @param rodillaInflexionIzquierda
	 *            the new rodilla inflexion izquierda
	 */
	public void setRodillaInflexionIzquierda(String rodillaInflexionIzquierda) {
		this.rodillaInflexionIzquierda = rodillaInflexionIzquierda;
	}

	/**
	 * Sets the tobillo flexion derecha.
	 * 
	 * @param tobilloFlexionDerecha
	 *            the new tobillo flexion derecha
	 */
	public void setTobilloFlexionDerecha(String tobilloFlexionDerecha) {
		this.tobilloFlexionDerecha = tobilloFlexionDerecha;
	}

	/**
	 * Sets the tobillo flexion izquierda.
	 * 
	 * @param tobilloFlexionIzquierda
	 *            the new tobillo flexion izquierda
	 */
	public void setTobilloFlexionIzquierda(String tobilloFlexionIzquierda) {
		this.tobilloFlexionIzquierda = tobilloFlexionIzquierda;
	}

	/**
	 * Sets the tobillo inflexion derecha.
	 * 
	 * @param tobilloInflexionDerecha
	 *            the new tobillo inflexion derecha
	 */
	public void setTobilloInflexionDerecha(String tobilloInflexionDerecha) {
		this.tobilloInflexionDerecha = tobilloInflexionDerecha;
	}

	/**
	 * Sets the tobillo inflexion izquierda.
	 * 
	 * @param tobilloInflexionIzquierda
	 *            the new tobillo inflexion izquierda
	 */
	public void setTobilloInflexionIzquierda(String tobilloInflexionIzquierda) {
		this.tobilloInflexionIzquierda = tobilloInflexionIzquierda;
	}

	/**
	 * Sets the usuario.
	 * 
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Sets the videos.
	 * 
	 * @param videos
	 *            the new videos
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
