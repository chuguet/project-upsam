package com.upsam.hospital.model.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Inject;
import org.junit.Test;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IVideoService;

public class VideoServiceTest extends AbstractTest {

	@Inject
	private IVideoService videoService;

	@Test
	public void saveInFolder() throws IOException, DataBaseException {
		Path path = Paths.get("D:/Projects/workspace_project-upsam/documentacion/TestFiles/video.mp4");
		byte[] data = Files.readAllBytes(path);
		videoService.save(data, 1);
		System.out.println("YEAH");
	}
}
