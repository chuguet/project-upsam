package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.Exploracion;

public interface IExploracionRepository extends IRepositoryDAO<Exploracion> {

	List<Exploracion> findReducedListByPatient(Integer pId) throws SQLException;

}
