package com.upsam.hospital.model.repository.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Pagina;
import com.upsam.hospital.model.repository.IPaginaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginaRepository.
 */
@Repository
public class PaginaRepository extends AbstractRepositoryDAO<Pagina> implements IPaginaRepository {

	/** The Constant QUERY_FIND_PAGINAS_INFO. */
	private static final String QUERY_FIND_PAGINAS_INFO = "from Pagina where (infoPage = true)";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<Pagina> getClazz() {
		return Pagina.class;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IPaginaRepository#retrievePaginasInfo
	 * ()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pagina> retrievePaginasInfo() {
		return getHibernateTemplate().find(QUERY_FIND_PAGINAS_INFO);
	}

}
