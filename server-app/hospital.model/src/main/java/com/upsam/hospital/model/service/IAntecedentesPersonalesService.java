package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAntecedentesPersonalesService.
 */
public interface IAntecedentesPersonalesService extends IModelService<AntecedentesPersonales> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the antecedentes personales
	 * @throws DataBaseException
	 *             the data base exception
	 */
	AntecedentesPersonales findByExploracion(Integer pId) throws DataBaseException;
}
