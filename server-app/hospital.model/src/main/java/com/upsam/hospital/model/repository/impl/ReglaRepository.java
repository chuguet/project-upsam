package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.enums.TipoRegla;
import com.upsam.hospital.model.repository.IReglaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaRepository.
 */
@Repository
public class ReglaRepository implements IReglaRepository {

	/** The Constant QUERY_FIND_REGLAS_INFO. */
	private static final String QUERY_FIND_REGLAS_INFO = "from Regla where (TIPO_REGLA = ?)";

	/** The Constant QUERY_FIND_REGLAS_WARNING. */
	private static final String QUERY_FIND_REGLAS_WARNING = "from Regla where (TIPO_REGLA = ?)";

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
	public void delete(Regla regla) throws SQLException {
		hibernateTemplate.delete(regla);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Regla> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Regla.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Regla findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Regla.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IReglaRepository#retrieveReglasInfo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Regla> retrieveReglasInfo() throws SQLException {
		return hibernateTemplate.find(QUERY_FIND_REGLAS_INFO, TipoRegla.INFO.ordinal());
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IReglaRepository#retrieveReglasWarning
	 * ()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Regla> retrieveReglasWarning() throws SQLException {
		return hibernateTemplate.find(QUERY_FIND_REGLAS_WARNING, TipoRegla.WARNING.ordinal());
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Regla regla) throws SQLException {
		return (Integer) hibernateTemplate.save(regla);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Regla regla) throws SQLException {
		hibernateTemplate.merge(regla);
	}

}
