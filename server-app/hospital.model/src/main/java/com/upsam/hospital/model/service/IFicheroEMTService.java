package com.upsam.hospital.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFicheroEMTService.
 */
public interface IFicheroEMTService extends IModelService<FicheroEMT> {

	/**
	 * File reader emt.
	 *
	 * @param file            the file
	 * @param idExploracion the id exploracion
	 * @return the fichero emt
	 * @throws IOException             Signals that an I/O exception has occurred.
	 */
	FicheroEMT fileReaderEMT(File file, Integer idExploracion) throws IOException;

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<FicheroEMT> findByExploracion(Integer pId) throws DataBaseException;
	
	/**
	 * Find one unique.
	 *
	 * @param pId the id
	 * @return the fichero emt
	 * @throws DataBaseException the data base exception
	 */
	FicheroEMT findOneUnique(Integer pId) throws DataBaseException;
}
