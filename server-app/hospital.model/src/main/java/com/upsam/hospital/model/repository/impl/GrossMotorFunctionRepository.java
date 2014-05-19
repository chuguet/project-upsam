package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.repository.IGrossMotorFunctionRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class GrossMotorFunctionRepository.
 */
@Repository
class GrossMotorFunctionRepository extends AbstractRepositoryDAO<GrossMotorFunction> implements IGrossMotorFunctionRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new GrossMotorFunction(comentarios,evaluacionIndicativa,id,var1,var10,var11,var12,var13,var14,var15,var16,var17,var18,var19,var2,var20,var21,var22,var23,var24,var25,var26,var27,var28,var29,var3,var30,var31,var32,var33,var34,var35,var36,var37,var4,var5,var6,var7,var8,var9) from GrossMotorFunction where (ID_EXPLORACION = ?)";

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IGrossMotorFunctionRepository#
	 * findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public GrossMotorFunction findByExploracion(Integer pId) throws SQLException {
		List results = getHibernateTemplate().find(QUERY_FIND_BY_EXPLORACION, pId);
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
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<GrossMotorFunction> getClazz() {
		return GrossMotorFunction.class;
	}

}
