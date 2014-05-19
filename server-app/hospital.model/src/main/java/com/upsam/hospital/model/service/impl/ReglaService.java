package com.upsam.hospital.model.service.impl;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.beans.CampoRellenado;
import com.upsam.hospital.model.beans.CampoSugerido;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;
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
	@Override
	public Faq doFaq(Exploracion exploracion) throws DataBaseException, SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
		try {
			Faq faq = new Faq();
			String result = null;
			StringBuffer sb = new StringBuffer();
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

			int count = 0;
			for (Regla regla : reglas) {
				if (regla.getTipoRegla().equals(TipoRegla.WARNING) && matchReglaWarning(regla, paciente, exploracion, antecedentesPersonales, antecedentesRelacionadosPCI, grossMotorFunction, valoracionArticularMuscular, antecedentesQuirurgicosOrtopedicos)) {
					count++;
					sb.append("<li>").append(regla.getMensaje()).append("<br/>").append("Campos sugeridos a rellenar: ");
					sb.append("<ol>");
					for (CampoSugerido campoSugerido : regla.getCamposSugeridos()) {
						sb.append("<li>").append(campoSugerido.getCampo().getNombre()).append(" (").append(campoSugerido.getCampo().getPagina().getNombre()).append(")</li>");
					}
					sb.append("</ol></li>");
				}
				else if (regla.getTipoRegla().equals(TipoRegla.INFO)) {
					// TODO
				}
			}

			if (count == 1) {
				result = "Se ha encontrado la siguiente sugerencia: <ul>" + sb.toString() + "</ul>";
			}
			else if (count > 1) {
				result = "Se han encontrado la siguientes sugerencias: <ul>" + sb.toString() + "</ul>";
			}

			faq.setWarningMessages(result);
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
}
