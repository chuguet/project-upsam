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
	 * @throws AppException
	 *             the app exception
	 */
	Paciente toBusiness(PacienteDTO usuarioDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario dto
	 * @throws AppException
	 *             the app exception
	 */
	PacienteDTO toRest(Paciente paciente) throws TransferObjectException;

}
