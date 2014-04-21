package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class ExploracionDTO extends AbstractDTO {

	private Integer id;
	private Integer controlMotorSelectivo;
	private String nombreUsuario;
	private List<VideoDTO> videos = new ArrayList<VideoDTO>();
	private String fecha;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getControlMotorSelectivo() {
		return controlMotorSelectivo;
	}

	public void setControlMotorSelectivo(Integer controlMotorSelectivo) {
		this.controlMotorSelectivo = controlMotorSelectivo;
	}

	public List<VideoDTO> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoDTO> videos) {
		this.videos = videos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
