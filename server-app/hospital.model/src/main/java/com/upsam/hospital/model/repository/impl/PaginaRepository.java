package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Pagina;
import com.upsam.hospital.model.repository.IPaginaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginaRepository.
 */
@Repository
public class PaginaRepository implements IPaginaRepository {

	/** The Constant QUERY_FIND_PAGINAS_INFO. */
	private static final String QUERY_FIND_PAGINAS_INFO = "from Pagina where (infoPage = true)";

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
	public void delete(Pagina pagina) throws SQLException {
		hibernateTemplate.delete(pagina);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Pagina> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Pagina.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Pagina findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Pagina.class, pId);
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
		return hibernateTemplate.find(QUERY_FIND_PAGINAS_INFO);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Pagina pagina) throws SQLException {
		return (Integer) hibernateTemplate.save(pagina);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Pagina pagina) throws SQLException {
		hibernateTemplate.update(pagina);
	}

}
