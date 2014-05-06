package com.upsam.hospital.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Angle;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Point;
import com.upsam.hospital.model.beans.TablaDatos;
import com.upsam.hospital.model.enums.TipoMedida;
import com.upsam.hospital.model.enums.UnidadMedida;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFicheroEMTRepository;
import com.upsam.hospital.model.service.IFicheroEMTService;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroEMTService.
 */
@Service
public class FicheroEMTService implements IFicheroEMTService {

	/** The fichero emt repository. */
	@Inject
	private IFicheroEMTRepository ficheroEMTRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(FicheroEMT ficheroEMT) throws DataBaseException {
		try {
			ficheroEMTRepository.delete(ficheroEMT);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IFicheroEMTService#fileReaderEMT(java
	 * .io.File, com.upsam.hospital.model.beans.Paciente)
	 */
	@Override
	public FicheroEMT fileReaderEMT(File file, Integer idExploracion) throws IOException {
		List<String> lines = FileUtils.readLines(file, Charsets.UTF_8);
		FicheroEMT result = new FicheroEMT();
		result.setExploracion(new Exploracion(idExploracion));
		Point point;
		TablaDatos tablaDatos = new TablaDatos();
		tablaDatos.setFicheroEMT(result);
		Angle angle;
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
			else if (line.contains("Sample")) {
				lineSplitted = readLine(line);
				lineSplitted = lineSplitted.subList(1, lineSplitted.size());
				for (String split : lineSplitted) {
					angle = new Angle();
					angle.setName(split);
					angle.setTablaDatos(tablaDatos);
					tablaDatos.addAngle(angle);
				}
			}
			else if (line.matches(".*\\d.*")) {
				lineSplitted = readLine(line);
				lineSplitted = lineSplitted.subList(1, lineSplitted.size());
				int i = 0;
				for (String split : lineSplitted) {
					point = new Point();
					point.setCoord(split);
					point.setAngle(tablaDatos.getAngles().get(i));
					tablaDatos.getAngles().get(i).addPoint(point);
					i++;
				}
			}
		}
		result.setTablaDatos(tablaDatos);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<FicheroEMT> findAll() throws DataBaseException {
		try {
			return ficheroEMTRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IFicheroEMTService#findByExploracion
	 * (java .lang.Integer)
	 */
	@Override
	public List<FicheroEMT> findByExploracion(Integer pId) throws DataBaseException {
		try {
			return ficheroEMTRepository.findByExploracion(pId);
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
	public FicheroEMT findOne(Integer pId) throws DataBaseException {
		try {
			return ficheroEMTRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IFicheroEMTService#findOneUnique(java
	 * .lang.Integer)
	 */
	@Override
	public FicheroEMT findOneUnique(Integer pId) throws DataBaseException {
		try {
			return ficheroEMTRepository.findOneUnique(pId);
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
	public Integer save(FicheroEMT ficheroEMT) throws DataBaseException {
		try {
			return ficheroEMTRepository.save(ficheroEMT);
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
	public void update(FicheroEMT ficheroEMT) throws DataBaseException {
		try {
			ficheroEMTRepository.update(ficheroEMT);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

}
