package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.enums.Escolarizacion;
import com.upsam.hospital.model.enums.Sexo;

@Component
public class PacienteMovilUtilDTO implements IPacienteMovilUtilDTO {
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public PacienteMovilDTO toRestMovil(Paciente paciente) {
		PacienteMovilDTO pacienteMovilDTO = new PacienteMovilDTO();

		String fechaEvaluacion = paciente.getFechaUltimaEvaluacion() != null ? DATE_FORMATTER.format(paciente.getFechaUltimaEvaluacion()) : null;
		String fechaNacimiento = paciente.getFechaNacimiento() != null ? DATE_FORMATTER.format(paciente.getFechaNacimiento()) : null;
		Integer sexo = paciente.getSexo() != null ? paciente.getSexo().ordinal() : null;
		Integer escolarizacion = paciente.getEscolarizacion() != null ? paciente.getEscolarizacion().ordinal() : null;

		pacienteMovilDTO.setId(paciente.getId());
		pacienteMovilDTO.setApellidos(paciente.getApellidos());
		pacienteMovilDTO.setNombre(paciente.getNombre());
		pacienteMovilDTO.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
		pacienteMovilDTO.setFechaNacimiento(fechaNacimiento);
		pacienteMovilDTO.setFechaUltimaEvaluacion(fechaEvaluacion);
		pacienteMovilDTO.setTelefono(paciente.getTelefono());
		pacienteMovilDTO.setCurso(paciente.getCurso());
		pacienteMovilDTO.setSexo(sexo);
		pacienteMovilDTO.setEscolarizacion(escolarizacion);
		return pacienteMovilDTO;
	}

	@Override
	public Paciente toBusinessMovil(PacienteMovilDTO pacienteMovilDTO) throws TransferObjectException {
		Paciente paciente = null;
		try {
			paciente = new Paciente();

			Escolarizacion escolarizacion = new Integer(-1).equals(pacienteMovilDTO.getEscolarizacion()) ? null : Escolarizacion.values()[pacienteMovilDTO.getEscolarizacion()];
			String curso = pacienteMovilDTO.getCurso().isEmpty() ? null : pacienteMovilDTO.getCurso();
			Date fechaNacimiento = pacienteMovilDTO.getFechaNacimiento() == null || pacienteMovilDTO.getFechaNacimiento().isEmpty() ? null : DATE_FORMATTER.parse(pacienteMovilDTO.getFechaNacimiento());
			Date fechaUltimaEvaluacion = pacienteMovilDTO.getFechaUltimaEvaluacion() == null || pacienteMovilDTO.getFechaUltimaEvaluacion().isEmpty() ? null : DATE_FORMATTER.parse(pacienteMovilDTO.getFechaUltimaEvaluacion());
			String telefono = pacienteMovilDTO.getTelefono().isEmpty() ? null : pacienteMovilDTO.getTelefono();

			paciente.setNombre(pacienteMovilDTO.getNombre());
			paciente.setApellidos(pacienteMovilDTO.getApellidos());
			paciente.setNumeroIdentificacion(pacienteMovilDTO.getNumeroIdentificacion());
			paciente.setCurso(curso);
			paciente.setEscolarizacion(escolarizacion);
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setFechaUltimaEvaluacion(fechaUltimaEvaluacion);
			paciente.setSexo(Sexo.values()[pacienteMovilDTO.getSexo()]);
			paciente.setTelefono(telefono);
			paciente.setId(pacienteMovilDTO.getId());
		}
		catch (ParseException e) {
			throw new TransferObjectException(e.getMessage(), e);
		}
		return paciente;
	}

}
