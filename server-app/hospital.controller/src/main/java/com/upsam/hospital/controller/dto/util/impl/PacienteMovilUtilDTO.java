package com.upsam.hospital.controller.dto.util.impl;

import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.model.beans.Paciente;

@Component
public class PacienteMovilUtilDTO implements IPacienteMovilUtilDTO {
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public PacienteMovilDTO toRestMovil(Paciente paciente) {
		PacienteMovilDTO pacienteMovilDTO = new PacienteMovilDTO();
		pacienteMovilDTO.setId(paciente.getId());
		pacienteMovilDTO.setApellidos(paciente.getApellidos());
		pacienteMovilDTO.setNombre(paciente.getNombre());
		pacienteMovilDTO.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
		String fechaNacimiento = (paciente.getFechaNacimiento() != null) ? DATE_TIME_FORMATTER.format(paciente.getFechaNacimiento()) : "No informada";
		pacienteMovilDTO.setFechaNacimiento(fechaNacimiento);

		String fechaEvaluacion = (paciente.getFechaUltimaEvaluacion() != null) ? DATE_TIME_FORMATTER.format(paciente.getFechaUltimaEvaluacion()) : "No le han hecho";
		pacienteMovilDTO.setFechaUltimaEvaluacion(fechaEvaluacion);
		return pacienteMovilDTO;
	}

}
