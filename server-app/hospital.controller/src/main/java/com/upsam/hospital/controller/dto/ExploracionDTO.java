package com.upsam.hospital.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class ExploracionDTO extends AbstractDTO {

	private String controlMotorSelectivo;
	private String evaluacionMuscular;
	private String nombreUsuario;
	private Integer idUsuario;
	private String fecha;
	private String fechaActualizacion;
	private Integer longitudMiembroDerecho;
	private Integer longitudMiembroIzquierdo;
	private Integer puntuacion5Metros;
	private Integer puntuacion50Metros;
	private Integer puntuacion500Metros;
	private Integer analisisObservacionalMarcha;
	private String caderaFlexionIzquierda;
	private String caderaFlexionDerecha;
	private String caderaInflexionIzquierda;
	private String caderaInflexionDerecha;
	private String rodillaFlexionIzquierda;
	private String rodillaFlexionDerecha;
	private String rodillaInflexionIzquierda;
	private String rodillaInflexionDerecha;
	private String tobilloFlexionIzquierda;
	private String tobilloFlexionDerecha;
	private String tobilloInflexionIzquierda;
	private String tobilloInflexionDerecha;

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

	public Integer getLongitudMiembroDerecho() {
		return longitudMiembroDerecho;
	}

	public void setLongitudMiembroDerecho(Integer longitudMiembroDerecho) {
		this.longitudMiembroDerecho = longitudMiembroDerecho;
	}

	public Integer getLongitudMiembroIzquierdo() {
		return longitudMiembroIzquierdo;
	}

	public void setLongitudMiembroIzquierdo(Integer longitudMiembroIzquierdo) {
		this.longitudMiembroIzquierdo = longitudMiembroIzquierdo;
	}

	public Integer getPuntuacion5Metros() {
		return puntuacion5Metros;
	}

	public void setPuntuacion5Metros(Integer puntuacion5Metros) {
		this.puntuacion5Metros = puntuacion5Metros;
	}

	public Integer getPuntuacion50Metros() {
		return puntuacion50Metros;
	}

	public void setPuntuacion50Metros(Integer puntuacion50Metros) {
		this.puntuacion50Metros = puntuacion50Metros;
	}

	public Integer getPuntuacion500Metros() {
		return puntuacion500Metros;
	}

	public void setPuntuacion500Metros(Integer puntuacion500Metros) {
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

	public String getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
}