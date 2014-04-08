package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.upsam.hospital.model.beans.Faqs;
import com.upsam.hospital.model.repository.IFaqsRepository;

public class FaqsRepository implements IFaqsRepository {

	@Inject
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Integer save(Faqs t) throws SQLException {
		return (Integer) hibernateTemplate.save(t);
	}

	@Override
	public void update(Faqs t) throws SQLException {
		hibernateTemplate.update(t);
	}

	@Override
	public void delete(Faqs t) throws SQLException {
		hibernateTemplate.delete(t);
	}

	@Override
	public Faqs findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Faqs.class, pId);
	}

	@Override
	public List<Faqs> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Faqs.class);
	}
}
