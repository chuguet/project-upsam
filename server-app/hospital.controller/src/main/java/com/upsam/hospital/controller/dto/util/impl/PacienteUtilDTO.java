package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.AngleDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.PointDTO;
import com.upsam.hospital.controller.dto.TablaDatosDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Angle;
import com.upsam.hospital.model.beans.Escolarizacion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Point;
import com.upsam.hospital.model.beans.Sexo;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.jaxb.EmxDataFile;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class PacienteUtilDTO implements IPacienteUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	/** The Constant DATE_TIME_FORMATTER. */
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/** The video util dto. */
	@Inject
	private IVideoUtilDTO videoUtilDTO;

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
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#getVideosList
	 * (java.util.List)
	 */
	@Override
	public List<VideoDTO> getVideosList(List<Video> videos) throws TransferObjectException {
		List<VideoDTO> result = new ArrayList<VideoDTO>();
		for (Video video : videos) {
			result.add(this.videoUtilDTO.toRest(video));
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
	public Paciente toBusiness(PacienteDTO pacienteDTO) throws TransferObjectException {
		Paciente paciente = new Paciente();
		try {
			paciente.setApellidos(pacienteDTO.getApellidos());
			paciente.setCurso(pacienteDTO.getCurso());
			paciente.setEscolarizacion(Escolarizacion.getValue(pacienteDTO.getEscolarizacion()));
			paciente.setExaminador(pacienteDTO.getExaminador());
			paciente.setFechaUltimaEvaluacion(DATE_FORMATTER.parse(pacienteDTO.getFechaEvaluacion()));
			paciente.setFechaNacimiento(DATE_FORMATTER.parse(pacienteDTO.getFechaNacimiento()));
			paciente.setId(pacienteDTO.getId());
			paciente.setNombre(pacienteDTO.getNombre());
			paciente.setNumeroIdentificacion(pacienteDTO.getNumeroIdentificacion());
			paciente.setSexo(Sexo.getValue(pacienteDTO.getSexo()));
		}
		catch (ParseException e) {
			throw new TransferObjectException(e);
		}
		return paciente;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#toRest(com.upsam
	 * .hospital.model.beans.Paciente)
	 */
	@Override
	public PacienteDTO toRest(Paciente paciente) throws TransferObjectException {
		PacienteDTO pacienteDTO = new PacienteDTO();
		pacienteDTO.setApellidos(paciente.getApellidos());
		pacienteDTO.setCurso(paciente.getCurso());
		pacienteDTO.setEscolarizacion(paciente.getEscolarizacion().getNameId());
		pacienteDTO.setExaminador(paciente.getExaminador());
		pacienteDTO.setFechaEvaluacion(DATE_FORMATTER.format(paciente.getFechaUltimaEvaluacion()));
		pacienteDTO.setFechaNacimiento(DATE_FORMATTER.format(paciente.getFechaNacimiento()));
		pacienteDTO.setId(paciente.getId());
		pacienteDTO.setNombre(paciente.getNombre());
		pacienteDTO.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
		pacienteDTO.setSexo(paciente.getSexo().getNameId());
		return pacienteDTO;
	}
}
