package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPacienteService.
 */
public interface IExploracionService extends IModelService<Exploracion> {

	/**
	 * Find reduced list by patient.
	 * 
	 * @param pId
	 *            the id
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<Exploracion> findReducedListByPatient(Integer pId) throws DataBaseException;

}