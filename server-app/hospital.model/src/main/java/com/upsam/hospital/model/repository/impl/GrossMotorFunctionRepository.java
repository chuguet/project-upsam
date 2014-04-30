package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.repository.IGrossMotorFunctionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class GrossMotorFunctionRepository.
 */
@Repository
class GrossMotorFunctionRepository implements IGrossMotorFunctionRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new GrossMotorFunction(comentarios,evaluacionIndicativa,id,var1,var10,var11,var12,var13,var14,var15,var16,var17,var18,var19,var2,var20,var21,var22,var23,var24,var25,var26,var27,var28,var29,var3,var30,var31,var32,var33,var34,var35,var36,var37,var4,var5,var6,var7,var8,var9) from GrossMotorFunction where (ID_EXPLORACION = ?)";

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
	public void delete(GrossMotorFunction grossMotorFunction) throws SQLException {
		hibernateTemplate.delete(grossMotorFunction);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<GrossMotorFunction> findAll() throws SQLException {
		return hibernateTemplate.loadAll(GrossMotorFunction.class);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IGrossMotorFunctionRepository#
	 * findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public GrossMotorFunction findByExploracion(Integer pId) throws SQLException {
		List results = hibernateTemplate.find(QUERY_FIND_BY_EXPLORACION, pId);
		if (results.size() > 0) {
			return (GrossMotorFunction) results.get(0);
		}
		else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public GrossMotorFunction findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(GrossMotorFunction.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(GrossMotorFunction grossMotorFunction) throws SQLException {
		return (Integer) hibernateTemplate.save(grossMotorFunction);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(GrossMotorFunction grossMotorFunction) throws SQLException {
		hibernateTemplate.update(grossMotorFunction);
	}

}
