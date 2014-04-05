package com.upsam.hospital.model.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.jaxb.EmxDataFile;
import com.upsam.hospital.model.jaxb.JaxbUtils;
import com.upsam.hospital.model.repository.IFicheroMDXRepository;
import com.upsam.hospital.model.service.IFicheroMDXService;

// TODO: Auto-generated Javadoc
/**
 * The Class Fichero3DService.
 */
@Service
public class FicheroMDXService implements IFicheroMDXService {

	/** The fichero3 d repository. */
	@Inject
	private IFicheroMDXRepository ficheroMDXRepository;

	/** The jaxb util. */
	@Inject
	private JaxbUtils jaxbUtil;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(FicheroMDX fichero3D) throws DataBaseException {
		try {
			ficheroMDXRepository.delete(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IPacienteService#fileReaderVideo3D(java
	 * .io.File)
	 */
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
	@Override
	public EmxDataFile fileReaderMDX(File file) throws JAXBException, IOException {
		String fileXML = jaxbUtil.removeHeaderXmlFile(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
		EmxDataFile emxDataFile = (EmxDataFile) jaxbUtil.readXML(new ByteArrayInputStream(fileXML.getBytes(StandardCharsets.UTF_8)), EmxDataFile.class);
		return emxDataFile;
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<FicheroMDX> findAll() throws DataBaseException {
		try {
			return ficheroMDXRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public FicheroMDX findOne(Integer pId) throws DataBaseException {
		try {
			return ficheroMDXRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(FicheroMDX fichero3D) throws DataBaseException {
		try {
			return ficheroMDXRepository.save(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(FicheroMDX fichero3D) throws DataBaseException {
		try {
			ficheroMDXRepository.update(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

}
