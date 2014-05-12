package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.repository.IAntecedentesQuirurgicosOrtopedicosRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesQuirurgicosOrtopedicosRepository.
 */
@Repository
class AntecedentesQuirurgicosOrtopedicosRepository implements IAntecedentesQuirurgicosOrtopedicosRepository {

	/** The Constant QUERY_FIND_BY_ANTECEDENTE_PERSONAL. */
	private static final String QUERY_FIND_BY_ANTECEDENTE_PERSONAL = "Select new AntecedentesQuirurgicosOrtopedicos(id, fecha, descripcion, esQuirurgico) from AntecedentesQuirurgicosOrtopedicos where (ID_ANTECEDENTES_PERSONALES = ?)";

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
	public void delete(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SQLException {
		hibernateTemplate.delete(antecedentesQuirurgicosOrtopedicos);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<AntecedentesQuirurgicosOrtopedicos> findAll() throws SQLException {
		return hibernateTemplate.loadAll(AntecedentesQuirurgicosOrtopedicos.class);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.
	 * IAntecedentesQuirurgicosOrtopedicosRepository
	 * #findByAntecedentePersonal(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AntecedentesQuirurgicosOrtopedicos> findByAntecedentePersonal(Integer pId) throws SQLException {
		List<AntecedentesQuirurgicosOrtopedicos> results = hibernateTemplate.find(QUERY_FIND_BY_ANTECEDENTE_PERSONAL, pId);
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
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public AntecedentesQuirurgicosOrtopedicos findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(AntecedentesQuirurgicosOrtopedicos.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SQLException {
		return (Integer) hibernateTemplate.save(antecedentesQuirurgicosOrtopedicos);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SQLException {
		hibernateTemplate.update(antecedentesQuirurgicosOrtopedicos);
	}
}