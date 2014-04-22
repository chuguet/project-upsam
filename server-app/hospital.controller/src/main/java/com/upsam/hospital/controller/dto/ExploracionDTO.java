package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class ExploracionDTO extends AbstractDTO {

	private String controlMotorSelectivo;
	private String evaluacionMuscular;
	private String nombreUsuario;
	private Integer idUsuario;
	private String fecha;
	private Double longitudMiembroDerecho;
	private Double longitudMiembroIzquierdo;
	private Double puntuacion5Metros;
	private Double puntuacion50Metros;
	private Double puntuacion500Metros;
	private Integer analisisObservacionalMarcha;
	private List<VideoDTO> videos = new ArrayList<VideoDTO>();

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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getAnalisisObservacionalMarcha() {
		return analisisObservacionalMarcha;
	}

	public void setAnalisisObservacionalMarcha(Integer analisisObservacionalMarcha) {
		this.analisisObservacionalMarcha = analisisObservacionalMarcha;
	}

}