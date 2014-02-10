package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.UsuarioDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioUtilDTO.
 */
public interface IUsuarioUtilDTO {

	/**
	 * To business.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the usuario
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Usuario toBusiness(UsuarioDTO usuarioDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	UsuarioDTO toRest(Usuario usuario) throws TransferObjectException;

}
