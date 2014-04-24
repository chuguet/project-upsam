package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesPCIRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesPCIRepository.
 */
@Repository
class AntecedentesPersonalesPCIRepository implements IAntecedentesPersonalesPCIRepository {

	/** The Constant QUERY_FIND_BY_EXPLORACION. */
	private static final String QUERY_FIND_BY_EXPLORACION = "Select new AntecedentesPersonalesPCI(ayudasMarcha,cuadriplejiaEspatica,deportes,diplejiaEspatica,dispositivoMasUsado,equipamiento,etiologia,exteriores,fisioterapiaDuracion,fisioterapiaSesiones,gradoI,gradoII,gradoIII,gradoIV,gradoV,hidroterapia,id,interiores,lgDuracion,lgSesiones,localizacion,ortesisDiurna,ortesisNocturna,otra,otras,pciMixta,pruebasComlementarias,terapiaOcupacionalDuracion,terapiaOcupacionalSesiones,terapiasHabituales,tratamientoActual,triplejiaEspatica) from AntecedentesPersonalesPCI where (ID_EXPLORACION = ?)";

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
	public void delete(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws SQLException {
		hibernateTemplate.delete(antecedentesPersonalesPCI);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<AntecedentesPersonalesPCI> findAll() throws SQLException {
		return hibernateTemplate.loadAll(AntecedentesPersonalesPCI.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IAntecedentesPersonalesPCIRepository
	 * #findByExploracion(java.lang.Integer)
	 */
	@Override
	public AntecedentesPersonalesPCI findByExploracion(Integer pId) throws SQLException {
		return (AntecedentesPersonalesPCI) hibernateTemplate.find(QUERY_FIND_BY_EXPLORACION, pId).get(0);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public AntecedentesPersonalesPCI findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(AntecedentesPersonalesPCI.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws SQLException {
		return (Integer) hibernateTemplate.save(antecedentesPersonalesPCI);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(AntecedentesPersonalesPCI antecedentesPersonalesPCI) throws SQLException {
		hibernateTemplate.update(antecedentesPersonalesPCI);
	}

}
