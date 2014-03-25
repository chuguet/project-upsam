package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Fichero3D;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFichero3DRepository;
import com.upsam.hospital.model.service.IFichero3DService;

// TODO: Auto-generated Javadoc
/**
 * The Class Fichero3DService.
 */
@Service
public class Fichero3DService implements IFichero3DService {

	/** The fichero3 d repository. */
	@Inject
	private IFichero3DRepository fichero3DRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Fichero3D fichero3D) throws DataBaseException {
		try {
			fichero3DRepository.delete(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<Fichero3D> findAll() throws DataBaseException {
		try {
			return fichero3DRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public Fichero3D findOne(Integer pId) throws DataBaseException {
		try {
			return fichero3DRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Fichero3D fichero3D) throws DataBaseException {
		try {
			return fichero3DRepository.save(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Fichero3D fichero3D) throws DataBaseException {
		try {
			fichero3DRepository.update(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

}
