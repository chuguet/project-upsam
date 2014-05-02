package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.GrossMotorFunctionDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.GrossMotorFunction;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGrossMotorFunctionUtilDTO.
 */
public interface IGrossMotorFunctionUtilDTO {

	/**
	 * To business.
	 * 
	 * @param grossMotorFunctionDTO
	 *            the gross motor function dto
	 * @return the gross motor function
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	GrossMotorFunction toBusiness(GrossMotorFunctionDTO grossMotorFunctionDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param grossMotorFunction
	 *            the gross motor function
	 * @return the gross motor function dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	GrossMotorFunctionDTO toRest(GrossMotorFunction grossMotorFunction) throws TransferObjectException;
}
