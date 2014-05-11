package com.upsam.hospital.model.repository;

import java.sql.SQLException;
import java.util.List;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;

public interface IAntecedentesQuirurgicosOrtopedicosRepository extends IRepositoryDAO<AntecedentesQuirurgicosOrtopedicos> {

	List<AntecedentesQuirurgicosOrtopedicos> findByAntecedentePersonal(Integer pId) throws SQLException;
}