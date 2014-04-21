package com.upsam.hospital.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import javassist.NotFoundException;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;

/**
 * The Interface IVideoService.
 */
public interface IVideoService {

	void save(byte[] content, Integer idPaciente, Integer idExploracion) throws FileNotFoundException, IOException, DataBaseException;

	void recuperarVideo(OutputStream outStream, String nombre, Integer idPaciente) throws FileNotFoundException;

	Video findOne(Integer idPaciente, Integer idExploracion, Integer id) throws DataBaseException, NotFoundException;

}
