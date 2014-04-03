package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.FicheroEMT;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFicheroEMTRepository.
 */
public interface IFicheroEMTRepository extends IRepositoryDAO<FicheroEMT> {

	/**
	 * Find by paciente.
	 * 
	 * @param pId
	 *            the id
	 * @return the list
	 * @throws SQLException
	 *             the sQL exception
	 */
	List<FicheroEMT> findByPaciente(Integer pId) throws SQLException;
}
