package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAntecedentesPersonalesPCIRepository.
 */
public interface IAntecedentesPersonalesPCIRepository extends IRepositoryDAO<AntecedentesPersonalesPCI> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the antecedentes personales pci
	 * @throws SQLException
	 *             the sQL exception
	 */
	AntecedentesPersonalesPCI findByExploracion(Integer pId) throws SQLException;
}
