package com.upsam.hospital.model.service.impl;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.beans.CampoInfo;
import com.upsam.hospital.model.beans.CampoRellenado;
import com.upsam.hospital.model.beans.CampoSugerido;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;
import com.upsam.hospital.model.enums.Operacion;
import com.upsam.hospital.model.enums.TipoRegla;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IReglaRepository;
import com.upsam.hospital.model.service.IAntecedentesPersonalesService;
import com.upsam.hospital.model.service.IAntecedentesQuirurgicosOrtopedicosService;
import com.upsam.hospital.model.service.IAntecedentesRelacionadosPCIService;
import com.upsam.hospital.model.service.IGrossMotorFunctionService;
import com.upsam.hospital.model.service.IReglaService;
import com.upsam.hospital.model.service.IValoracionArticularMuscularService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReglasService.
 */
@Service
public class ReglaService implements IReglaService {

	/** The antecedentes personales service. */
	@Inject
	private IAntecedentesPersonalesService antecedentesPersonalesService;

	/** The antecedentes quirurgicos ortopedicos service. */
	@Inject
	private IAntecedentesQuirurgicosOrtopedicosService antecedentesQuirurgicosOrtopedicosService;

	/** The antecedentes relacionados pci service. */
	@Inject
	private IAntecedentesRelacionadosPCIService antecedentesRelacionadosPCIService;

	/** The gross motor function service. */
	@Inject
	private IGrossMotorFunctionService grossMotorFunctionService;

	/** The Reglas repository. */
	@Inject
	private IReglaRepository reglaRepository;

