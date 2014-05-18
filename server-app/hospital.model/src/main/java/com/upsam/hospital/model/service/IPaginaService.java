package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.Pagina;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPaginaService.
 */
public interface IPaginaService extends IModelService<Pagina> {

	/**
	 * Retrieve paginas info.
	 * 
	 * @return the list
	 */
	List<Pagina> retrievePaginasInfo() throws DataBaseException;
}
