package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IValoracionArticularMuscularRepository;
import com.upsam.hospital.model.service.IValoracionArticularMuscularService;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionArticularMuscularService.
 */
@Service
public class ValoracionArticularMuscularService implements IValoracionArticularMuscularService {

	/** The valoracion articular muscular repository. */
	@Inject
	private IValoracionArticularMuscularRepository valoracionArticularMuscularRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(ValoracionArticularMuscular valoracionArticularMuscular) throws DataBaseException {
		try {
			valoracionArticularMuscularRepository.delete(valoracionArticularMuscular);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al eliminar una valoracion articular muscular");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<ValoracionArticularMuscular> findAll() throws DataBaseException {
		try {
			return valoracionArticularMuscularRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar todos las valoraciones articulares musculares");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IValoracionArticularMuscularService#
	 * findByExploracion(java.lang.Integer)
	 */
	@Override
	public ValoracionArticularMuscular findByExploracion(Integer pId) throws DataBaseException {
		try {
			return valoracionArticularMuscularRepository.findByExploracion(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar una valoracion articular muscular por exploracion");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public ValoracionArticularMuscular findOne(Integer pId) throws DataBaseException {
		try {
			return valoracionArticularMuscularRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar una valoracion articular muscular");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(ValoracionArticularMuscular valoracionArticularMuscular) throws DataBaseException {
		try {
			return valoracionArticularMuscularRepository.save(valoracionArticularMuscular);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al insertar una valoracion articular muscular");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(ValoracionArticularMuscular valoracionArticularMuscular) throws DataBaseException {
		try {
			valoracionArticularMuscularRepository.update(valoracionArticularMuscular);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar una valoracion articular muscular");
		}
	}

}
