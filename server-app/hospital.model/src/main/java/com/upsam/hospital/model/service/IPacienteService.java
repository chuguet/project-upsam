package com.upsam.hospital.model.service;

import java.io.File;
import java.io.IOException;
import com.upsam.hospital.model.beans.Exploracion3D;
import com.upsam.hospital.model.beans.Paciente;

/**
 * The Interface IPacienteService.
 */
public interface IPacienteService extends IModelService<Paciente> {

	Exploracion3D fileReader(File file, Paciente paciente) throws IOException;
}
