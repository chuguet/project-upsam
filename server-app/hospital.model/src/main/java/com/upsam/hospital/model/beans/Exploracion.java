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

@Entity
@Table(name = "EXPLORACION")
public class Exploracion implements IModelHospital {

	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EXPLORACION")
	private Integer id;

	@Column(name = "CONTROL_MOTOR_SELECTIVO")
	private Integer controlMotorSelectivo;

	/** The exploracion3d. */
	@OneToMany(mappedBy = "exploracion")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Video> videos;

	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_PACIENTE")
	private Paciente paciente;

	@ManyToOne
	@Cascade(value = CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@Basic
	@Column(name = "FECHA")
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getControlMotorSelectivo() {
		return controlMotorSelectivo;
	}

	public void setControlMotorSelectivo(Integer controlMotorSelectivo) {
		this.controlMotorSelectivo = controlMotorSelectivo;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Exploracion() {

	}

	public Exploracion(Integer id, Date fecha, Usuario usuario) {
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
	}
}
