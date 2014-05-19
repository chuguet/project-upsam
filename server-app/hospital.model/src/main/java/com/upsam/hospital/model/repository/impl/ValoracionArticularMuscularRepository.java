package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;
import com.upsam.hospital.model.repository.IValoracionArticularMuscularRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ValoracionArticularMuscularRepository.
 */
@Repository
class ValoracionArticularMuscularRepository extends AbstractRepositoryDAO<ValoracionArticularMuscular> implements IValoracionArticularMuscularRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new ValoracionArticularMuscular(id,var_1_1,var_1_2,var_1_3,var_1_4,var_1_5,var_1_6,var_2_1,var_2_2,var_2_3,var_2_4,var_2_5,var_2_6,var_3_1,var_3_2,var_3_3,var_3_4,var_3_5,var_3_6,var_4_1,var_4_2,var_4_3,var_4_4,var_4_5,var_4_6,var_5_1,var_5_2,var_5_3,var_5_4,var_5_5,var_5_6,var_6_1,var_6_2,var_6_3,var_6_4,var_6_5,var_6_6,var_7_1,var_7_2,var_7_3,var_7_4,var_7_5,var_7_6,var_8_1,var_8_2,var_8_3,var_8_4,var_8_5,var_8_6,var_9_1,var_9_2,var_9_3,var_9_4,var_9_5,var_9_6,var_10_1,var_10_2,var_10_3,var_10_4,var_10_5,var_10_6,var_11_1,var_11_2,var_11_3,var_11_4,var_11_5,var_11_6,var_12_1,var_12_2,var_12_3,var_12_4,var_12_5,var_12_6,var_13_1,var_13_2,var_13_3,var_13_4,var_13_5,var_13_6) from ValoracionArticularMuscular where (ID_EXPLORACION = ?)";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IValoracionArticularMuscularRepository
	 * #findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public ValoracionArticularMuscular findByExploracion(Integer pId) throws SQLException {
		List results = getHibernateTemplate().find(QUERY_FIND_BY_EXPLORACION, pId);
		if (results.size() > 0) {
			return (ValoracionArticularMuscular) results.get(0);
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
	protected Class<ValoracionArticularMuscular> getClazz() {
		return ValoracionArticularMuscular.class;
	}

}
