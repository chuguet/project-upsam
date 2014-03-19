package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class PacienteUtilDTO implements IPacienteUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

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
