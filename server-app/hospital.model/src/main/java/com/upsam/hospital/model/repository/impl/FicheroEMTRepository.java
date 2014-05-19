package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.repository.IFicheroEMTRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroEMTRepository.
 */
@Repository
class FicheroEMTRepository extends AbstractRepositoryDAO<FicheroEMT> implements IFicheroEMTRepository {

	/** The Constant QUERY_BY_EXPLORACION. */
	private static final String QUERY_BY_EXPLORACION = "Select new FicheroEMT(fecha,id) from FicheroEMT where (ID_EXPLORACION = ?)";

	/** The Constant QUERY_FIND_ONE_UNIQUE. */
	private static final String QUERY_FIND_ONE_UNIQUE = "Select new FicheroEMT(ficheroEMT.ciclos,ficheroEMT.fecha,ficheroEMT.id,ficheroEMT.tablaDatos,ficheroEMT.tipoMedida,ficheroEMT.unidadMedida) from FicheroEMT as ficheroEMT where (ficheroEMT.id = ?)";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IFicheroEMTRepository#findByExploracion
	 * (java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FicheroEMT> findByExploracion(Integer pId) throws SQLException {
		return getHibernateTemplate().find(QUERY_BY_EXPLORACION, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IFicheroEMTRepository#findOneUnique
	 * (java.lang.Integer)
	 */
	@Override
	public FicheroEMT findOneUnique(Integer pId) throws SQLException {
		return (FicheroEMT) getHibernateTemplate().find(QUERY_FIND_ONE_UNIQUE, pId).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<FicheroEMT> getClazz() {
		return FicheroEMT.class;
	}

}
