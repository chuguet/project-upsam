package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.ReglaDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Regla;

// TODO: Auto-generated Javadoc
/**
 * The Interface IReglaUtilDTO.
 */
public interface IReglaUtilDTO {

	/**
	 * To business.
	 * 
	 * @param reglaDTO
	 *            the regla dto
	 * @return the regla
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Regla toBusiness(ReglaDTO reglaDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param regla
	 *            the regla
	 * @return the regla dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	ReglaDTO toRest(Regla regla) throws TransferObjectException;
}
