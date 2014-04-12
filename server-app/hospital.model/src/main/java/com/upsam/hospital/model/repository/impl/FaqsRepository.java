package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.repository.IFaqsRepository;

class FaqsRepository implements IFaqsRepository {

	private static final String QUERY_FINDBY_SECCION = "Select new Faq(id, seccion, fotos, titulo, descripcion) from Faqs where (seccion = ?)";
	@Inject
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Integer save(Faq t) throws SQLException {
		return (Integer) hibernateTemplate.save(t);
	}

	@Override
	public void update(Faq t) throws SQLException {
		hibernateTemplate.update(t);
	}

	@Override
	public void delete(Faq t) throws SQLException {
		hibernateTemplate.delete(t);
	}

	@Override
	public Faq findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Faq.class, pId);
	}

	@Override
	public List<Faq> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Faq.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Faq> findBySeccion(String seccion) throws SQLException {
		return hibernateTemplate.find(QUERY_FINDBY_SECCION, seccion);
	}
}
