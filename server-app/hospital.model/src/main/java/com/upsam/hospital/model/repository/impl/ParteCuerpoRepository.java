package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.ParteCuerpo;
import com.upsam.hospital.model.repository.IParteCuerpoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ParteCuerpoRepository.
 */
@Repository
public class ParteCuerpoRepository implements IParteCuerpoRepository {

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
	public void delete(ParteCuerpo parteCuerpo) throws SQLException {
		hibernateTemplate.delete(parteCuerpo);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<ParteCuerpo> findAll() throws SQLException {
		return hibernateTemplate.loadAll(ParteCuerpo.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public ParteCuerpo findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(ParteCuerpo.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(ParteCuerpo parteCuerpo) throws SQLException {
		return (Integer) hibernateTemplate.save(parteCuerpo);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(ParteCuerpo parteCuerpo) throws SQLException {
		hibernateTemplate.update(parteCuerpo);
	}

}
