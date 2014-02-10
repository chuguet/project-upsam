package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioService.
 */
public interface IUsuarioService extends IModelService<Usuario> {

	/**
	 * Select by user.
	 * 
	 * @param user
	 *            the user
	 * @return the usuario
	 * @throws DataBaseException
	 *             the data base exception
	 */
	Usuario selectByUser(String user) throws DataBaseException;
}
