package com.upsam.hospital.model.repository.impl;

import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.repository.IFicheroMDXRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class FicheroMDXRepository.
 */
@Repository
class FicheroMDXRepository extends AbstractRepositoryDAO<FicheroMDX> implements IFicheroMDXRepository {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<FicheroMDX> getClazz() {
		return FicheroMDX.class;
	}

}
