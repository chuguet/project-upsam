package com.upsam.hospital.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.upsam.hospital.model.exceptions.DataBaseException;

/**
 * The Interface IVideoService.
 */
public interface IVideoService {

	void save(byte[] content, Integer idPaciente) throws FileNotFoundException, IOException, DataBaseException;

}
