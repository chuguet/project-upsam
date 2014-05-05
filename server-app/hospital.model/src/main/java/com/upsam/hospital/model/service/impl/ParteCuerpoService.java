package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.ParteCuerpo;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IParteCuerpoRepository;
import com.upsam.hospital.model.service.IParteCuerpoService;

// TODO: Auto-generated Javadoc
/**
 * The Class ParteCuerpoService.
 */
@Service
public class ParteCuerpoService implements IParteCuerpoService {

	/** The parte cuerpo repository. */
	@Inject
	private IParteCuerpoRepository parteCuerpoRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(ParteCuerpo parteCuerpo) throws DataBaseException {
		try {
			parteCuerpoRepository.delete(parteCuerpo);
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
	public List<ParteCuerpo> findAll() throws DataBaseException {
		try {
			return parteCuerpoRepository.findAll();
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
	public ParteCuerpo findOne(Integer pId) throws DataBaseException {
		try {
			return parteCuerpoRepository.findOne(pId);
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
	public Integer save(ParteCuerpo parteCuerpo) throws DataBaseException {
		try {
			return parteCuerpoRepository.save(parteCuerpo);
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
	public void update(ParteCuerpo parteCuerpo) throws DataBaseException {
		try {
			parteCuerpoRepository.update(parteCuerpo);
		}
		catch (SQLException ex) {
			throw new DataBaseException(ex);
		}
	}

}
