package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.SintomaDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Sintoma;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISintomaUtilDTO.
 */
public interface ISintomaUtilDTO {

	/**
	 * To business.
	 * 
	 * @param sintomaDTO
	 *            the sintoma dto
	 * @return the sintoma
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Sintoma toBusiness(SintomaDTO sintomaDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param sintoma
	 *            the sintoma
	 * @return the sintoma dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	SintomaDTO toRest(Sintoma sintoma) throws TransferObjectException;

}
