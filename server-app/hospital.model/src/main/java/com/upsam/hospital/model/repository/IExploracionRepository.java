package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.Exploracion;

// TODO: Auto-generated Javadoc
/**
 * The Interface IExploracionRepository.
 */
public interface IExploracionRepository extends IRepositoryDAO<Exploracion> {

	/**
	 * Find reduced list by patient.
	 * 
	 * @param pId
	 *            the id
	 * @return the list
	 * @throws SQLException
	 *             the SQL exception
	 */
	List<Exploracion> findReducedListByPatient(Integer pId) throws SQLException;

}
