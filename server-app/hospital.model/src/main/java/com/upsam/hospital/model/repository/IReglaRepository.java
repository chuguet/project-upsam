package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.Regla;

// TODO: Auto-generated Javadoc
/**
 * The Interface IReglaRepository.
 */
public interface IReglaRepository extends IRepositoryDAO<Regla> {

	/**
	 * Retrieve reglas info.
	 * 
	 * @return the list
	 * @throws SQLException
	 *             the sQL exception
	 */
	List<Regla> retrieveReglasInfo() throws SQLException;

	/**
	 * Retrieve reglas warning.
	 * 
	 * @return the list
	 * @throws SQLException
	 *             the sQL exception
	 */
	List<Regla> retrieveReglasWarning() throws SQLException;

}
