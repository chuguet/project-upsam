package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.enums.TipoRegla;
import com.upsam.hospital.model.repository.IReglaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglaRepository.
 */
@Repository
public class ReglaRepository extends AbstractRepositoryDAO<Regla> implements IReglaRepository {

	/** The Constant QUERY_FIND_REGLAS_INFO. */
	private static final String QUERY_FIND_REGLAS_INFO = "from Regla where (TIPO_REGLA = ?)";

	/** The Constant QUERY_FIND_REGLAS_WARNING. */
	private static final String QUERY_FIND_REGLAS_WARNING = "from Regla where (TIPO_REGLA = ?)";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IReglaRepository#retrieveReglasInfo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Regla> retrieveReglasInfo() throws SQLException {
		return getHibernateTemplate().find(QUERY_FIND_REGLAS_INFO, TipoRegla.INFO.ordinal());
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
		return getHibernateTemplate().find(QUERY_FIND_REGLAS_WARNING, TipoRegla.WARNING.ordinal());
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<Regla> getClazz() {
		return Regla.class;
	}

}
