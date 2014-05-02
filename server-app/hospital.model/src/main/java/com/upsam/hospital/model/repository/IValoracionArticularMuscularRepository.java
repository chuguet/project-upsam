package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;

// TODO: Auto-generated Javadoc
/**
 * The Interface IValoracionArticularMuscularRepository.
 */
public interface IValoracionArticularMuscularRepository extends IRepositoryDAO<ValoracionArticularMuscular> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the valoracion articular muscular
	 * @throws SQLException
	 *             the SQL exception
	 */
	ValoracionArticularMuscular findByExploracion(Integer pId) throws SQLException;
}
