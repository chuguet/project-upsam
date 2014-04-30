package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFaqsService.
 */
public interface IFaqsService extends IModelService<Faq> {

	/**
	 * Find by seccion.
	 * 
	 * @param seccion
	 *            the seccion
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<Faq> findBySeccion(String seccion) throws DataBaseException;
}
