package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.IModelHospital;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IModelService.
 * 
 * @param <T>
 *            the generic type
 */
public interface IModelService<T extends IModelHospital> {

	/**
	 * Delete.
	 * 
	 * @param t
	 *            the t
	 */
	void delete(T t) throws DataBaseException;

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	List<T> findAll() throws DataBaseException;

	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the t
	 */
	T findOne(Integer pId) throws DataBaseException;

	/**
	 * Save.
	 * 
	 * @param t
	 *            the t
	 */
	Integer save(T t) throws DataBaseException;

	/**
	 * Update.
	 * 
	 * @param t
	 *            the t
	 */
	void update(T t) throws DataBaseException;
}
