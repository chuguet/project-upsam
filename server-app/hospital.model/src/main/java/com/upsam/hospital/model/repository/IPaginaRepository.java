package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.Pagina;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPaginaRepository.
 */
public interface IPaginaRepository extends IRepositoryDAO<Pagina> {

	/**
	 * Retrieve paginas info.
	 * 
	 * @return the list
	 */
	List<Pagina> retrievePaginasInfo() throws SQLException;

}
