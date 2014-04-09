package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPacienteMovilUtilDTO.
 */
public interface IPacienteMovilUtilDTO {

	/**
	 * To rest all.
	 * 
	 * @param paciente
	 *            the paciente
	 * @return the list
	 */
	PacienteMovilDTO toRestMovil(Paciente paciente);
}
