package com.upsam.hospital.model.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javassist.NotFoundException;
import javax.inject.Inject;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.coremedia.iso.IsoFile;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IVideoRepository;
import com.upsam.hospital.model.service.IExploracionService;
import com.upsam.hospital.model.service.IVideoService;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoService.
 */
@Service
@PropertySource("classpath:/application.properties")
class VideoService implements IVideoService {
	static Logger logger = Logger.getLogger(VideoService.class);
	/** The videos location. */
	@Value("${videos.location}")
	private String videosLocation;

	/** The paciente service. */
	@Inject
	private IExploracionService exploracionService;

	@Inject
	private IVideoRepository videoRepository;

	/*
	 * (non-Javadoc)
	 * @see com.upsam.hospital.model.service.IVideoService#save(byte[],
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void save(byte[] content, Integer idPaciente, Integer idExploracion, String descripcion) throws FileNotFoundException, IOException, DataBaseException, SQLException {
		String nombre = saveInFolder(content, idExploracion);
		String lengthInSeconds = getDuration(getFolderPath(idPaciente) + nombre);
		// Paciente paciente = pacienteService.findOne(idPaciente);

		Video video = new Video();
		video.setDuracion(lengthInSeconds);
		video.setFecha(new Date());
		video.setNombre(nombre);
		video.setDescripcion(descripcion);
		video.setExploracion(new Exploracion(idExploracion));
		videoRepository.save(video);
		// for (Exploracion exploracion : paciente.getExploraciones()) {
		// if (exploracion.getId().equals(idExploracion)) {
		// video.setExploracion(exploracion);
		// exploracion.getVideos().add(video);
		// break;
		// }
		// }
		// pacienteService.update(paciente);
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
	private String saveInFolder(byte[] content, Integer idPaciente) throws FileNotFoundException, IOException {
		String folderPath = getFolderPath(idPaciente);
		logger.info("Save in folder: " + folderPath);
		validateFolderExist(folderPath);
		String nombre = getCurrentTimestamp() + ".mp4";
		String filePath = folderPath + nombre;
		File video = new File(filePath);
		FileUtils.writeByteArrayToFile(video, content);
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
		Exploracion exploracion = this.exploracionService.findOne(idExploracion);
		// Paciente paciente = pacienteService.findOne(idPaciente);
		// for (Exploracion exploracion : paciente.getExploraciones()) {
		// if (exploracion.getId().equals(idExploracion)) {
		for (Video video : exploracion.getVideos()) {
			if (video.getId().equals(id)) {
				return video;
			}
		}
		// }
		// }

		throw new NotFoundException("Se ha producido un error al recuperar un vídeo de un paciente");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IVideoService#recuperarVideo(java.io
	 * .OutputStream, java.lang.String, java.lang.Integer)
	 */
	@Override
	public File recuperarVideo(String nombre, Integer idPaciente) throws FileNotFoundException {
		String folderPath = getFolderPath(idPaciente);

		String filePath = folderPath + nombre;
		File video = new File(filePath);
		if (!video.exists()) {
			throw new FileNotFoundException();
		}
		return video;
	}

	@Override
	public byte[] recuperarVideo2(String nombre, Integer idPaciente) throws IOException {
		String folderPath = getFolderPath(idPaciente);

		String filePath = folderPath + nombre;
		File video = new File(filePath);
		if (!video.exists()) {
			throw new FileNotFoundException();
		}
		return read(video);
	}

	private byte[] read(File file) throws IOException {
		ByteArrayOutputStream ous = null;
		InputStream ios = null;
		try {
			byte[] buffer = new byte[4096];
			ous = new ByteArrayOutputStream();
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1) {
				ous.write(buffer, 0, read);
			}
		}
		finally {
			try {
				if (ous != null)
					ous.close();
			}
			catch (IOException e) {}

			try {
				if (ios != null)
					ios.close();
			}
			catch (IOException e) {}
		}
		return ous.toByteArray();
	}
}
