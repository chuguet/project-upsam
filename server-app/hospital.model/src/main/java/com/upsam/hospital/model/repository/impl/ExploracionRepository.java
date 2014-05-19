package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.repository.IExploracionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteRepository.
 */
@Repository
class ExploracionRepository extends AbstractRepositoryDAO<Exploracion> implements IExploracionRepository {

	/** The Constant QUERY_FIND_ONE_UNIQUE. */
	private static final String QUERY_FIND_ONE_UNIQUE = "Select new Exploracion(analisisObservacionalMarcha,controlMotorSelectivo,evaluacionMuscular,fecha,fechaActualizacion, id,longitudMiembroDerecho,longitudMiembroIzquierdo,puntuacion500Metros,puntuacion50Metros,puntuacion5Metros,usuario.id, caderaFlexionIzquierda,caderaFlexionDerecha,caderaInflexionIzquierda,caderaInflexionDerecha,rodillaFlexionIzquierda,rodillaFlexionDerecha,rodillaInflexionIzquierda,rodillaInflexionDerecha,tobilloFlexionIzquierda,tobilloFlexionDerecha,tobilloInflexionIzquierda,tobilloInflexionDerecha) from Exploracion where ID_EXPLORACION = ?";

	/** The Constant QUERY_FINDBY_ID_PATIENT. */
	private static final String QUERY_FINDBY_ID_PATIENT = "Select new Exploracion(id,fecha,usuario.apellidos,usuario.id,usuario.nombre) from Exploracion where ID_PACIENTE = ?";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IExploracionRepository#findOneUnique
	 * (java.lang.Integer)
	 */
	@Override
	public Exploracion findOneUnique(Integer pId) throws SQLException {
		return (Exploracion) getHibernateTemplate().find(QUERY_FIND_ONE_UNIQUE, pId).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IExploracionRepository#
	 * findReducedListByPatient(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exploracion> findReducedListByPatient(Integer idPatient) throws SQLException {
		return getHibernateTemplate().find(QUERY_FINDBY_ID_PATIENT, idPatient);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<Exploracion> getClazz() {
		return Exploracion.class;
	}

}
