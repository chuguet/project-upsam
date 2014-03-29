package com.upsam.hospital.model.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Exploracion3D;
import com.upsam.hospital.model.beans.Fichero3D;
import com.upsam.hospital.model.beans.Field;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Row;
import com.upsam.hospital.model.beans.TablaDatos;
import com.upsam.hospital.model.beans.TipoMedida;
import com.upsam.hospital.model.beans.UnidadMedida;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.jaxb.EmxDataFile;
import com.upsam.hospital.model.jaxb.JaxbUtils;
import com.upsam.hospital.model.repository.IFichero3DRepository;
import com.upsam.hospital.model.service.IFichero3DService;

// TODO: Auto-generated Javadoc
/**
 * The Class Fichero3DService.
 */
@Service
public class Fichero3DService implements IFichero3DService {

	/** The fichero3 d repository. */
	@Inject
	private IFichero3DRepository fichero3DRepository;

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
	public void delete(Fichero3D fichero3D) throws DataBaseException {
		try {
			fichero3DRepository.delete(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IPacienteService#fileReader(java.io.
	 * File, com.upsam.hospital.model.beans.Paciente)
	 */
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
	@Override
	public Exploracion3D fileReaderExploracion3D(File file, Paciente paciente) throws IOException {
		List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
		Exploracion3D result = new Exploracion3D();
		result.setPaciente(paciente);
		Field field;
		TablaDatos tablaDatos = new TablaDatos();
		tablaDatos.setExploracion3D(result);
		List<Row> rows;
		Row row;
		result.setFecha(new Date());
		List<String> lineSplitted;
		for (String line : lines) {
			if (line.contains("Type")) {
				lineSplitted = readLine(line);
				result.setTipoMedida(TipoMedida.getValue(new StringBuffer(lineSplitted.get(1)).append(" ").append(lineSplitted.get(2)).toString()));
			}
			else if (line.contains("Measure unit")) {
				lineSplitted = readLine(line);
				result.setUnidadMedida(UnidadMedida.getValue(lineSplitted.get(2)));
			}
			else if (line.contains("Cycles")) {
				lineSplitted = readLine(line);
				result.setCiclos(Integer.valueOf(lineSplitted.get(1)));
			}
			else if (line.matches(".*\\d.*")) {
				lineSplitted = readLine(line);
				row = new Row();
				rows = new ArrayList<Row>();
				for (String split : lineSplitted) {
					field = new Field();
					field.setText(split);
					field.setRow(row);
					row.addField(field);
					row.setTablaDatos(tablaDatos);
					rows.add(row);
				}
				tablaDatos.addRow(row);
			}
		}
		result.setTablaDatos(tablaDatos);
		return result;
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
	public EmxDataFile fileReaderVideo3D(File file) throws JAXBException, IOException {
		String fileXML = jaxbUtil.removeHeaderXmlFile(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
		EmxDataFile emxDataFile = (EmxDataFile) jaxbUtil.readXML(new ByteArrayInputStream(fileXML.getBytes(StandardCharsets.UTF_8)), EmxDataFile.class);
		return emxDataFile;
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<Fichero3D> findAll() throws DataBaseException {
		try {
			return fichero3DRepository.findAll();
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
	public Fichero3D findOne(Integer pId) throws DataBaseException {
		try {
			return fichero3DRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/**
	 * Read line.
	 * 
	 * @param line
	 *            the line
	 * @return the list
	 */
	private List<String> readLine(String line) {
		List<String> result = new ArrayList<String>();
		String[] stringSplitted = line.split(" ");
		for (int i = 0; i < stringSplitted.length; i++) {
			if (!stringSplitted[i].isEmpty()) {
				result.add(stringSplitted[i].trim());
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Fichero3D fichero3D) throws DataBaseException {
		try {
			return fichero3DRepository.save(fichero3D);
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
	public void update(Fichero3D fichero3D) throws DataBaseException {
		try {
			fichero3DRepository.update(fichero3D);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

}
