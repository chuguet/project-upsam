package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.IModelHospital;

// TODO: Auto-generated Javadoc
/**
 * The Interface IRepositoryDAO.
 * 
 * @param <T>
 *            the generic type
 */
public interface IRepositoryDAO<T extends IModelHospital> {

	/**
	 * Delete.
	 * 
	 * @param t
	 *            the t
	 * @throws SQLException
	 *             the SQL exception
	 */
	void delete(T t) throws SQLException;

	/**
	 * Find all.
	 * 
	 * @return the list
	 * @throws SQLException
	 *             the SQL exception
	 */
	List<T> findAll() throws SQLException;

	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the t
	 * @throws SQLException
	 *             the SQL exception
	 */
	T findOne(Integer pId) throws SQLException;

	/**
	 * Merge.
	 * 
	 * @param t
	 *            the t
	 * @return the t
	 * @throws SQLException
	 *             the SQL exception
	 */
	T merge(T t) throws SQLException;

	/**
	 * Save.
	 * 
	 * @param t
	 *            the t
	 * @return the integer
	 * @throws SQLException
	 *             the SQL exception
	 */
	Integer save(T t) throws SQLException;

	/**
	 * Update.
	 * 
	 * @param t
	 *            the t
	 * @throws SQLException
	 *             the SQL exception
	 */
	void update(T t) throws SQLException;
}
