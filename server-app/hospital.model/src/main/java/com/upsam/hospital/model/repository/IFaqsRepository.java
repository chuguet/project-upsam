package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;

import com.upsam.hospital.model.beans.Faq;

public interface IFaqsRepository extends IRepositoryDAO<Faq> {
	
	List<Faq> findBySeccion(String seccion) throws SQLException;
}
