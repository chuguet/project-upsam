package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.AntecedentesQuirurgicosOrtopedicos;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesQuirurgicosOrtopedicosRepository;
import com.upsam.hospital.model.service.IAntecedentesQuirurgicosOrtopedicosService;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesService.
 */
@Service
public class AntecedentesQuirurgicosOrtopedicosService implements IAntecedentesQuirurgicosOrtopedicosService {

	/** The antecedentes personales repository. */
	@Inject
	private IAntecedentesQuirurgicosOrtopedicosRepository antecedentesQuirurgicosOrtopedicosRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IModelService#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws DataBaseException {
		try {
			antecedentesQuirurgicosOrtopedicosRepository.delete(antecedentesQuirurgicosOrtopedicos);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al eliminar un antecedente personal");
		}
	}

	@Override
	public List<AntecedentesQuirurgicosOrtopedicos> findAll() throws DataBaseException {
		try {
			return antecedentesQuirurgicosOrtopedicosRepository.findAll();
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar todas los antecedentes personales");
		}
	}

	@Override
	public List<AntecedentesQuirurgicosOrtopedicos> findByAntecedentePersonal(Integer pId) throws DataBaseException {
		try {
			return antecedentesQuirurgicosOrtopedicosRepository.findByAntecedentePersonal(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un antecedente personal");
		}
	}

	@Override
	public void deleteByAntecedentePersonal(Integer pId) throws DataBaseException {
		List<AntecedentesQuirurgicosOrtopedicos> antecedentes = this.findByAntecedentePersonal(pId);
		if (antecedentes != null) {
			for (AntecedentesQuirurgicosOrtopedicos antecedente : antecedentes) {
				this.delete(antecedente);
			}
		}
	}

	@Override
	public AntecedentesQuirurgicosOrtopedicos findOne(Integer pId) throws DataBaseException {
		try {
			return antecedentesQuirurgicosOrtopedicosRepository.findOne(pId);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al recuperar un antecedente quirúrgico/ortopédico por su identificador");
		}
	}

	@Override
	public Integer save(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws DataBaseException {
		try {
			return antecedentesQuirurgicosOrtopedicosRepository.save(antecedentesQuirurgicosOrtopedicos);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al insertar un antecedente quirúrgico/ortopédico");
		}
	}

	@Override
	public void update(AntecedentesQuirurgicosOrtopedicos antecedentesQuirurgicosOrtopedicos) throws DataBaseException {
		try {
			antecedentesQuirurgicosOrtopedicosRepository.update(antecedentesQuirurgicosOrtopedicos);
		}
		catch (SQLException e1) {
			throw new DataBaseException("Se ha producido un error al actualizar un antecedente quirúrgico/ortopédico");
		}
	}
}