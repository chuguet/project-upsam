package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.ParteCuerpoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.ParteCuerpo;

// TODO: Auto-generated Javadoc
/**
 * The Interface IParteCuerpoUtilDTO.
 */
public interface IParteCuerpoUtilDTO {

	/**
	 * To business.
	 * 
	 * @param parteCuerpoDTO
	 *            the parte cuerpo dto
	 * @return the parte cuerpo
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	ParteCuerpo toBusiness(ParteCuerpoDTO parteCuerpoDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param parteCuerpo
	 *            the parte cuerpo
	 * @return the parte cuerpo dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	ParteCuerpoDTO toRest(ParteCuerpo parteCuerpo) throws TransferObjectException;
}
