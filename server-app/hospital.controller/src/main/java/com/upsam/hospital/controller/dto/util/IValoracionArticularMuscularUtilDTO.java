package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.ValoracionArticularMuscularDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;

// TODO: Auto-generated Javadoc
/**
 * The Interface IValoracionArticularMuscularUtilDTO.
 */
public interface IValoracionArticularMuscularUtilDTO {

	/**
	 * To business.
	 * 
	 * @param valoracionArticularMuscularDTO
	 *            the valoracion articular muscular dto
	 * @return the valoracion articular muscular
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	ValoracionArticularMuscular toBusiness(ValoracionArticularMuscularDTO valoracionArticularMuscularDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param valoracionArticularMuscular
	 *            the valoracion articular muscular
	 * @return the valoracion articular muscular dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	ValoracionArticularMuscularDTO toRest(ValoracionArticularMuscular valoracionArticularMuscular) throws TransferObjectException;
}
