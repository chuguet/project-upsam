package com.upsam.hospital.model.service;

import java.util.List;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPacienteService.
 */
public interface IExploracionService extends IModelService<Exploracion> {

	List<Exploracion> findReducedListByPatient(Integer pId) throws DataBaseException;

}