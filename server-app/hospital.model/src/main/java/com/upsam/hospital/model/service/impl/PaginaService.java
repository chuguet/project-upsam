package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Pagina;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IPaginaRepository;
import com.upsam.hospital.model.service.IPaginaService;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginaService.
 */
@Service
public class PaginaService implements IPaginaService {

	/** The parte cuerpo repository. */
	@Inject
	private IPaginaRepository paginaRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Pagina pagina) throws DataBaseException {
		try {
			paginaRepository.delete(pagina);
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
	public List<Pagina> findAll() throws DataBaseException {
		try {
			return paginaRepository.findAll();
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
	public Pagina findOne(Integer pId) throws DataBaseException {
		try {
			return paginaRepository.findOne(pId);
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
	public Integer save(Pagina pagina) throws DataBaseException {
		try {
			return paginaRepository.save(pagina);
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
	public void update(Pagina pagina) throws DataBaseException {
		try {
			paginaRepository.update(pagina);
		}
		catch (SQLException ex) {
			throw new DataBaseException(ex);
		}
	}

}
