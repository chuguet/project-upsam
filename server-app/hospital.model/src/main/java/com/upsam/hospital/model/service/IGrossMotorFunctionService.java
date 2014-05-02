package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGrossMotorFunctionService.
 */
public interface IGrossMotorFunctionService extends IModelService<GrossMotorFunction> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the gross motor function
	 * @throws DataBaseException
	 *             the data base exception
	 */
	GrossMotorFunction findByExploracion(Integer pId) throws DataBaseException;
}
