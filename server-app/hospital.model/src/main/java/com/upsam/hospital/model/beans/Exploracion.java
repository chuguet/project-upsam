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

// TODO: Auto-generated Javadoc
/**
 * The Class Exploracion.
 */
@Entity
@Table(name = "EXPLORACION")
public class Exploracion implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6079197394341566835L;

	/** The control motor selectivo. */
	@Basic
	@Column(name = "CONTROL_MOTOR_SELECTIVO")
	private Integer controlMotorSelectivo;

	/** The fecha. */
	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	/** The fichero emt. */
	@OneToMany(mappedBy = "exploracion")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<FicheroEMT> ficherosEMT;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPLORACION")
	private Integer id;

	/** The paciente. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	/** The usuario. */
	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	/** The video. */
	@OneToMany(mappedBy = "exploracion")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Video> videos;

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

	/**
	 * Gets the control motor selectivo.
	 * 
	 * @return the control motor selectivo
	 */
	public Integer getControlMotorSelectivo() {
		return controlMotorSelectivo;
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
	 * Gets the paciente.
	 * 
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
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
	 * Sets the control motor selectivo.
	 * 
	 * @param controlMotorSelectivo
	 *            the new control motor selectivo
	 */
	public void setControlMotorSelectivo(Integer controlMotorSelectivo) {
		this.controlMotorSelectivo = controlMotorSelectivo;
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
	 * Sets the paciente.
	 * 
	 * @param paciente
	 *            the new paciente
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

}
