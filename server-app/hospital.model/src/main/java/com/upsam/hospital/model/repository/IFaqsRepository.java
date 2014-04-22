package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.Faq;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFaqsRepository.
 */
public interface IFaqsRepository extends IRepositoryDAO<Faq> {

	/**
	 * Find by seccion.
	 * 
	 * @param seccion
	 *            the seccion
	 * @return the list
	 * @throws SQLException
	 *             the SQL exception
	 */
	List<Faq> findBySeccion(String seccion) throws SQLException;
}
