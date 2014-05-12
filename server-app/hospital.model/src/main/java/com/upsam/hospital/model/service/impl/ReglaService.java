package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IReglaRepository;
import com.upsam.hospital.model.service.IReglaService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglasService.
 */
@Service
public class ReglaService implements IReglaService {

	/** The Reglas repository. */
	@Inject
	private IReglaRepository reglaRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Regla regla) throws DataBaseException {
		try {
			reglaRepository.delete(regla);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<Regla> findAll() throws DataBaseException {
		try {
			return reglaRepository.findAll();
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
	public Regla findOne(Integer pId) throws DataBaseException {
		try {
			return reglaRepository.findOne(pId);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Regla regla) throws DataBaseException {
		try {
			return reglaRepository.save(regla);
		}
		catch (SQLException ex) {
			throw new DataBaseException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Regla regla) throws DataBaseException {
		try {
			reglaRepository.update(regla);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}
}
