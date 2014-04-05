package com.upsam.hospital.model.service;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.jaxb.EmxDataFile;

// TODO: Auto-generated Javadoc
/**
 * The Interface IFicheroMDXService.
 */
public interface IFicheroMDXService extends IModelService<FicheroMDX> {

	/**
	 * File reader mdx.
	 * 
	 * @param file
	 *            the file
	 * @return the emx data file
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	EmxDataFile fileReaderMDX(File file) throws JAXBException, IOException;

}
