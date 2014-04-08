package com.upsam.hospital.model.service;

import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioService.
 */
public interface IUsuarioService extends IModelService<Usuario> {

	/**
	 * Find user by email.
	 * 
	 * @param email
	 *            the email
	 * @return the usuario
	 * @throws DataBaseException
	 *             the data base exception
	 */
	Usuario findUserByEmail(String email) throws DataBaseException;

	/**
	 * Select by token.
	 * 
	 * @param token
	 *            the token
	 * @return the usuario
	 * @throws DataBaseException
	 *             the data base exception
	 */
	Usuario selectByToken(String token) throws DataBaseException;

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
