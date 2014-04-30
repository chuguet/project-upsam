package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.GrossMotorFunction;

// TODO: Auto-generated Javadoc
/**
 * The Interface IGrossMotorFunction.
 */
public interface IGrossMotorFunctionRepository extends IRepositoryDAO<GrossMotorFunction> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the gross motor function
	 * @throws SQLException
	 *             the SQL exception
	 */
	GrossMotorFunction findByExploracion(Integer pId) throws SQLException;
}
