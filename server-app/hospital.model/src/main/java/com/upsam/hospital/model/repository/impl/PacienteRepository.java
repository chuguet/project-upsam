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
 * The Class PacienteRepository.
 */
@Repository
class PacienteRepository implements IPacienteRepository {

	/** The Constant QUERY_FINDBY_ID_NAME_SURNAME. */
	private static final String QUERY_FINDBY_ID_NAME_SURNAME = "Select new Paciente(id,numeroIdentificacion,nombre,apellidos,fechaNacimiento,fechaUltimaEvaluacion) from Paciente where (concat(NUMERO_IDENTIFICACION,' ',NOMBRE,' ',APELLIDOS) like concat('%',?,'%'))";

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
	public void delete(Paciente paciente) throws SQLException {
		hibernateTemplate.delete(paciente);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Paciente> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Paciente.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IPacienteRepository#findByIdNameSurname
	 * (java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> findByIdNameSurname(String idNameSurname) throws SQLException {
		return hibernateTemplate.find(QUERY_FINDBY_ID_NAME_SURNAME, idNameSurname);
	}

}
