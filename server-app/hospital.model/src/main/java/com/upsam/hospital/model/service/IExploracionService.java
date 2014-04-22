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
	 * Find one unique.
	 * 
	 * @param pId
	 *            the id
	 * @return the exploracion
	 * @throws DataBaseException
	 *             the data base exception
	 */
	Exploracion findOneUnique(Integer pId) throws DataBaseException;

	/**
	 * Find reduced list by patient.
	 * 
	 * @param pIdPaciente
	 *            the id Paciente
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<Exploracion> findReducedListByPatient(Integer pIdPaciente) throws DataBaseException;

}