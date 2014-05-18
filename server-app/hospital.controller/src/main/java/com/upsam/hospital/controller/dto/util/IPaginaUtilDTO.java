package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.PaginaDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Pagina;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPaginaUtilDTO.
 */
public interface IPaginaUtilDTO {

	/**
	 * To business.
	 * 
	 * @param paginaDTO
	 *            the pagina dto
	 * @return the pagina
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Pagina toBusiness(PaginaDTO paginaDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param pagina
	 *            the pagina
	 * @return the pagina dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	PaginaDTO toRest(Pagina pagina) throws TransferObjectException;

	/**
	 * To rest info paginas.
	 * 
	 * @param pagina
	 *            the pagina
	 * @return the pagina dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	PaginaDTO toRestInfoPaginas(Pagina pagina) throws TransferObjectException;
}
