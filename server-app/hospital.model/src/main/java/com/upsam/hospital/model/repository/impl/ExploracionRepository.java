package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.repository.IExploracionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteRepository.
 */
@Repository
class ExploracionRepository implements IExploracionRepository {

	private static final String QUERY_FINDBY_ID_PATIENT = "Select new Exploracion(id, fecha, usuario) from Exploracion where ID_PACIENTE = ?";

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Exploracion exploracion) throws SQLException {
		hibernateTemplate.delete(exploracion);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Exploracion> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Exploracion.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Exploracion findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Exploracion.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Exploracion exploracion) throws SQLException {
		return (Integer) hibernateTemplate.save(exploracion);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Exploracion exploracion) throws SQLException {
		hibernateTemplate.update(exploracion);
	}

	@Override
	public List<Exploracion> findReducedListByPatient(Integer idPatient) throws SQLException {
		return hibernateTemplate.find(QUERY_FINDBY_ID_PATIENT, idPatient);
	}
}
