package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IReglaService.
 */
public interface IReglaService extends IModelService<Regla> {

	/**
	 * Do faq.
	 * 
	 * @param exploracion
	 *            the exploracion
	 * @return the faq dto
	 * @throws DataBaseException
	 *             the data base exception
	 * @throws SecurityException
	 *             the security exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 */
	Faq doFaq(Exploracion exploracion) throws DataBaseException, SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException;

	/**
	 * Retrieve reglas info.
	 * 
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<Regla> retrieveReglasInfo() throws DataBaseException;

	/**
	 * Retrieve reglas warning.
	 * 
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	List<Regla> retrieveReglasWarning() throws DataBaseException;

}
