package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.repository.IFicheroMDXRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroMDXRepository.
 */
@Repository
public class FicheroMDXRepository implements IFicheroMDXRepository {

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
	public void delete(FicheroMDX ficheroMDX) throws SQLException {
		hibernateTemplate.delete(ficheroMDX);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<FicheroMDX> findAll() throws SQLException {
		return hibernateTemplate.loadAll(FicheroMDX.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public FicheroMDX findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(FicheroMDX.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(FicheroMDX ficheroMDX) throws SQLException {
		return (Integer) hibernateTemplate.save(ficheroMDX);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(FicheroMDX ficheroMDX) throws SQLException {
		hibernateTemplate.update(ficheroMDX);
	}

}
