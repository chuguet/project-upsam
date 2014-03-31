package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.Video3dDTO;
import com.upsam.hospital.controller.dto.Video3dInfoDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Fichero3D;
import com.upsam.hospital.model.beans.Paciente;
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
	@Inject
	private IVideoUtilDTO videoUtilDTO;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#file3dToDTO(com
	 * .upsam.hospital.model.jaxb.EmxDataFile)
	 */
	@Override
	public Video3dDTO file3dToDTO(EmxDataFile emxDataFile) {
		System.out.println("LLEGO");
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#getVideo3dInfoList
	 * (java.util.List)
	 */
	@Override
	public List<Video3dInfoDTO> getVideo3dInfoList(List<Fichero3D> ficheros) {
		List<Video3dInfoDTO> result = new ArrayList<Video3dInfoDTO>();
		Video3dInfoDTO video3dInfoDTO;
		for (Fichero3D fichero3D : ficheros) {
			video3dInfoDTO = new Video3dInfoDTO();
			video3dInfoDTO.setFecha(DATE_TIME_FORMATTER.format(new Date(fichero3D.getFecha())));
			video3dInfoDTO.setNombre(fichero3D.getNombre());
			video3dInfoDTO.setId(fichero3D.getId());
			result.add(video3dInfoDTO);
		}
		return result;
	}

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
			paciente.setEscolarizacion(pacienteDTO.getEscolarizacion());
			paciente.setExaminador(pacienteDTO.getExaminador());
			paciente.setFechaEvaluacion(DATE_FORMATTER.parse(pacienteDTO.getFechaEvaluacion()));
			paciente.setFechaNacimiento(DATE_FORMATTER.parse(pacienteDTO.getFechaNacimiento()));
			paciente.setId(pacienteDTO.getId());
			paciente.setNombre(pacienteDTO.getNombre());
			paciente.setNumeroIdentificacion(pacienteDTO.getNumeroIdentificacion());
			paciente.setSexo(pacienteDTO.getSexo());
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
		pacienteDTO.setEscolarizacion(paciente.getEscolarizacion());
		pacienteDTO.setExaminador(paciente.getExaminador());
		pacienteDTO.setFechaEvaluacion(DATE_FORMATTER.format(paciente.getFechaEvaluacion()));
		pacienteDTO.setFechaNacimiento(DATE_FORMATTER.format(paciente.getFechaNacimiento()));
		pacienteDTO.setId(paciente.getId());
		pacienteDTO.setNombre(paciente.getNombre());
		pacienteDTO.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
		pacienteDTO.setSexo(paciente.getSexo());
		return pacienteDTO;
	}
}
