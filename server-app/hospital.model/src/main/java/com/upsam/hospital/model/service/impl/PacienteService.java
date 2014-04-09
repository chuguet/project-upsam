package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IPacienteRepository;
import com.upsam.hospital.model.service.IPacienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteService.
 */
@Service
public class PacienteService implements IPacienteService {

	/** The paciente repository. */
	@Inject
	private IPacienteRepository pacienteRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Paciente paciente) throws DataBaseException {
		try {
			pacienteRepository.delete(paciente);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<Paciente> findAll() throws DataBaseException {
		try {
			return pacienteRepository.findAll();
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
	public Paciente findOne(Integer pId) throws DataBaseException {
		try {
			return pacienteRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Paciente paciente) throws DataBaseException {
		try {
			return pacienteRepository.save(paciente);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Paciente paciente) throws DataBaseException {
		try {
			pacienteRepository.update(paciente);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar un paciente");
		}
	}

	@Override
	public List<Paciente> findByIdNameSurname(String idNameSurname) throws DataBaseException {
		try {
			return pacienteRepository.findByIdNameSurname(idNameSurname);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar los pacientes");
		}
	}
}
