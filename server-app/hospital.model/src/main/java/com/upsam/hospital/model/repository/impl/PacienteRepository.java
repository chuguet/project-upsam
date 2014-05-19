package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.repository.IPacienteRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteRepository.
 */
@Repository
class PacienteRepository extends AbstractRepositoryDAO<Paciente> implements IPacienteRepository {

	/** The Constant QUERY_FIND_ONE_UNIQUE. */
	private static final String QUERY_FIND_ONE_UNIQUE = "Select new Paciente(apellidos,curso,escolarizacion,examinador,fechaNacimiento,fechaUltimaEvaluacion,id,nombre,numeroIdentificacion,sexo,telefono) from Paciente where (ID_PACIENTE = ?)";

	/** The Constant QUERY_FINDBY_ID_NAME_SURNAME. */
	private static final String QUERY_FINDBY_ID_NAME_SURNAME = "Select new Paciente(id,numeroIdentificacion,nombre,apellidos,fechaNacimiento,fechaUltimaEvaluacion) from Paciente where (concat(NUMERO_IDENTIFICACION,' ',NOMBRE,' ',APELLIDOS) like concat('%',?,'%'))";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IPacienteRepository#findByIdNameSurname
	 * (java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Paciente> findByIdNameSurname(String idNameSurname) throws SQLException {
		return getHibernateTemplate().find(QUERY_FINDBY_ID_NAME_SURNAME, idNameSurname);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IPacienteRepository#findOneUnique
	 * (java.lang.Integer)
	 */
	@Override
	public Paciente findOneUnique(Integer pId) throws SQLException {
		return (Paciente) getHibernateTemplate().find(QUERY_FIND_ONE_UNIQUE, pId).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<Paciente> getClazz() {
		return Paciente.class;
	}

}
