package com.upsam.hospital.model.repository.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class VideoRepositoryTest extends UnitTest {

	@Mock
	private HibernateTemplate hibernateTemplate;
	@InjectMocks
	private VideoRepository videoRepository;

	@Test
	public void canSaveAVideo() throws SQLException, DataBaseException {
		Video paciente = aVideo();

		videoRepository.save(paciente);

		verify(hibernateTemplate, times(1)).save(paciente);
	}

	@Test
	public void canUpdateAVideo() throws SQLException, DataBaseException {
		Video video = aVideo();
		video.setDescripcion("upsam");

		videoRepository.update(video);

		verify(hibernateTemplate, times(1)).update(video);
	}

	@Test
	public void canDeleteAVideo() throws SQLException, DataBaseException {
		Video video = aVideo();

		videoRepository.delete(video);

		verify(hibernateTemplate, times(1)).delete(video);
	}

	@Test
	public void canFindAVideo() throws SQLException, DataBaseException {
		Video video = aVideo();
		when(hibernateTemplate.get(Video.class, 178)).thenReturn(video);

		Video expectedVideo = videoRepository.findOne(178);

		assertThat("any", is(equalTo(expectedVideo.getDescripcion())));
	}

	@Test
	public void canFindAllVideos() throws SQLException, DataBaseException {
		List<Video> videos = new ArrayList<Video>();
		videos.add(aVideo());
		when(hibernateTemplate.loadAll(Video.class)).thenReturn(videos);

		List<Video> expectedVideos = videoRepository.findAll();

		assertThat(videos, is(equalTo(expectedVideos)));
	}

	private Video aVideo() {
		Video v = new Video();
		v.setId(178);
		v.setDescripcion("any");
		return v;
	}
}
