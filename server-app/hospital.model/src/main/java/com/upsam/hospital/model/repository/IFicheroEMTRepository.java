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
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the list
	 * @throws SQLException
	 *             the sQL exception
	 */
	List<FicheroEMT> findByExploracion(Integer pId) throws SQLException;

	/**
	 * Find one unique.
	 * 
	 * @param pId
	 *            the id
	 * @return the fichero emt
	 * @throws SQLException
	 *             the SQL exception
	 */
	FicheroEMT findOneUnique(Integer pId) throws SQLException;
}
