package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFaqsRepository;
import com.upsam.hospital.model.service.IFaqsService;

@Service
public class FaqsService implements IFaqsService {

		private IFaqsRepository faqsRepository;

		@Override
		public Integer save(Faq faqs) throws DataBaseException {
			try {
				return faqsRepository.save(faqs);
			}
			catch (SQLException ex) {
				throw new DataBaseException(ex);
			}
		}

		@Override
		public void update(Faq t) throws DataBaseException {
			try {
				faqsRepository.update(t);
			}
			catch (SQLException e1) {
				throw new DataBaseException(e1);
			}
		}

		@Override
		public void delete(Faq t) throws DataBaseException {
			try {
				faqsRepository.delete(t);
			}
			catch (SQLException e1) {
				throw new DataBaseException(e1);
			}
		}

		@Override
		public Faq findOne(Integer pId) throws DataBaseException {
			try {
				return faqsRepository.findOne(pId);
			}
			catch (SQLException e1) {
				throw new DataBaseException(e1);
			}
		}

		@Override
		public List<Faq> findAll() throws DataBaseException {
			try {
				return faqsRepository.findAll();
			}
			catch (SQLException e1) {
				throw new DataBaseException(e1);
			}
		}

		public List<Faq> findBySeccion(String seccion) throws DataBaseException {
			try {
				return faqsRepository.findBySeccion(seccion);
			}
			catch (SQLException e1) {
				throw new DataBaseException(e1);
			}
		}
}
