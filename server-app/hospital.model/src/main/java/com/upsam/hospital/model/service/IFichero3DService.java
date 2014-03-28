package com.upsam.hospital.model.service;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import com.upsam.hospital.model.beans.Exploracion3D;
import com.upsam.hospital.model.beans.Fichero3D;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.jaxb.EmxDataFile;

/**
 * The Interface IFichero3DService.
 */
public interface IFichero3DService extends IModelService<Fichero3D> {

	/**
	 * File reader exploracion3 d.
	 * 
	 * @param file
	 *            the file
	 * @param paciente
	 *            the paciente
	 * @return the exploracion3 d
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	Exploracion3D fileReaderExploracion3D(File file, Paciente paciente) throws IOException;

	/**
	 * File reader video3 d.
	 * 
	 * @param file
	 *            the file
	 * @return the emx data file
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	EmxDataFile fileReaderVideo3D(File file) throws JAXBException, IOException;

}
