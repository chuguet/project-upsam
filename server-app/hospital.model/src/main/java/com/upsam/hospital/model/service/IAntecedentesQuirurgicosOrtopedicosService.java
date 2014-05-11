package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.exceptions.DataBaseException;

public interface IAntecedentesQuirurgicosOrtopedicosService extends IModelService<AntecedentesQuirurgicosOrtopedicos> {

	List<AntecedentesQuirurgicosOrtopedicos> findByAntecedentePersonal(Integer pId) throws DataBaseException;

	void deleteByAntecedentePersonal(Integer pId) throws DataBaseException;
}