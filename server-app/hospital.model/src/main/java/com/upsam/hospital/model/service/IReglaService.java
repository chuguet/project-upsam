package com.upsam.hospital.model.service;

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
	 * @throws TransferObjectException
	 *             the transfer object exception
	 * @throws DataBaseException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	Faq doFaq(Exploracion exploracion) throws DataBaseException, SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException;

}
