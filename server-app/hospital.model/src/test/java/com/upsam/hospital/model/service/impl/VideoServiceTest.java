package com.upsam.hospital.model.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javassist.NotFoundException;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Value;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IVideoRepository;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.unit.UnitTest;

public class VideoServiceTest extends UnitTest {

	@Value("${videos.location}")
	private String videosLocation;
	private static final int PACIENTE_ID = 112;
	private static final int VIDEO_ID = 178;

	@Mock
	private IVideoRepository videoRepository;
	@Mock
	private IPacienteService pacienteService;
	@InjectMocks
	@Spy
	private VideoService videoService;

	@Test
	public void canSaveAVideo() throws SQLException, DataBaseException, FileNotFoundException, IOException {
		Paciente paciente = aPatient();
		byte[] byteArray = new byte[] { 87 };
		doReturn("any").when(videoService).saveInFolder(byteArray, PACIENTE_ID);
		doReturn("any").when(videoService).getDuration(anyString());
		doReturn("any").when(videoService).getFolderPath(anyInt());
		stub(pacienteService.findOne(PACIENTE_ID)).toReturn(paciente);

		videoService.save(byteArray, PACIENTE_ID);

		verify(pacienteService, times(1)).update(paciente);
	}

	@Test
	public void canFindAVideo() throws SQLException, DataBaseException, NotFoundException {
		when(pacienteService.findOne(PACIENTE_ID)).thenReturn(aPatient());

		Video video = videoService.findOne(PACIENTE_ID, VIDEO_ID);

		assertThat("any", is(equalTo(video.getDescripcion())));
	}

	@Test(expected = NotFoundException.class)
	public void whenNoVideoThrowsNotFoundException_findOne() throws SQLException, DataBaseException, NotFoundException {
		stub(pacienteService.findOne(PACIENTE_ID)).toReturn(aPatient());

		videoService.findOne(PACIENTE_ID, 1);
	}

	@Test
	public void canRetrieveAVideo() throws SQLException, DataBaseException, NotFoundException, FileNotFoundException {
		OutputStream outputStreamMock = mock(OutputStream.class);
		stub(pacienteService.findOne(PACIENTE_ID)).toReturn(aPatient());
		doReturn(System.getProperty("user.dir") + "/src/test/files/").when(videoService).getFolderPath(anyInt());

		videoService.recuperarVideo(outputStreamMock, "video.mp4", PACIENTE_ID);
	}

	private Video aVideo() {
		Video v = new Video();
		v.setId(VIDEO_ID);
		v.setDescripcion("any");
		return v;
	}

	private Paciente aPatient() {
		Paciente p = new Paciente();
		List<Exploracion> exploraciones = new ArrayList<Exploracion>();
		videos.add(aVideo());
		p.setId(PACIENTE_ID);
		p.setApellidos("any");
		p.setVideos(videos);
		return p;
	}
}
