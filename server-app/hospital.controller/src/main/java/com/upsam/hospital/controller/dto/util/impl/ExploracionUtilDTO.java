package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.AngleDTO;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.dto.PointDTO;
import com.upsam.hospital.controller.dto.TablaDatosDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Angle;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.beans.Point;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.enums.AnalisisObservacionalMarcha;
import com.upsam.hospital.model.jaxb.EmxDataFile;

// TODO: Auto-generated Javadoc
/**
 * The Class ExploracionUtilDTO.
 */
@Component
public class ExploracionUtilDTO implements IExploracionUtilDTO {

	/** The Constant DATE_TIME_FORMATTER. */
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/** The video util dto. */
	@Inject
	private IVideoUtilDTO videoUtilDTO;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IExploracionUtilDTO#doFaq(com.
	 * upsam.hospital.model.beans.Exploracion)
	 */
	@Override
	public FaqDTO doFaq(Exploracion exploracion) throws TransferObjectException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#fileEMTToDTO(
	 * com.upsam.hospital.model.beans.FicheroEMT)
	 */
	@Override
	public FicheroEMTDTO fileEMTToDTO(FicheroEMT ficheroEMT) {
		AngleDTO angleDTO;
		PointDTO pointDTO;
		FicheroEMTDTO result = new FicheroEMTDTO();
		result.setId(ficheroEMT.getId());
		result.setCiclos(ficheroEMT.getCiclos());
		result.setFecha(DATE_TIME_FORMATTER.format(ficheroEMT.getFecha()));
		result.setTipoMedida(ficheroEMT.getTipoMedida().getNameId());
		result.setUnidadMedida(ficheroEMT.getUnidadMedida().getNameId());
		TablaDatosDTO tablaDatosDTO = new TablaDatosDTO();
		result.setTablaDatos(tablaDatosDTO);
		for (Angle angle : ficheroEMT.getTablaDatos().getAngles()) {
			angleDTO = new AngleDTO();
			angleDTO.setName(angle.getName());
			for (Point point : angle.getPoints()) {
				pointDTO = new PointDTO();
				pointDTO.setC(point.getCoord());
				angleDTO.addPointDTO(pointDTO);
			}
			tablaDatosDTO.addAngleDTO(angleDTO);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#file3dToDTO(com
	 * .upsam.hospital.model.jaxb.EmxDataFile)
	 */
	@Override
	public FicheroMDXDTO fileMDXToDTO(EmxDataFile emxDataFile) {
		System.out.println("LLEGO");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#
	 * getFicherosEMTInfoList(java.util.List)
	 */
	@Override
	public List<FicheroEMTInfoDTO> getFicherosEMTInfoList(List<FicheroEMT> ficherosEMT) {
		List<FicheroEMTInfoDTO> result = new ArrayList<FicheroEMTInfoDTO>();
		FicheroEMTInfoDTO ficheroEMTInfoDTO;
		for (FicheroEMT ficheroEMT : ficherosEMT) {
			ficheroEMTInfoDTO = new FicheroEMTInfoDTO();
			ficheroEMTInfoDTO.setId(ficheroEMT.getId());
			ficheroEMTInfoDTO.setFecha(DATE_TIME_FORMATTER.format(ficheroEMT.getFecha()));
			result.add(ficheroEMTInfoDTO);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#getVideo3dInfoList
	 * (java.util.List)
	 */
	@Override
	public List<FicheroMDXInfoDTO> getFicherosMDXInfoList(List<FicheroMDX> ficheros) {
		List<FicheroMDXInfoDTO> result = new ArrayList<FicheroMDXInfoDTO>();
		FicheroMDXInfoDTO video3dInfoDTO;
		for (FicheroMDX fichero3D : ficheros) {
			video3dInfoDTO = new FicheroMDXInfoDTO();
			video3dInfoDTO.setFecha(DATE_TIME_FORMATTER.format(new Date(fichero3D.getFecha())));
			video3dInfoDTO.setNombre(fichero3D.getNombre());
			video3dInfoDTO.setId(fichero3D.getId());
			result.add(video3dInfoDTO);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#toBusiness(com
	 * .upsam.hospital.controller.dto.PacienteDTO)
	 */
	@Override
	public Exploracion toBusiness(ExploracionDTO exploracionDTO) throws TransferObjectException {
		Exploracion exploracion = new Exploracion();
		try {
			exploracion.setId(exploracionDTO.getId());
			exploracion.setControlMotorSelectivo(exploracionDTO.getControlMotorSelectivo());
			exploracion.setEvaluacionMuscular(exploracionDTO.getEvaluacionMuscular());
			exploracion.setLongitudMiembroDerecho(exploracionDTO.getLongitudMiembroDerecho());
			exploracion.setLongitudMiembroIzquierdo(exploracionDTO.getLongitudMiembroIzquierdo());
			exploracion.setPuntuacion5Metros(exploracionDTO.getPuntuacion5Metros());
			exploracion.setPuntuacion50Metros(exploracionDTO.getPuntuacion50Metros());
			exploracion.setPuntuacion500Metros(exploracionDTO.getPuntuacion500Metros());
			exploracion.setUsuario(new Usuario(exploracionDTO.getIdUsuario()));
			exploracion.setCaderaFlexionIzquierda(exploracionDTO.getCaderaFlexionIzquierda());
			exploracion.setCaderaFlexionDerecha(exploracionDTO.getCaderaFlexionDerecha());
			exploracion.setCaderaInflexionIzquierda(exploracionDTO.getCaderaInflexionIzquierda());
			exploracion.setCaderaInflexionDerecha(exploracionDTO.getCaderaInflexionDerecha());
			exploracion.setRodillaFlexionIzquierda(exploracionDTO.getRodillaFlexionIzquierda());
			exploracion.setRodillaFlexionDerecha(exploracionDTO.getRodillaFlexionDerecha());
			exploracion.setRodillaInflexionIzquierda(exploracionDTO.getRodillaInflexionIzquierda());
			exploracion.setRodillaInflexionDerecha(exploracionDTO.getRodillaInflexionDerecha());
			exploracion.setTobilloFlexionIzquierda(exploracionDTO.getTobilloFlexionIzquierda());
			exploracion.setTobilloFlexionDerecha(exploracionDTO.getTobilloFlexionDerecha());
			exploracion.setTobilloInflexionIzquierda(exploracionDTO.getTobilloInflexionIzquierda());
			exploracion.setTobilloInflexionDerecha(exploracionDTO.getTobilloInflexionDerecha());

			AnalisisObservacionalMarcha analisisObservacionalMarcha = new Integer(-1).equals(exploracionDTO.getAnalisisObservacionalMarcha()) ? null : AnalisisObservacionalMarcha.values()[exploracionDTO.getAnalisisObservacionalMarcha()];
			exploracion.setAnalisisObservacionalMarcha(analisisObservacionalMarcha);

			if (exploracionDTO.getFecha() != null && exploracionDTO.getFecha().length() > 0) {
				exploracion.setFecha(DATE_TIME_FORMATTER.parse(exploracionDTO.getFecha()));
			}

			exploracion.setFechaActualizacion(new Date());

			for (VideoDTO videoDTO : exploracionDTO.getVideos()) {
				Video video = videoUtilDTO.toBusiness(videoDTO);
				exploracion.addVideo(video);
			}

		}
		catch (ParseException e) {
			throw new TransferObjectException(e.getMessage(), e);
		}
		return exploracion;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#toRest(com.upsam
	 * .hospital.model.beans.Paciente)
	 */
	@Override
	public ExploracionDTO toRest(Exploracion exploracion) throws TransferObjectException {
		ExploracionDTO exploracionDTO = new ExploracionDTO();
		exploracionDTO.setId(exploracion.getId());
		exploracionDTO.setControlMotorSelectivo(exploracion.getControlMotorSelectivo());
		exploracionDTO.setEvaluacionMuscular(exploracion.getEvaluacionMuscular());
		exploracionDTO.setLongitudMiembroDerecho(exploracion.getLongitudMiembroDerecho());
		exploracionDTO.setLongitudMiembroIzquierdo(exploracion.getLongitudMiembroIzquierdo());
		exploracionDTO.setPuntuacion5Metros(exploracion.getPuntuacion5Metros());
		exploracionDTO.setPuntuacion50Metros(exploracion.getPuntuacion50Metros());
		exploracionDTO.setPuntuacion500Metros(exploracion.getPuntuacion500Metros());
		exploracionDTO.setIdUsuario(exploracion.getUsuario().getId());
		exploracionDTO.setNombreUsuario(exploracion.getUsuario().getNombreCompleto());
		exploracionDTO.setCaderaFlexionIzquierda(exploracion.getCaderaFlexionIzquierda());
		exploracionDTO.setCaderaFlexionDerecha(exploracion.getCaderaFlexionDerecha());
		exploracionDTO.setCaderaInflexionIzquierda(exploracion.getCaderaInflexionIzquierda());
		exploracionDTO.setCaderaInflexionDerecha(exploracion.getCaderaInflexionDerecha());
		exploracionDTO.setRodillaFlexionIzquierda(exploracion.getRodillaFlexionIzquierda());
		exploracionDTO.setRodillaFlexionDerecha(exploracion.getRodillaFlexionDerecha());
		exploracionDTO.setRodillaInflexionIzquierda(exploracion.getRodillaInflexionIzquierda());
		exploracionDTO.setRodillaInflexionDerecha(exploracion.getRodillaInflexionDerecha());
		exploracionDTO.setTobilloFlexionIzquierda(exploracion.getTobilloFlexionIzquierda());
		exploracionDTO.setTobilloFlexionDerecha(exploracion.getTobilloFlexionDerecha());
		exploracionDTO.setTobilloInflexionIzquierda(exploracion.getTobilloInflexionIzquierda());
		exploracionDTO.setTobilloInflexionDerecha(exploracion.getTobilloInflexionDerecha());

		exploracionDTO.setAnalisisObservacionalMarcha(exploracion.getAnalisisObservacionalMarcha() != null ? exploracion.getAnalisisObservacionalMarcha().ordinal() : null);

		if (exploracion.getFecha() != null) {
			exploracionDTO.setFecha(DATE_TIME_FORMATTER.format(exploracion.getFecha()));
		}

		if (exploracion.getFechaActualizacion() != null) {
			exploracionDTO.setFechaActualizacion(DATE_TIME_FORMATTER.format(exploracion.getFechaActualizacion()));
		}
		else {
			exploracionDTO.setFechaActualizacion("No actualizado");
		}

		if (exploracion.getVideos() != null && !exploracion.getVideos().isEmpty()) {
			for (Video video : exploracion.getVideos()) {
				VideoDTO videoDTO = videoUtilDTO.toRest(video);
				exploracionDTO.getVideos().add(videoDTO);
			}
		}

		return exploracionDTO;
	}
}
