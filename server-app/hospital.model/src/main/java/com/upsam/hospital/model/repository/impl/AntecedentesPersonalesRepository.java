package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesRepository.
 */
@Repository
class AntecedentesPersonalesRepository implements IAntecedentesPersonalesRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new AntecedentesPersonales(id, epilepsia, tipoEpilepsia, fechaUltimaCrisis, fechaUltimaConvulsion, numeroCrisis, caidas, numeroCaidas, fechaUltimaCaida, audicion, vision, lenguajeCognicion, comprension, entiendeOrdenesSimples, entiendeOrdenesComplejas, expresarNecesidadDolor, numeroInyecciones, fechaUltimaSesion, fechaPenultimaSesion, localizacionTratamiento, alergias, tratamiento) from AntecedentesPersonales where (ID_EXPLORACION = ?)";

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#delete(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void delete(AntecedentesPersonales antecedentesPersonales) throws SQLException {
		hibernateTemplate.delete(antecedentesPersonales);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<AntecedentesPersonales> findAll() throws SQLException {
		return hibernateTemplate.loadAll(AntecedentesPersonales.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IAntecedentesPersonalesRepository
	 * #findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AntecedentesPersonales findByExploracion(Integer pId) throws SQLException {
		List results = hibernateTemplate.find(QUERY_FIND_BY_EXPLORACION, pId);
		if (results.size() > 0) {
			return (AntecedentesPersonales) results.get(0);
		}
		else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public AntecedentesPersonales findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(AntecedentesPersonales.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(AntecedentesPersonales antecedentesPersonales) throws SQLException {
		return (Integer) hibernateTemplate.save(antecedentesPersonales);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(AntecedentesPersonales antecedentesPersonales) throws SQLException {
		hibernateTemplate.update(antecedentesPersonales);
	}

}
