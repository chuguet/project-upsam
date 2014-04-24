package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAntecedentesPersonalesRepository.
 */
public interface IAntecedentesPersonalesRepository extends IRepositoryDAO<AntecedentesPersonales> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the antecedentes personales
	 * @throws SQLException
	 *             the sQL exception
	 */
	AntecedentesPersonales findByExploracion(Integer pId) throws SQLException;
}
