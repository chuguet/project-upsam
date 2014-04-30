package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.ValoracionArticularMuscular;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IValoracionArticularMuscularService.
 */
public interface IValoracionArticularMuscularService extends IModelService<ValoracionArticularMuscular> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the valoracion articular muscular
	 * @throws DataBaseException
	 *             the data base exception
	 */
	ValoracionArticularMuscular findByExploracion(Integer pId) throws DataBaseException;
}
