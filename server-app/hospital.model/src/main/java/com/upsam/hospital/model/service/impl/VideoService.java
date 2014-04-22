package com.upsam.hospital.model.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import javassist.NotFoundException;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.coremedia.iso.IsoFile;
import com.upsam.hospital.model.beans.Exploracion;
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

	/** The videos location. */
	@Value("${videos.location}")
	private String videosLocation;

	/** The paciente service. */
	@Inject
	private IPacienteService pacienteService;

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IVideoService#save(byte[],
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void save(byte[] content, Integer idPaciente, Integer idExploracion) throws FileNotFoundException, IOException, DataBaseException {
		String nombre = saveInFolder(content, idExploracion);
		String lengthInSeconds = getDuration(getFolderPath(idPaciente) + nombre);
		Paciente paciente = pacienteService.findOne(idExploracion);

		Video video = new Video();
		video.setDuracion(lengthInSeconds);
		video.setFecha(new Date());
		video.setNombre(nombre);
		for (Exploracion exploracion : paciente.getExploraciones()) {
			if (exploracion.getId().equals(idExploracion)) {
				video.setExploracion(exploracion);
				exploracion.getVideos().add(video);
			}
		}
		pacienteService.update(paciente);
	}

	/**
	 * Save in folder.
	 * 
	 * @param content
	 *            the content
	 * @param idPaciente
	 *            the id paciente
	 * @return the string
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	String saveInFolder(byte[] content, Integer idPaciente) throws FileNotFoundException, IOException {
		String folderPath = getFolderPath(idPaciente);
		validateFolderExist(folderPath);
		String nombre = getCurrentTimestamp() + ".mp4";
		String filePath = folderPath + nombre;
		FileUtils.writeByteArrayToFile(new File(filePath), content);
		return nombre;
	}

	/**
	 * Gets the folder path.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @return the folder path
	 */
	public String getFolderPath(Integer idPaciente) {
		return videosLocation.replace("xx", idPaciente.toString()).replace("/", File.separator);
	}

	/**
	 * Validate folder exist.
	 * 
	 * @param folderPath
	 *            the folder path
	 */
	private void validateFolderExist(String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	/**
	 * Gets the current timestamp.
	 * 
	 * @return the current timestamp
	 */
	private String getCurrentTimestamp() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		return currentTimestamp.getTime() + "";
	}

	/**
	 * Gets the duration.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the duration
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	String getDuration(String filePath) throws IOException {
		IsoFile isoFile = new IsoFile(filePath);
		double doubleSeconds = (double) isoFile.getMovieBox().getMovieHeaderBox().getDuration() / isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
		isoFile.close();
		return getDurationString(doubleSeconds);
	}

	/**
	 * Gets the duration string.
	 * 
	 * @param doubleSeconds
	 *            the double seconds
	 * @return the duration string
	 */
	private String getDurationString(double doubleSeconds) {
		String milliseconds = String.valueOf(doubleSeconds - Math.floor(doubleSeconds)).substring(2, 5);
		int seconds = (int) doubleSeconds;
		int hours = seconds / 3600;
		int minutes = (seconds % 3600) / 60;
		seconds = seconds % 60;
		return twoDigitString(hours) + "h " + twoDigitString(minutes) + "m " + twoDigitString(seconds) + "s " + milliseconds + "ms";
	}

	/**
	 * Two digit string.
	 * 
	 * @param number
	 *            the number
	 * @return the string
	 */
	private String twoDigitString(int number) {
		if (number == 0) {
			return "00";
		}
		if (number / 10 == 0) {
			return "0" + number;
		}
		return String.valueOf(number);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IVideoService#findOne(java.lang.Integer,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Video findOne(Integer idPaciente, Integer idExploracion, Integer id) throws DataBaseException, NotFoundException {
		Paciente paciente = pacienteService.findOne(idPaciente);
		for (Exploracion exploracion : paciente.getExploraciones()) {
			if (exploracion.getId().equals(idExploracion)) {
				for (Video video : exploracion.getVideos()) {
					if (video.getId().equals(id)) {
						return video;
					}
				}
			}
		}

		throw new NotFoundException("Se ha producido un error al recuperar un vídeo de un paciente");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IVideoService#recuperarVideo(java.io
	 * .OutputStream, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void recuperarVideo(OutputStream outStream, String nombre, Integer idPaciente) throws FileNotFoundException {
		String folderPath = getFolderPath(idPaciente);

		String filePath = folderPath + nombre;
		File video = new File(filePath);
		if (!video.exists()) {
			throw new FileNotFoundException();
		}
		byte[] buf = new byte[8192];

		InputStream is = new FileInputStream(video);

		int c = 0;

		try {
			while ((c = is.read(buf, 0, buf.length)) > 0) {
				outStream.write(buf, 0, c);
			}

			is.close();
			// outStream.flush();
			// outStream.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
