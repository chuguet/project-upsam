package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.repository.IAntecedentesQuirurgicosOrtopedicosRepository;

@Repository
class AntecedentesQuirurgicosOrtopedicosRepository implements IAntecedentesQuirurgicosOrtopedicosRepository {

	private static final String QUERY_FIND_BY_ANTECEDENTE_PERSONAL = "Select new AntecedentesQuirurgicosOrtopedicos(id, fecha, descripcion, esQuirurgico) from AntecedentesQuirurgicosOrtopedicos where (ID_ANTECEDENTES_PERSONALES = ?)";

	@Inject
	private HibernateTemplate hibernateTemplate;

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

	@Override
	public AntecedentesQuirurgicosOrtopedicos findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(AntecedentesQuirurgicosOrtopedicos.class, pId);
	}

	@Override
	public Integer save(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SQLException {
		return (Integer) hibernateTemplate.save(antecedentesQuirurgicosOrtopedicos);
	}

	@Override
	public void update(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SQLException {
		hibernateTemplate.update(antecedentesQuirurgicosOrtopedicos);
	}
}