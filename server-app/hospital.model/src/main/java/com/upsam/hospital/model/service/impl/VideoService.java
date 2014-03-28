package com.upsam.hospital.model.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.coremedia.iso.IsoFile;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IVideoService;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoService.
 */
@Service
@PropertySource("classpath:/application.properties")
class VideoService implements IVideoService {

	@Value("${videos.location}")
	private String videosLocation;

	@Inject
	private IPacienteService pacienteService;

	@Override
	public void save(byte[] content, Integer idPaciente) throws FileNotFoundException, IOException, DataBaseException {
		String nombre = saveInFolder(content, idPaciente);
		String lengthInSeconds = getDuration(getFolderPath(idPaciente) + nombre);
		Paciente paciente = pacienteService.findOne(idPaciente);

		Video video = new Video();
		video.setDuracion(lengthInSeconds);
		video.setFecha(new Date());
		video.setPaciente(paciente);
		video.setNombre(nombre);
		paciente.getVideos().add(video);
		pacienteService.update(paciente);
	}

	private String saveInFolder(byte[] content, Integer idPaciente) throws FileNotFoundException, IOException {
		String folderPath = getFolderPath(idPaciente);
		validateFolderExist(folderPath);
		String nombre = getCurrentTimestamp() + ".mp4";
		String filePath = folderPath + nombre;
		FileUtils.writeByteArrayToFile(new File(filePath), content);
		return nombre;
	}

	public String getFolderPath(Integer idPaciente) {
		return videosLocation.replace("xx", idPaciente.toString()).replace("/", File.separator);
	}

	private void validateFolderExist(String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	private String getCurrentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp.getTime() + "";
	}

	private String getDuration(String filePath) throws IOException {
		IsoFile isoFile = new IsoFile(filePath);
		double doubleSeconds = (double) isoFile.getMovieBox().getMovieHeaderBox().getDuration() / isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
		isoFile.close();
		return getDurationString(doubleSeconds);
	}

	private String getDurationString(double doubleSeconds) {
		String milliseconds = String.valueOf(doubleSeconds - Math.floor(doubleSeconds)).substring(2, 5);
		int seconds = (int) doubleSeconds;
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = seconds % 60;
		return twoDigitString(hours) + "h " + twoDigitString(minutes) + "m " + twoDigitString(seconds) + "s " + milliseconds + "ms";
	}

	private String twoDigitString(int number) {
		if (number == 0) {
			return "00";
		}
		if (number / 10 == 0) {
			return "0" + number;
		}
		return String.valueOf(number);
	}
}
