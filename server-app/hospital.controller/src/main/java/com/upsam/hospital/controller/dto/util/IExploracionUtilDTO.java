package com.upsam.hospital.controller.dto.util;

import java.util.List;
import com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO;
import com.upsam.hospital.controller.dto.AntecedentesPersonalesPCIDTO;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;
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
	 * @param antecedentesPersonalesDTO
	 *            the antecedentes personales dto
	 * @return the antecedentes personales
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	AntecedentesPersonales toBusiness(AntecedentesPersonalesDTO antecedentesPersonalesDTO) throws TransferObjectException;

	/**
	 * To business.
	 * 
	 * @param antecedentesPersonalesPCIDTO
	 *            the antecedentes personales pcidto
	 * @return the antecedentes personales pci
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	AntecedentesPersonalesPCI toBusiness(AntecedentesPersonalesPCIDTO antecedentesPersonalesPCIDTO) throws TransferObjectException;

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
	 * @param antecedentesPersonales
	 *            the antecedentes personales
	 * @return the antecedentes personales dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	AntecedentesPersonalesDTO toRest(AntecedentesPersonales antecedentesPersonales) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param antecedentesPersonalesPCI
	 *            the antecedentes personales pci
	 * @return the antecedentes personales pcidto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	AntecedentesPersonalesPCIDTO toRest(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws TransferObjectException;

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
