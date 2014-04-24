package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAntecedentesPersonalesService.
 */
public interface IAntecedentesPersonalesPCIService extends IModelService<AntecedentesPersonalesPCI> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the antecedentes personales PCI
	 * @throws DataBaseException
	 *             the data base exception
	 */
	AntecedentesPersonalesPCI findByExploracion(Integer pId) throws DataBaseException;
}
