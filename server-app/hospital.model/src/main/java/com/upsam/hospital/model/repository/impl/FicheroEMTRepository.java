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
public class FicheroEMTRepository implements IFicheroEMTRepository {

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
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public FicheroEMT findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(FicheroEMT.class, pId);
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
