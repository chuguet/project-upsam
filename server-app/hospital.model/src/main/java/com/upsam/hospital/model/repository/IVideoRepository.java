package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.beans.Video;

/**
 * The Interface IVideoRepository.
 */
public interface IVideoRepository extends IRepositoryDAO<Video> {

	/**
	 * Select by user.
	 * 
	 * @param user
	 *            the user
	 * @return the usuario
	 * @throws SQLException
	 *             the sql exception
	 */
	Usuario selectByPaciente() throws SQLException;
}
