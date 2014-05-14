package com.upsam.hospital.controller.dto.util;

import java.util.List;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.jaxb.EmxDataFile;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExploracionUtilDTO.
 */
public interface IExploracionUtilDTO {

	/**
	 * Do faq.
	 * 
	 * @param exploracion
	 *            the exploracion
	 * @return the faq dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	FaqDTO doFaq(Exploracion exploracion) throws TransferObjectException;

	/**
	 * File emt to dto.
	 * 
	 * @param ficheroEMT
	 *            the fichero emt
	 * @return the fichero emtdto
	 */
	FicheroEMTDTO fileEMTToDTO(FicheroEMT ficheroEMT);

	/**
	 * File mdx to dto.
	 * 
	 * @param emxDataFile
	 *            the emx data file
	 * @return the fichero mdxdto
	 */
	FicheroMDXDTO fileMDXToDTO(EmxDataFile emxDataFile);

	/**
	 * Gets the ficheros emt info list.
	 * 
	 * @param ficheros
	 *            the ficheros
	 * @return the ficheros emt info list
	 */
	List<FicheroEMTInfoDTO> getFicherosEMTInfoList(List<FicheroEMT> ficheros);

	/**
	 * Gets the ficheros mdx info list.
	 * 
	 * @param ficheros
	 *            the ficheros
	 * @return the ficheros mdx info list
	 */
	List<FicheroMDXInfoDTO> getFicherosMDXInfoList(List<FicheroMDX> ficheros);

	/**
	 * To business.
	 * 
	 * @param exploracionDTO
	 *            the exploracion dto
	 * @return the exploracion
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Exploracion toBusiness(ExploracionDTO exploracionDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param exploracion
	 *            the exploracion
	 * @return the exploracion dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	ExploracionDTO toRest(Exploracion exploracion) throws TransferObjectException;
}
