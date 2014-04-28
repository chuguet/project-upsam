package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesRelacionadosPCIRepository;
import com.upsam.hospital.model.service.IAntecedentesRelacionadosPCIService;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesService.
 */
@Service
public class AntecedentesRelacionadosPCIService implements IAntecedentesRelacionadosPCIService {

	/** The antecedentes personales repository. */
	@Inject
	private IAntecedentesRelacionadosPCIRepository antecedentesPersonalesRepositoryPCI;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(AntecedentesRelacionadosPCI antecedentesPersonalesPCI) throws DataBaseException {
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
	public List<AntecedentesRelacionadosPCI> findAll() throws DataBaseException {
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
	public AntecedentesRelacionadosPCI findByExploracion(Integer pId) throws DataBaseException {
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
	public AntecedentesRelacionadosPCI findOne(Integer pId) throws DataBaseException {
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
	public Integer save(AntecedentesRelacionadosPCI antecedentesPersonalesPCI) throws DataBaseException {
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
	public void update(AntecedentesRelacionadosPCI antecedentesPersonalesPCI) throws DataBaseException {
		try {
			antecedentesPersonalesRepositoryPCI.update(antecedentesPersonalesPCI);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar un antecedente personal PCI");
		}
	}

}
