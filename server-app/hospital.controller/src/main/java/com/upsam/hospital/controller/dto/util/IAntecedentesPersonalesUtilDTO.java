package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExploracionUtilDTO.
 */
public interface IAntecedentesPersonalesUtilDTO {

	/**
	 * To business.
	 *
	 * @param antecedentesPersonalesDTO the antecedentes personales dto
	 * @return the antecedentes personales
	 * @throws TransferObjectException the transfer object exception
	 */
	AntecedentesPersonales toBusiness(AntecedentesPersonalesDTO antecedentesPersonalesDTO) throws TransferObjectException;

	/**
	 * To rest.
	 *
	 * @param antecedentesPersonales the antecedentes personales
	 * @return the antecedentes personales dto
	 * @throws TransferObjectException the transfer object exception
	 */
	AntecedentesPersonalesDTO toRest(AntecedentesPersonales antecedentesPersonales) throws TransferObjectException;
}
