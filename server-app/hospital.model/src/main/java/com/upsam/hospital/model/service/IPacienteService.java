package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPacienteService.
 */
public interface IPacienteService extends IModelService<Paciente> {

	/**
	 * Find by id name surname.
	 * 
	 * @param idNameSurname
	 *            the id name surname
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<Paciente> findByIdNameSurname(String idNameSurname) throws DataBaseException;

	/**
	 * Find one unique.
	 * 
	 * @param pId
	 *            the id
	 * @return the paciente
	 * @throws DataBaseException
	 *             the data base exception
	 */
	Paciente findOneUnique(Integer pId) throws DataBaseException;
}
