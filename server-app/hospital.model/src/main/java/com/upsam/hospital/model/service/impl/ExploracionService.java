package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IExploracionRepository;
import com.upsam.hospital.model.service.IExploracionService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExploracionService.
 */
@Service
public class ExploracionService implements IExploracionService {

	/** The exploracion repository. */
	@Inject
	private IExploracionRepository exploracionRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Exploracion exploracion) throws DataBaseException {
		try {
			exploracionRepository.delete(exploracion);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al eliminar una exploración");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<Exploracion> findAll() throws DataBaseException {
		try {
			return exploracionRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar todas las exploraciones");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public Exploracion findOne(Integer pId) throws DataBaseException {
		try {
			return exploracionRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar una exploración por su identificador");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IExploracionService#findOneUniqueExploracion
	 * (java.lang.Integer)
	 */
	@Override
	public Exploracion findOneUnique(Integer pId) throws DataBaseException {
		try {
			return exploracionRepository.findOneUnique(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar la exploracione de un paciente");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IExploracionService#findReducedListByPatient
	 * (java.lang.Integer)
	 */
	@Override
	public List<Exploracion> findReducedListByPatient(Integer pId) throws DataBaseException {
		try {
			return exploracionRepository.findReducedListByPatient(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar las exploraciones de un paciente");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Exploracion exploracion) throws DataBaseException {
		try {
			return exploracionRepository.save(exploracion);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al guardar una exploración");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Exploracion exploracion) throws DataBaseException {
		try {
			exploracionRepository.update(exploracion);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar una exploración");
		}
	}
}
