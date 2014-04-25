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

	@Basic
	@Column(name = "CADERA_FLEXION_IZQUIERDA")
	private String caderaFlexionIzquierda;
	@Basic
	@Column(name = "CADERA_FLEXION_DERECHA")
	private String caderaFlexionDerecha;
	@Basic
	@Column(name = "CADERA_INFLEXION_IZQUIERDA")
	private String caderaInflexionIzquierda;
	@Basic
	@Column(name = "CADERA_INFLEXION_DERECHA")
	private String caderaInflexionDerecha;
	@Basic
	@Column(name = "RODILLA_FLEXION_IZQUIERDA")
	private String rodillaFlexionIzquierda;
	@Basic
	@Column(name = "RODILLA_FLEXION_DERECHA")
	private String rodillaFlexionDerecha;
	@Basic
	@Column(name = "RODILLA_INFLEXION_IZQUIERDA")
	private String rodillaInflexionIzquierda;
	@Basic
	@Column(name = "RODILLA_INFLEXION_DERECHA")
	private String rodillaInflexionDerecha;
	@Basic
	@Column(name = "TOBILLO_FLEXION_IZQUIERDA")
	private String tobilloFlexionIzquierda;
	@Basic
	@Column(name = "TOBILLO_FLEXION_DERECHA")
	private String tobilloFlexionDerecha;
	@Basic
	@Column(name = "TOBILLO_INFLEXION_IZQUIERDA")
	private String tobilloInflexionIzquierda;
	@Basic
	@Column(name = "TOBILLO_INFLEXION_DERECHA")
	private String tobilloInflexionDerecha;

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

	public String getCaderaFlexionIzquierda() {
		return caderaFlexionIzquierda;
	}

	public void setCaderaFlexionIzquierda(String caderaFlexionIzquierda) {
		this.caderaFlexionIzquierda = caderaFlexionIzquierda;
	}

	public String getCaderaFlexionDerecha() {
		return caderaFlexionDerecha;
	}

	public void setCaderaFlexionDerecha(String caderaFlexionDerecha) {
		this.caderaFlexionDerecha = caderaFlexionDerecha;
	}

	public String getCaderaInflexionIzquierda() {
		return caderaInflexionIzquierda;
	}

	public void setCaderaInflexionIzquierda(String caderaInflexionIzquierda) {
		this.caderaInflexionIzquierda = caderaInflexionIzquierda;
	}

	public String getCaderaInflexionDerecha() {
		return caderaInflexionDerecha;
	}

	public void setCaderaInflexionDerecha(String caderaInflexionDerecha) {
		this.caderaInflexionDerecha = caderaInflexionDerecha;
	}

	public String getRodillaFlexionIzquierda() {
		return rodillaFlexionIzquierda;
	}

	public void setRodillaFlexionIzquierda(String rodillaFlexionIzquierda) {
		this.rodillaFlexionIzquierda = rodillaFlexionIzquierda;
	}

	public String getRodillaFlexionDerecha() {
		return rodillaFlexionDerecha;
	}

	public void setRodillaFlexionDerecha(String rodillaFlexionDerecha) {
		this.rodillaFlexionDerecha = rodillaFlexionDerecha;
	}

	public String getRodillaInflexionIzquierda() {
		return rodillaInflexionIzquierda;
	}

	public void setRodillaInflexionIzquierda(String rodillaInflexionIzquierda) {
		this.rodillaInflexionIzquierda = rodillaInflexionIzquierda;
	}

	public String getRodillaInflexionDerecha() {
		return rodillaInflexionDerecha;
	}

	public void setRodillaInflexionDerecha(String rodillaInflexionDerecha) {
		this.rodillaInflexionDerecha = rodillaInflexionDerecha;
	}

	public String getTobilloFlexionIzquierda() {
		return tobilloFlexionIzquierda;
	}

	public void setTobilloFlexionIzquierda(String tobilloFlexionIzquierda) {
		this.tobilloFlexionIzquierda = tobilloFlexionIzquierda;
	}

	public String getTobilloFlexionDerecha() {
		return tobilloFlexionDerecha;
	}

	public void setTobilloFlexionDerecha(String tobilloFlexionDerecha) {
		this.tobilloFlexionDerecha = tobilloFlexionDerecha;
	}

	public String getTobilloInflexionIzquierda() {
		return tobilloInflexionIzquierda;
	}

	public void setTobilloInflexionIzquierda(String tobilloInflexionIzquierda) {
		this.tobilloInflexionIzquierda = tobilloInflexionIzquierda;
	}

	public String getTobilloInflexionDerecha() {
		return tobilloInflexionDerecha;
	}

	public void setTobilloInflexionDerecha(String tobilloInflexionDerecha) {
		this.tobilloInflexionDerecha = tobilloInflexionDerecha;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

}
