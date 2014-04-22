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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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

	private static final long serialVersionUID = 6079197394341566835L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPLORACION")
	private Integer id;

	@Basic
	@Column(name = "CONTROL_MOTOR_SELECTIVO")
	private String controlMotorSelectivo;

	@Basic
	@Column(name = "EVALUACION_MUSCULAR")
	private String evaluacionMuscular;

	/** The usuario. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	@Basic
	@Column(name = "LONGITUD_MIEMBRO_DERECHO")
	private Double longitudMiembroDerecho;

	@Basic
	@Column(name = "LONGITUD_MIEMBRO_IZQUIERDO")
	private Double longitudMiembroIzquierdo;

	@Basic
	@Column(name = "PUNTUACION_5_METROS")
	private Double puntuacion5Metros;

	@Basic
	@Column(name = "PUNTUACION_50_METROS")
	private Double puntuacion50Metros;

	@Basic
	@Column(name = "PUNTUACION_500_METROS")
	private Double puntuacion500Metros;

	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	@Basic
	@Column(name = "ANALISIS_OBSERVACIONAL_MARCHA")
	private AnalisisObservacionalMarcha AnalisisObservacionalMarcha;

	@OneToMany(mappedBy = "exploracion")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Video> videos;

	/** The fichero emt. */
	@OneToMany(mappedBy = "exploracion")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<FicheroEMT> ficherosEMT;

	/**
	 * Instantiates a new exploracion.
	 */
	public Exploracion() {

	}

	/**
	 * Instantiates a new exploracion.
	 * 
	 * @param id
	 *            the id
	 * @param fecha
	 *            the fecha
	 * @param usuario
	 *            the usuario
	 */
	public Exploracion(Integer id, Date fecha, Usuario usuario) {
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getControlMotorSelectivo() {
		return controlMotorSelectivo;
	}

	public void setControlMotorSelectivo(String controlMotorSelectivo) {
		this.controlMotorSelectivo = controlMotorSelectivo;
	}

	public String getEvaluacionMuscular() {
		return evaluacionMuscular;
	}

	public void setEvaluacionMuscular(String evaluacionMuscular) {
		this.evaluacionMuscular = evaluacionMuscular;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getLongitudMiembroDerecho() {
		return longitudMiembroDerecho;
	}

	public void setLongitudMiembroDerecho(Double longitudMiembroDerecho) {
		this.longitudMiembroDerecho = longitudMiembroDerecho;
	}

	public Double getLongitudMiembroIzquierdo() {
		return longitudMiembroIzquierdo;
	}

	public void setLongitudMiembroIzquierdo(Double longitudMiembroIzquierdo) {
		this.longitudMiembroIzquierdo = longitudMiembroIzquierdo;
	}

	public Double getPuntuacion5Metros() {
		return puntuacion5Metros;
	}

	public void setPuntuacion5Metros(Double puntuacion5Metros) {
		this.puntuacion5Metros = puntuacion5Metros;
	}

	public Double getPuntuacion50Metros() {
		return puntuacion50Metros;
	}

	public void setPuntuacion50Metros(Double puntuacion50Metros) {
		this.puntuacion50Metros = puntuacion50Metros;
	}

	public Double getPuntuacion500Metros() {
		return puntuacion500Metros;
	}

	public void setPuntuacion500Metros(Double puntuacion500Metros) {
		this.puntuacion500Metros = puntuacion500Metros;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<FicheroEMT> getFicherosEMT() {
		return ficherosEMT;
	}

	public void setFicherosEMT(List<FicheroEMT> ficherosEMT) {
		this.ficherosEMT = ficherosEMT;
	}

	public AnalisisObservacionalMarcha getAnalisisObservacionalMarcha() {
		return AnalisisObservacionalMarcha;
	}

	public void setAnalisisObservacionalMarcha(AnalisisObservacionalMarcha analisisObservacionalMarcha) {
		AnalisisObservacionalMarcha = analisisObservacionalMarcha;
	}

}
