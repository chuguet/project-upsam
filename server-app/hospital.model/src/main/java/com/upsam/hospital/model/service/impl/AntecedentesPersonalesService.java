package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesRepository;
import com.upsam.hospital.model.service.IAntecedentesPersonalesService;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesService.
 */
@Service
public class AntecedentesPersonalesService implements IAntecedentesPersonalesService {

	/** The antecedentes personales repository. */
	@Inject
	private IAntecedentesPersonalesRepository antecedentesPersonalesRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(AntecedentesPersonales antecedentesPersonales) throws DataBaseException {
		try {
			antecedentesPersonalesRepository.delete(antecedentesPersonales);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al eliminar un antecedente personal");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<AntecedentesPersonales> findAll() throws DataBaseException {
		try {
			return antecedentesPersonalesRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar todas los antecedentes personales");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IAntecedentesPersonalesService#
	 * findByExploracion(java.lang.Integer)
	 */
	@Override
	public AntecedentesPersonales findByExploracion(Integer pId) throws DataBaseException {
		try {
			return antecedentesPersonalesRepository.findByExploracion(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un antecedente personal");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public AntecedentesPersonales findOne(Integer pId) throws DataBaseException {
		try {
			return antecedentesPersonalesRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un antecedente personal por su identificador");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(AntecedentesPersonales antecedentesPersonales) throws DataBaseException {
		try {
			return antecedentesPersonalesRepository.save(antecedentesPersonales);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al insertar un antecedente personal");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(AntecedentesPersonales antecedentesPersonales) throws DataBaseException {
		try {
			antecedentesPersonalesRepository.update(antecedentesPersonales);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar un antecedente personal");
		}
	}

}
