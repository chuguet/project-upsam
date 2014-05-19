package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.repository.IAntecedentesQuirurgicosOrtopedicosRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesQuirurgicosOrtopedicosRepository.
 */
@Repository
class AntecedentesQuirurgicosOrtopedicosRepository extends AbstractRepositoryDAO<AntecedentesQuirurgicosOrtopedicos> implements IAntecedentesQuirurgicosOrtopedicosRepository {

	/** The Constant QUERY_FIND_BY_ANTECEDENTE_PERSONAL. */
	private static final String QUERY_FIND_BY_ANTECEDENTE_PERSONAL = "Select new AntecedentesQuirurgicosOrtopedicos(id, fecha, descripcion, esQuirurgico) from AntecedentesQuirurgicosOrtopedicos where (ID_ANTECEDENTES_PERSONALES = ?)";

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.
	 * IAntecedentesQuirurgicosOrtopedicosRepository
	 * #findByAntecedentePersonal(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AntecedentesQuirurgicosOrtopedicos> findByAntecedentePersonal(Integer pId) throws SQLException {
		List<AntecedentesQuirurgicosOrtopedicos> results = getHibernateTemplate().find(QUERY_FIND_BY_ANTECEDENTE_PERSONAL, pId);
		if (results.size() > 0) {
			return results;
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
	protected Class<AntecedentesQuirurgicosOrtopedicos> getClazz() {
		return AntecedentesQuirurgicosOrtopedicos.class;
	}

}