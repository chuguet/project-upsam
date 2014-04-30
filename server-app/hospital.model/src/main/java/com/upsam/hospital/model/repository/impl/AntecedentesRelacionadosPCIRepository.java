package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.repository.IAntecedentesRelacionadosPCIRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesPCIRepository.
 */
@Repository
class AntecedentesRelacionadosPCIRepository implements IAntecedentesRelacionadosPCIRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new AntecedentesRelacionadosPCI(id,ayudasMarcha,cuadriplejiaEspatica,deportes,diplejiaEspatica,dispositivoMasUsado,equipamiento,etiologia,exteriores,fisioterapiaDuracion,fisioterapiaSesiones,gradoI,gradoII,gradoIII,gradoIV,gradoV,hidroterapia,interiores,lgDuracion,lgSesiones,localizacion,ortesisDiurna,otraOrtesis,ortesisNocturna,otra,otras,pciMixta,pruebasComplementarias,terapiaOcupacionalDuracion,terapiaOcupacionalSesiones,terapiasHabituales,tratamientoActual,triplejiaEspatica, diagnosticoEspecificar, otrasTerapias) from AntecedentesRelacionadosPCI where (ID_EXPLORACION = ?)";
	// private static final String QUERY_FIND_BY_EXPLORACION =
	// "Select new AntecedentesRelacionadosPCI(id,ayudasMarcha,cuadriplejiaEspatica,deportes,diplejiaEspatica,dispositivoMasUsado,equipamiento,etiologia,exteriores,fisioterapiaDuracion,fisioterapiaSesiones,gradoI,gradoII,gradoIII,gradoIV,gradoV,hidroterapia,interiores,lgDuracion,lgSesiones,localizacion,ortesisNocturna,otra,otras,pciMixta,pruebasComplementarias,terapiaOcupacionalDuracion,terapiaOcupacionalSesiones,terapiasHabituales,tratamientoActual,triplejiaEspatica, diagnosticoEspecificar) from AntecedentesRelacionadosPCI where (ID_EXPLORACION = ?)";

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
	public void delete(AntecedentesRelacionadosPCI antecedentesPersonalesPCI) throws SQLException {
		hibernateTemplate.delete(antecedentesPersonalesPCI);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<AntecedentesRelacionadosPCI> findAll() throws SQLException {
		return hibernateTemplate.loadAll(AntecedentesRelacionadosPCI.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IAntecedentesPersonalesPCIRepository
	 * #findByExploracion(java.lang.Integer)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public AntecedentesRelacionadosPCI findByExploracion(Integer pId) throws SQLException {
		List results = hibernateTemplate.find(QUERY_FIND_BY_EXPLORACION, pId);
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
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public AntecedentesRelacionadosPCI findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(AntecedentesRelacionadosPCI.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(AntecedentesRelacionadosPCI antecedentesPersonalesPCI) throws SQLException {
		return (Integer) hibernateTemplate.save(antecedentesPersonalesPCI);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(AntecedentesRelacionadosPCI antecedentesPersonalesPCI) throws SQLException {
		hibernateTemplate.update(antecedentesPersonalesPCI);
	}

}
