package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPacienteRepository.
 */
public interface IPacienteRepository extends IRepositoryDAO<Paciente> {

	/**
	 * Find by id name surname.
	 * 
	 * @param idNameSurname
	 *            the id name surname
	 * @return the list
	 * @throws SQLException
	 *             the sQL exception
	 */
	List<Paciente> findByIdNameSurname(String idNameSurname) throws SQLException;

	/**
	 * Find one unique.
	 * 
	 * @param pId
	 *            the id
	 * @return the paciente
	 * @throws SQLException
	 *             the sQL exception
	 */
	Paciente findOneUnique(Integer pId) throws SQLException;
}
