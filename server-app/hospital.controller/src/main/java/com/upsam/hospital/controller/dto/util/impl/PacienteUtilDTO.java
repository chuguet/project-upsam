package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.enums.Escolarizacion;
import com.upsam.hospital.model.enums.Sexo;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class PacienteUtilDTO implements IPacienteUtilDTO {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	@Inject
	private IExploracionUtilDTO exploracionUtilDTO;

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
			paciente.setEscolarizacion(Escolarizacion.values()[pacienteDTO.getEscolarizacion()]);
			if (pacienteDTO.getFechaNacimiento() != null && pacienteDTO.getFechaNacimiento().length() == 10) {
				paciente.setFechaNacimiento(DATE_FORMATTER.parse(pacienteDTO.getFechaNacimiento()));
			}
			paciente.setId(pacienteDTO.getId());
			paciente.setNombre(pacienteDTO.getNombre());
			paciente.setNumeroIdentificacion(pacienteDTO.getNumeroIdentificacion());
			paciente.setSexo(Sexo.values()[pacienteDTO.getSexo()]);
			paciente.setTelefono(pacienteDTO.getTelefono());
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
		pacienteDTO.setEscolarizacion(paciente.getEscolarizacion().ordinal());
		if (paciente.getFechaUltimaEvaluacion() != null) {
			pacienteDTO.setFechaEvaluacion(DATE_FORMATTER.format(paciente.getFechaUltimaEvaluacion()));
		}
		if (paciente.getFechaNacimiento() != null) {
			pacienteDTO.setFechaNacimiento(DATE_FORMATTER.format(paciente.getFechaNacimiento()));
		}
		pacienteDTO.setId(paciente.getId());
		pacienteDTO.setNombre(paciente.getNombre());
		pacienteDTO.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
		pacienteDTO.setSexo(paciente.getSexo().ordinal());
		pacienteDTO.setTelefono(paciente.getTelefono());
		if (paciente.getExploraciones() != null && paciente.getExploraciones().size() > 0) {
			List<ExploracionDTO> exploracionesDTO = new ArrayList<ExploracionDTO>();
			for (Exploracion exploracion : paciente.getExploraciones()) {
				ExploracionDTO exploracionDTO = this.exploracionUtilDTO.toRest(exploracion);
				exploracionesDTO.add(exploracionDTO);
			}
			pacienteDTO.setExploraciones(exploracionesDTO);
		}
		return pacienteDTO;
	}
}
