package com.upsam.hospital.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import javassist.NotFoundException;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IVideoService.
 */
public interface IVideoService {

	/**
	 * Find one.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param id
	 *            the id
	 * @return the video
	 * @throws DataBaseException
	 *             the data base exception
	 * @throws NotFoundException
	 *             the not found exception
	 */
	Video findOne(Integer idPaciente, Integer idExploracion, Integer id) throws DataBaseException, NotFoundException;

	/**
	 * Recuperar video.
	 * 
	 * @param outStream
	 *            the out stream
	 * @param nombre
	 *            the nombre
	 * @param idPaciente
	 *            the id paciente
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	void recuperarVideo(OutputStream outStream, String nombre, Integer idPaciente) throws FileNotFoundException;

	/**
	 * Save.
	 * 
	 * @param content
	 *            the content
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws DataBaseException
	 *             the data base exception
	 */
	void save(byte[] content, Integer idPaciente, Integer idExploracion) throws FileNotFoundException, IOException, DataBaseException;

}
