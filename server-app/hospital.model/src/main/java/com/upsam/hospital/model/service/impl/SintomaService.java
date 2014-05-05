package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Sintoma;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.ISintomaRepository;
import com.upsam.hospital.model.service.ISintomaService;

// TODO: Auto-generated Javadoc
/**
 * The Class SintomaService.
 */
@Service
public class SintomaService implements ISintomaService {

	/** The sintoma repository. */
	@Inject
	private ISintomaRepository sintomaRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Sintoma sintoma) throws DataBaseException {
		try {
			sintomaRepository.delete(sintoma);
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
	public List<Sintoma> findAll() throws DataBaseException {
		try {
			return sintomaRepository.findAll();
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
	public Sintoma findOne(Integer pId) throws DataBaseException {
		try {
			return sintomaRepository.findOne(pId);
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
	public Integer save(Sintoma sintoma) throws DataBaseException {
		try {
			return sintomaRepository.save(sintoma);
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
	public void update(Sintoma sintoma) throws DataBaseException {
		try {
			sintomaRepository.update(sintoma);
		}
		catch (SQLException ex) {
			throw new DataBaseException(ex);
		}
	}

}
