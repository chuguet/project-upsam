package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.repository.IPacienteRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoRepository.
 */
@Repository
public class VideoRepository implements IPacienteRepository {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	@Override
	public void delete(Paciente paciente) throws SQLException {
		hibernateTemplate.delete(paciente);
	}

	@Override
	public List<Paciente> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Paciente.class);
	}

	@Override
	public Paciente findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Paciente.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Paciente paciente) throws SQLException {
		return (Integer) hibernateTemplate.save(paciente);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Paciente paciente) throws SQLException {
		hibernateTemplate.update(paciente);
	}

}
