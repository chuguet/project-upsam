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

	/** The Constant QUERY_FIND_ONE_UNIQUE. */
	private static final String QUERY_FIND_ONE_UNIQUE = "Select new Exploracion(analisisObservacionalMarcha,controlMotorSelectivo,evaluacionMuscular,fecha,fechaActualizacion, id,longitudMiembroDerecho,longitudMiembroIzquierdo,puntuacion500Metros,puntuacion50Metros,puntuacion5Metros,usuario.id, caderaFlexionIzquierda,caderaFlexionDerecha,caderaInflexionIzquierda,caderaInflexionDerecha,rodillaFlexionIzquierda,rodillaFlexionDerecha,rodillaInflexionIzquierda,rodillaInflexionDerecha,tobilloFlexionIzquierda,tobilloFlexionDerecha,tobilloInflexionIzquierda,tobilloInflexionDerecha) from Exploracion where ID_EXPLORACION = ?";

	/** The Constant QUERY_FINDBY_ID_PATIENT. */
	private static final String QUERY_FINDBY_ID_PATIENT = "Select new Exploracion(id,fecha,usuario.apellidos,usuario.id,usuario.nombre) from Exploracion where ID_PACIENTE = ?";

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
	 * com.upsam.hospital.model.repository.IExploracionRepository#findOneUnique
	 * (java.lang.Integer)
	 */
	@Override
	public Exploracion findOneUnique(Integer pId) throws SQLException {
		return (Exploracion) hibernateTemplate.find(QUERY_FIND_ONE_UNIQUE, pId).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IExploracionRepository#
	 * findReducedListByPatient(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exploracion> findReducedListByPatient(Integer idPatient) throws SQLException {
		return hibernateTemplate.find(QUERY_FINDBY_ID_PATIENT, idPatient);
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
}