	/** The valoracion articular muscular service. */
	@Inject
	private IValoracionArticularMuscularService valoracionArticularMuscularService;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	/**
	 * Delete.
	 * 
	 * @param regla
	 *            the regla
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public void delete(Regla regla) throws DataBaseException {
		try {
			reglaRepository.delete(regla);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IReglaService#doFaq(com.upsam.hospital
	 * .model.beans.Exploracion)
	 */
	/**
	 * Do faq.
	 * 
	 * @param exploracion
	 *            the exploracion
	 * @return the faq
	 * @throws DataBaseException
	 *             the data base exception
	 * @throws SecurityException
	 *             the security exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 */
	@Override
	public Faq doFaq(Exploracion exploracion) throws DataBaseException, SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
		try {
			Faq faq = new Faq();
			String resultWarnings = null;
			String resultInfos = null;
			StringBuffer sbWarnings = new StringBuffer();
			StringBuffer sbInfos = new StringBuffer();
			List<Regla> reglas = reglaRepository.findAll();

			Paciente paciente = exploracion.getPaciente();
			AntecedentesPersonales antecedentesPersonales = antecedentesPersonalesService.findByExploracion(exploracion.getId());
			AntecedentesRelacionadosPCI antecedentesRelacionadosPCI = antecedentesRelacionadosPCIService.findByExploracion(exploracion.getId());
			GrossMotorFunction grossMotorFunction = grossMotorFunctionService.findByExploracion(exploracion.getId());
			ValoracionArticularMuscular valoracionArticularMuscular = valoracionArticularMuscularService.findByExploracion(exploracion.getId());
			AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos = null;
			if (antecedentesPersonales != null) {
				List<AntecedentesQuirurgicosOrtopedicos> listaAntecedentesQuirurgicosOrtopedicos = antecedentesQuirurgicosOrtopedicosService.findByAntecedentePersonal(antecedentesPersonales.getId());
				if (listaAntecedentesQuirurgicosOrtopedicos != null && listaAntecedentesQuirurgicosOrtopedicos.size() > 0) {
					antecedentesQuirurgicosOrtopedicos = listaAntecedentesQuirurgicosOrtopedicos.get(0);
				}
			}

			int countInfos = 0;
			int countWarnings = 0;
			List<CampoInfo> camposInfos;
			for (Regla regla : reglas) {
				if (regla.getTipoRegla().equals(TipoRegla.WARNING) && matchReglaWarning(regla, paciente, exploracion, antecedentesPersonales, antecedentesRelacionadosPCI, grossMotorFunction, valoracionArticularMuscular, antecedentesQuirurgicosOrtopedicos)) {
					countWarnings++;
					sbWarnings.append("<li>").append(regla.getMensaje()).append("<br/>").append("Campos sugeridos a rellenar: ");
					sbWarnings.append("<ol>");
					for (CampoSugerido campoSugerido : regla.getCamposSugeridos()) {
						sbWarnings.append("<li>").append(campoSugerido.getCampo().getNombre()).append(" (").append(campoSugerido.getCampo().getPagina().getNombre()).append(")</li>");
					}
					sbWarnings.append("</ol></li>");
				}
				else if (regla.getTipoRegla().equals(TipoRegla.INFO)) {
					camposInfos = matchReglaInfo(regla, paciente, exploracion, antecedentesPersonales, antecedentesRelacionadosPCI, grossMotorFunction, valoracionArticularMuscular, antecedentesQuirurgicosOrtopedicos);
					if (!camposInfos.isEmpty()) {
						countInfos = camposInfos.size();
						sbInfos.append("<li>").append(regla.getMensaje()).append("<br/>").append("Se ofrecen las siguientes sugerencias: ");
						sbInfos.append("<ol>");
						for (CampoInfo campoInfo : camposInfos) {
							sbInfos.append("<li>").append(campoInfo.getCampo().getNombre()).append(" (").append(campoInfo.getCampo().getPagina().getNombre()).append(") ").append("[").append(campoInfo.getCampo().getMinValue()).append(", ").append(campoInfo.getCampo().getMaxValue()).append("]").append(" debe ser ").append(campoInfo.getOperacion().getNameId()).append(" que ").append(campoInfo.getValor()).append("</li>");
						}
						sbInfos.append("</ol></li>");
					}
				}
			}

			switch (countInfos) {
			case 0:
				resultInfos = "No se han encontrado sugerencias";
				break;
			case 1:
				resultInfos = "Se ha encontrado la siguiente sugerencia: <ul>" + sbInfos.toString() + "</ul>";
				break;
			default:
				resultInfos = "Se han encontrado las siguientes sugerencias: <ul>" + sbInfos.toString() + "</ul>";
				break;
			}

			switch (countWarnings) {
			case 0:
				resultWarnings = "No se han encontrado alertas";
				break;
			case 1:
				resultWarnings = "Se ha encontrado la siguiente alerta: <ul>" + sbWarnings.toString() + "</ul>";
				break;
			default:
				resultWarnings = "Se han encontrado las siguientes alertas: <ul>" + sbWarnings.toString() + "</ul>";
				break;
			}

			faq.setWarningMessages(resultWarnings);
			faq.setInfoMessages(resultInfos);
			return faq;
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IModelService#findAll()
	 */
	/**
	 * Find all.
	 * 
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public List<Regla> findAll() throws DataBaseException {
		try {
			return reglaRepository.findAll();
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
	/**
	 * Find one.
	 * 
	 * @param pId
	 *            the id
	 * @return the regla
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public Regla findOne(Integer pId) throws DataBaseException {
		try {
			return reglaRepository.findOne(pId);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/**
	 * Gets the field.
	 * 
	 * @param object
	 *            the object
	 * @param field
	 *            the field
	 * @return the field
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 */
	private Double getField(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		Double result = null;
		try {
			Object obj;
			if (object != null) {
				field.setAccessible(true);
				obj = field.get(object);
				if (obj != null && (obj instanceof Double || obj instanceof Integer)) {
					result = (Double) obj;
				}
				else if (obj != null && (obj instanceof String)) {
					result = Double.valueOf((String) obj);
				}
			}
		}
		catch (NumberFormatException e) {
			return null;
		}
		return result;
	}

	/**
	 * Match regla info.
	 * 
	 * @param regla
	 *            the regla
	 * @param paciente
	 *            the paciente
	 * @param exploracion
	 *            the exploracion
	 * @param antecedentesPersonales
	 *            the antecedentes personales
	 * @param antecedentesRelacionadosPCI
	 *            the antecedentes relacionados pci
	 * @param grossMotorFunction
	 *            the gross motor function
	 * @param valoracionArticularMuscular
	 *            the valoracion articular muscular
	 * @param antecedentesQuirurgicosOrtopedicos
	 *            the antecedentes quirurgicos ortopedicos
	 * @return true, if successful
	 * @throws SecurityException
	 *             the security exception
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws DataBaseException
	 *             the data base exception
	 */
	private List<CampoInfo> matchReglaInfo(Regla regla, Paciente paciente, Exploracion exploracion, AntecedentesPersonales antecedentesPersonales, AntecedentesRelacionadosPCI antecedentesRelacionadosPCI, GrossMotorFunction grossMotorFunction, ValoracionArticularMuscular valoracionArticularMuscular, AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, DataBaseException {
		List<CampoInfo> result = new ArrayList<CampoInfo>();
		Double value = null;
		String clase;
		String atributo;

		for (CampoInfo campoInfo : regla.getCamposInfos()) {
			atributo = campoInfo.getCampo().getReflexionAtributo();
			clase = campoInfo.getCampo().getReflexionClase();
			if (clase.equals(Paciente.class.getName())) {
				value = this.getField(paciente, Paciente.class.getDeclaredField(atributo));
			}
			else if (clase.equals(Exploracion.class.getName())) {
				value = this.getField(exploracion, Exploracion.class.getDeclaredField(atributo));
			}
			else if (clase.equals(AntecedentesPersonales.class.getName())) {
				value = this.getField(antecedentesPersonales, AntecedentesPersonales.class.getDeclaredField(atributo));
			}
			else if (clase.equals(AntecedentesRelacionadosPCI.class.getName())) {
				value = this.getField(antecedentesRelacionadosPCI, AntecedentesRelacionadosPCI.class.getDeclaredField(atributo));
			}
			else if (clase.equals(AntecedentesQuirurgicosOrtopedicos.class.getName())) {
				value = this.getField(antecedentesQuirurgicosOrtopedicos, AntecedentesQuirurgicosOrtopedicos.class.getDeclaredField(atributo));
			}
			else if (clase.equals(GrossMotorFunction.class.getName())) {
				value = this.getField(grossMotorFunction, GrossMotorFunction.class.getDeclaredField(atributo));
			}
			else if (clase.equals(ValoracionArticularMuscular.class.getName())) {
				value = this.getField(valoracionArticularMuscular, ValoracionArticularMuscular.class.getDeclaredField(atributo));
			}
			if (validateValue(value, campoInfo.getOperacion(), campoInfo.getValor())) {
				result.add(campoInfo);
			}
		}
		return result;
	}

	/**
	 * Match regla.
	 * 
	 * @param regla
	 *            the regla
	 * @param paciente
	 *            the paciente
	 * @param exploracion
	 *            the exploracion
	 * @param antecedentesPersonales
	 *            the antecedentes personales
	 * @param antecedentesRelacionadosPCI
	 *            the antecedentes relacionados pci
	 * @param grossMotorFunction
	 *            the gross motor function
	 * @param valoracionArticularMuscular
	 *            the valoracion articular muscular
	 * @param antecedentesQuirurgicosOrtopedicos
	 *            the antecedentes quirurgicos ortopedicos
	 * @return the boolean
	 * @throws SecurityException
	 *             the security exception
	 * @throws NoSuchFieldException
	 *             the no such field exception
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 * @throws DataBaseException
	 *             the data base exception
	 */
	private Boolean matchReglaWarning(Regla regla, Paciente paciente, Exploracion exploracion, AntecedentesPersonales antecedentesPersonales, AntecedentesRelacionadosPCI antecedentesRelacionadosPCI, GrossMotorFunction grossMotorFunction, ValoracionArticularMuscular valoracionArticularMuscular, AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, DataBaseException {
		Boolean result = Boolean.TRUE;
		String clase;
		String atributo;

		for (CampoRellenado campoRellenado : regla.getCamposRellenados()) {
			atributo = campoRellenado.getCampo().getReflexionAtributo();
			clase = campoRellenado.getCampo().getReflexionClase();
			if (clase.equals(Paciente.class.getName())) {
				result = this.validateField(paciente, Paciente.class.getDeclaredField(atributo));
			}
			else if (clase.equals(Exploracion.class.getName())) {
				result = this.validateField(exploracion, Exploracion.class.getDeclaredField(atributo));
			}
			else if (clase.equals(AntecedentesPersonales.class.getName())) {
				result = this.validateField(antecedentesPersonales, AntecedentesPersonales.class.getDeclaredField(atributo));
			}
			else if (clase.equals(AntecedentesRelacionadosPCI.class.getName())) {
				result = this.validateField(antecedentesRelacionadosPCI, AntecedentesRelacionadosPCI.class.getDeclaredField(atributo));
			}
			else if (clase.equals(AntecedentesQuirurgicosOrtopedicos.class.getName())) {
				result = this.validateField(antecedentesQuirurgicosOrtopedicos, AntecedentesQuirurgicosOrtopedicos.class.getDeclaredField(atributo));
			}
			else if (clase.equals(GrossMotorFunction.class.getName())) {
				result = this.validateField(grossMotorFunction, GrossMotorFunction.class.getDeclaredField(atributo));
			}
			else if (clase.equals(ValoracionArticularMuscular.class.getName())) {
				result = this.validateField(valoracionArticularMuscular, ValoracionArticularMuscular.class.getDeclaredField(atributo));
			}
			if (!result)
				break;
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IReglaService#merge(com.upsam.hospital
	 * .model.beans.Regla)
	 */
	/**
	 * Merge.
	 * 
	 * @param regla
	 *            the regla
	 * @return the regla
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public Regla merge(Regla regla) throws DataBaseException {
		try {
			return reglaRepository.merge(regla);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IReglaService#retrieveReglasInfo()
	 */
	/**
	 * Retrieve reglas info.
	 * 
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public List<Regla> retrieveReglasInfo() throws DataBaseException {
		try {
			return reglaRepository.retrieveReglasInfo();
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IReglaService#retrieveReglasWarning()
	 */
	/**
	 * Retrieve reglas warning.
	 * 
	 * @return the list
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public List<Regla> retrieveReglasWarning() throws DataBaseException {
		try {
			return reglaRepository.retrieveReglasWarning();
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
	/**
	 * Save.
	 * 
	 * @param regla
	 *            the regla
	 * @return the integer
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public Integer save(Regla regla) throws DataBaseException {
		try {
			return reglaRepository.save(regla);
		}
		catch (SQLException ex) {
			throw new DataBaseException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	/**
	 * Update.
	 * 
	 * @param regla
	 *            the regla
	 * @throws DataBaseException
	 *             the data base exception
	 */
	@Override
	public void update(Regla regla) throws DataBaseException {
		try {
			reglaRepository.update(regla);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/**
	 * Validate field.
	 * 
	 * @param object
	 *            the object
	 * @param field
	 *            the field
	 * @return the boolean
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 * @throws IllegalAccessException
	 *             the illegal access exception
	 */
	private Boolean validateField(Object object, Field field) throws IllegalArgumentException, IllegalAccessException {
		if (object != null) {
			field.setAccessible(true);
			Object valueObject = field.get(object);
			if (valueObject == null) {
				return Boolean.FALSE;
			}
		}
		else {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	/**
	 * Validate value.
	 * 
	 * @param value
	 *            the value
	 * @param operacion
	 *            the operacion
	 * @param umbral
	 *            the umbral
	 * @return the boolean
	 */
	private Boolean validateValue(Double value, Operacion operacion, Double umbral) {
		Boolean result = Boolean.FALSE;
		if (value != null) {
			if (operacion.equals(Operacion.IGUAL)) {
				result = value != umbral;
			}
			else if (operacion.equals(Operacion.MAYOR)) {
				result = value <= umbral;
			}
			else if (operacion.equals(Operacion.MAYOR_IGUAL)) {
				result = value < umbral;
			}
			else if (operacion.equals(Operacion.MENOR)) {
				result = value >= umbral;
			}
			else if (operacion.equals(Operacion.MENOR_IGUAL)) {
				result = value > umbral;
			}
		}
		return result;
	}
}
