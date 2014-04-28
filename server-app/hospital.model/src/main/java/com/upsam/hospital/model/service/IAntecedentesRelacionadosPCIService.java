package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAntecedentesPersonalesService.
 */
public interface IAntecedentesRelacionadosPCIService extends IModelService<AntecedentesRelacionadosPCI> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the antecedentes personales PCI
	 * @throws DataBaseException
	 *             the data base exception
	 */
	AntecedentesRelacionadosPCI findByExploracion(Integer pId) throws DataBaseException;
}
