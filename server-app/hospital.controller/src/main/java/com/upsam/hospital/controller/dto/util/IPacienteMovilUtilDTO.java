package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPacienteMovilUtilDTO.
 */
public interface IPacienteMovilUtilDTO {

	/**
	 * To rest movil.
	 * 
	 * @param paciente
	 *            the paciente
	 * @return the paciente movil dto
	 */
	PacienteMovilDTO toRest(Paciente paciente);

	/**
	 * To business movil.
	 * 
	 * @param pacienteMovilDTO
	 *            the paciente movil dto
	 * @return the paciente
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Paciente toBusiness(PacienteMovilDTO pacienteMovilDTO) throws TransferObjectException;

}
