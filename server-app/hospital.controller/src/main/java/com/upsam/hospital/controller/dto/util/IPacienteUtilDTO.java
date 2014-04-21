package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioUtilDTO.
 */
public interface IPacienteUtilDTO {
	/**
	 * To business.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the usuario
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Paciente toBusiness(PacienteDTO usuarioDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param paciente
	 *            the paciente
	 * @return the usuario dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	PacienteDTO toRest(Paciente paciente) throws TransferObjectException;
}