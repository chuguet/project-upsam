package com.upsam.hospital.model.service;

import java.io.File;
import java.io.IOException;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Paciente;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFicheroEMTService.
 */
public interface IFicheroEMTService extends IModelService<FicheroEMT> {

	/**
	 * File reader emt.
	 * 
	 * @param file
	 *            the file
	 * @param paciente
	 *            the paciente
	 * @return the fichero emt
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	FicheroEMT fileReaderEMT(File file, Paciente paciente) throws IOException;

}
