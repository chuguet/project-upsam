package com.upsam.hospital.model.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Exploracion3D;
import com.upsam.hospital.model.beans.Field;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Row;
import com.upsam.hospital.model.beans.TablaDatos;
import com.upsam.hospital.model.beans.TipoMedida;
import com.upsam.hospital.model.beans.UnidadMedida;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IPacienteRepository;
import com.upsam.hospital.model.service.IPacienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteService.
 */
@Service
public class PacienteService implements IPacienteService {

	/** The paciente repository. */
	@Inject
	private IPacienteRepository pacienteRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(Paciente paciente) throws DataBaseException {
		try {
			pacienteRepository.delete(paciente);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	@Override
	public List<Paciente> findAll() throws DataBaseException {
		try {
			return pacienteRepository.findAll();
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
	public Paciente findOne(Integer pId) throws DataBaseException {
		try {
			return pacienteRepository.findOne(pId);
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
	public Integer save(Paciente paciente) throws DataBaseException {
		try {
			return pacienteRepository.save(paciente);
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
	public void update(Paciente paciente) throws DataBaseException {
		try {
			pacienteRepository.update(paciente);
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
	@Override
	public Exploracion3D fileReader(File file, Paciente paciente) throws IOException {
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
}
