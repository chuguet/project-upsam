package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IGrossMotorFunctionRepository;
import com.upsam.hospital.model.service.IGrossMotorFunctionService;

// TODO: Auto-generated Javadoc
/**
 * The Class GrossMotorFunctionService.
 */
@Service
public class GrossMotorFunctionService implements IGrossMotorFunctionService {

	/** The gross motor function repository. */
	@Inject
	private IGrossMotorFunctionRepository grossMotorFunctionRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(GrossMotorFunction grossMotorFunction) throws DataBaseException {
		try {
			grossMotorFunctionRepository.delete(grossMotorFunction);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al eliminar un gross motor function");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<GrossMotorFunction> findAll() throws DataBaseException {
		try {
			return grossMotorFunctionRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar todos los gross motor function");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IGrossMotorFunctionService#findByExploracion
	 * (java.lang.Integer)
	 */
	@Override
	public GrossMotorFunction findByExploracion(Integer pId) throws DataBaseException {
		try {
			return grossMotorFunctionRepository.findByExploracion(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un gross motor function por exploracion");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public GrossMotorFunction findOne(Integer pId) throws DataBaseException {
		try {
			return grossMotorFunctionRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un gross motor function");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(GrossMotorFunction grossMotorFunction) throws DataBaseException {
		try {
			return grossMotorFunctionRepository.save(grossMotorFunction);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al insertar un gross motor function");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(GrossMotorFunction grossMotorFunction) throws DataBaseException {
		try {
			grossMotorFunctionRepository.update(grossMotorFunction);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar un gross motor function");
		}
	}

}
