package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.repository.IFicheroEMTRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroEMTRepository.
 */
@Repository
class FicheroEMTRepository implements IFicheroEMTRepository {

	/** The Constant QUERY_BY_EXPLORACION. */
	private static final String QUERY_BY_EXPLORACION = "Select new FicheroEMT(fecha,id) from FicheroEMT where (ID_EXPLORACION = ?)";
	
	/** The Constant QUERY_FIND_ONE_UNIQUE. */
	private static final String QUERY_FIND_ONE_UNIQUE = "Select new FicheroEMT(ficheroEMT.ciclos,ficheroEMT.fecha,ficheroEMT.id,ficheroEMT.tablaDatos,ficheroEMT.tipoMedida,ficheroEMT.unidadMedida) from FicheroEMT as ficheroEMT where (ficheroEMT.id = ?)";

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
	public void delete(FicheroEMT ficheroEMT) throws SQLException {
		hibernateTemplate.delete(ficheroEMT);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<FicheroEMT> findAll() throws SQLException {
		return hibernateTemplate.loadAll(FicheroEMT.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IFicheroEMTRepository#findByExploracion
	 * (java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FicheroEMT> findByExploracion(Integer pId) throws SQLException {
		return hibernateTemplate.find(QUERY_BY_EXPLORACION, pId);
	}
	
	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public FicheroEMT findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(FicheroEMT.class, pId);
	}

	/* (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IFicheroEMTRepository#findOneUnique(java.lang.Integer)
	 */
	@Override
	public FicheroEMT findOneUnique(Integer pId) throws SQLException {
		return (FicheroEMT) hibernateTemplate.find(QUERY_FIND_ONE_UNIQUE, pId).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(FicheroEMT ficheroEMT) throws SQLException {
		return (Integer) hibernateTemplate.save(ficheroEMT);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(FicheroEMT ficheroEMT) throws SQLException {
		hibernateTemplate.update(ficheroEMT);
	}
}
