package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.repository.IFaqsRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FaqsRepository.
 */
@Repository
class FaqsRepository implements IFaqsRepository {

	/** The Constant QUERY_FINDBY_SECCION. */
	private static final String QUERY_FINDBY_SECCION = "from Faq where SECCION = ?";

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
	public void delete(Faq faq) throws SQLException {
		hibernateTemplate.delete(faq);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Faq> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Faq.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IFaqsRepository#findBySeccion(java
	 * .lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Faq> findBySeccion(String seccion) throws SQLException {
		return hibernateTemplate.find(QUERY_FINDBY_SECCION, seccion);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Faq findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Faq.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Faq faq) throws SQLException {
		return (Integer) hibernateTemplate.save(faq);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Faq faq) throws SQLException {
		hibernateTemplate.update(faq);
	}
}
