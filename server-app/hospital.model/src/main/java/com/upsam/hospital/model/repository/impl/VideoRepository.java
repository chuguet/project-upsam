package com.upsam.hospital.model.repository.impl;

import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.repository.IVideoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoRepository.
 */
@Repository
class VideoRepository extends AbstractRepositoryDAO<Video> implements IVideoRepository {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.impl.AbstractRepositoryDAO#getClazz()
	 */
	@Override
	protected Class<Video> getClazz() {
		return Video.class;
	}

}
