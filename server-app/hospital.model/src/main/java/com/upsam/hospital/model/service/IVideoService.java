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

	void save(byte[] content, Integer idPaciente) throws FileNotFoundException, IOException, DataBaseException;

	Video findOne(Integer idPaciente, Integer id) throws DataBaseException, NotFoundException;

	void recuperarVideo(OutputStream outStream, String nombre, Integer idPaciente) throws FileNotFoundException;

}
