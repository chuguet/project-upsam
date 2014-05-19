package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesRepository.
 */
@Repository
class AntecedentesPersonalesRepository extends AbstractRepositoryDAO<AntecedentesPersonales> implements IAntecedentesPersonalesRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new AntecedentesPersonales(id, epilepsia, tipoEpilepsia, fechaUltimaCrisis, fechaUltimaConvulsion, numeroCrisis, caidas, numeroCaidas, fechaUltimaCaida, audicion, vision, lenguajeCognicion, comprension, entiendeOrdenesSimples, entiendeOrdenesComplejas, expresarNecesidadDolor, numeroInyecciones, fechaUltimaSesion, fechaPenultimaSesion, localizacionTratamiento, alergias, tratamiento) from AntecedentesPersonales where (ID_EXPLORACION = ?)";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IAntecedentesPersonalesRepository
	 * #findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AntecedentesPersonales findByExploracion(Integer pId) throws SQLException {
		List results = getHibernateTemplate().find(QUERY_FIND_BY_EXPLORACION, pId);
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
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<AntecedentesPersonales> getClazz() {
		return AntecedentesPersonales.class;
	}

}
