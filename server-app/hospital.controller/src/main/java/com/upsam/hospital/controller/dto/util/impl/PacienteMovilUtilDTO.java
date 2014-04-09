package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.model.beans.Paciente;

@Component
public class PacienteMovilUtilDTO implements IPacienteMovilUtilDTO {

	@Override
	public PacienteMovilDTO toRestMovil(Paciente paciente) {
		PacienteMovilDTO result = new PacienteMovilDTO();
		result.setApellidos(paciente.getApellidos());
		result.setNombre(paciente.getNombre());
		result.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
		return result;
	}

}
