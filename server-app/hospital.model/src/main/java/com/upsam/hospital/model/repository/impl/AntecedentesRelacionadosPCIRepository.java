package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.repository.IAntecedentesRelacionadosPCIRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesPCIRepository.
 */
@Repository
class AntecedentesRelacionadosPCIRepository extends AbstractRepositoryDAO<AntecedentesRelacionadosPCI> implements IAntecedentesRelacionadosPCIRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new AntecedentesRelacionadosPCI(id,ayudasMarcha,deportes,dispositivoMasUsado,equipamiento,etiologia,exteriores,fisioterapiaDuracion,fisioterapiaSesiones,gmfcs,hidroterapia,interiores,lgDuracion,lgSesiones,localizacion,ortesisDiurna,otraOrtesis,ortesisNocturna,otras,pruebasComplementarias,terapiaOcupacionalDuracion,terapiaOcupacionalSesiones,terapiasHabituales,tratamientoActual, diagnosticoEspecificar, otrasTerapias, tipoPCI) from AntecedentesRelacionadosPCI where (ID_EXPLORACION = ?)";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IAntecedentesPersonalesPCIRepository
	 * #findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AntecedentesRelacionadosPCI findByExploracion(Integer pId) throws SQLException {
		List results = getHibernateTemplate().find(QUERY_FIND_BY_EXPLORACION, pId);
		if (results.size() > 0) {
			return (AntecedentesRelacionadosPCI) results.get(0);
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
	protected Class<AntecedentesRelacionadosPCI> getClazz() {
		return AntecedentesRelacionadosPCI.class;
	}

}
