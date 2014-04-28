package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAntecedentesPersonalesPCIRepository.
 */
public interface IAntecedentesRelacionadosPCIRepository extends IRepositoryDAO<AntecedentesRelacionadosPCI> {

	/**
	 * Find by exploracion.
	 * 
	 * @param pId
	 *            the id
	 * @return the antecedentes personales pci
	 * @throws SQLException
	 *             the sQL exception
	 */
	AntecedentesRelacionadosPCI findByExploracion(Integer pId) throws SQLException;
}
