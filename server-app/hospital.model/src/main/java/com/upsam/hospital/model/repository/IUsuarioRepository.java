package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioRepository.
 */
public interface IUsuarioRepository extends IRepositoryDAO<Usuario> {

	/**
	 * Find user by email.
	 * 
	 * @param email
	 *            the email
	 * @return the usuario
	 * @throws SQLException
	 *             the sQL exception
	 */
	Usuario findUserByEmail(String email) throws SQLException;

	/**
	 * Select by token.
	 * 
	 * @param token
	 *            the token
	 * @return the usuario
	 * @throws SQLException
	 *             the sQL exception
	 */
	Usuario selectByToken(String token) throws SQLException;

	/**
	 * Select by user.
	 * 
	 * @param user
	 *            the user
	 * @return the usuario
	 * @throws SQLException
	 *             the sql exception
	 */
	Usuario selectByUser(String user) throws SQLException;
}
