package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.repository.IVideoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoRepository.
 */
@Repository
class VideoRepository implements IVideoRepository {

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
	public void delete(Video video) throws SQLException {
		hibernateTemplate.delete(video);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Video> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Video.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Video findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Video.class, pId);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#save(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public Integer save(Video video) throws SQLException {
		return (Integer) hibernateTemplate.save(video);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IRepositoryDAO#update(com.upsam.hospital
	 * .model.beans.IModelHospital)
	 */
	@Override
	public void update(Video video) throws SQLException {
		hibernateTemplate.update(video);
	}

}
