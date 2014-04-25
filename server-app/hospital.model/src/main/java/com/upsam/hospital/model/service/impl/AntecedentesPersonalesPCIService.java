package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesPCIRepository;
import com.upsam.hospital.model.service.IAntecedentesPersonalesPCIService;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesService.
 */
@Service
public class AntecedentesPersonalesPCIService implements IAntecedentesPersonalesPCIService {

	/** The antecedentes personales repository. */
	@Inject
	private IAntecedentesPersonalesPCIRepository antecedentesPersonalesRepositoryPCI;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws DataBaseException {
		try {
			antecedentesPersonalesRepositoryPCI.delete(antecedentesPersonalesPCI);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al eliminar un antecedente personal PCI");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<AntecedentesPersonalesPCI> findAll() throws DataBaseException {
		try {
			return antecedentesPersonalesRepositoryPCI.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar todas los antecedentes personales PCI");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IAntecedentesPersonalesService#
	 * findByExploracion(java.lang.Integer)
	 */
	@Override
	public AntecedentesPersonalesPCI findByExploracion(Integer pId) throws DataBaseException {
		try {
			return antecedentesPersonalesRepositoryPCI.findByExploracion(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un antecedente personal PCI");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public AntecedentesPersonalesPCI findOne(Integer pId) throws DataBaseException {
		try {
			return antecedentesPersonalesRepositoryPCI.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un antecedente personal PCI por su identificador");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws DataBaseException {
		try {
			return antecedentesPersonalesRepositoryPCI.save(antecedentesPersonalesPCI);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al insertar un antecedente personal PCI");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws DataBaseException {
		try {
			antecedentesPersonalesRepositoryPCI.update(antecedentesPersonalesPCI);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar un antecedente personal PCI");
		}
	}

}
