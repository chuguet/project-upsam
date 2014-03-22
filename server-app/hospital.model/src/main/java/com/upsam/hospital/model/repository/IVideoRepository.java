package com.upsam.hospital.model.repository;

import java.sql.SQLException;

import com.upsam.hospital.model.beans.Usuario;

/**
 * The Interface IUsuarioRepository.
 */
public interface IVideoRepository extends IRepositoryDAO<Usuario> {

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
