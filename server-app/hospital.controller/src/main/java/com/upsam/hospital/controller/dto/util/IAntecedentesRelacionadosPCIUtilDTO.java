package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.AntecedentesRelacionadosPCIDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExploracionUtilDTO.
 */
public interface IAntecedentesRelacionadosPCIUtilDTO {

	/**
	 * To business.
	 * 
	 * @param antecedentesPersonalesDTO
	 *            the antecedentes personales dto
	 * @return the antecedentes relacionados pci
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	AntecedentesRelacionadosPCI toBusiness(AntecedentesRelacionadosPCIDTO antecedentesPersonalesDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param antecedentesPersonales
	 *            the antecedentes personales
	 * @return the antecedentes relacionados pcidto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	AntecedentesRelacionadosPCIDTO toRest(AntecedentesRelacionadosPCI antecedentesPersonales) throws TransferObjectException;
}
