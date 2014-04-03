package com.upsam.hospital.controller.dto.util;

import java.util.List;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.jaxb.EmxDataFile;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioUtilDTO.
 */
public interface IPacienteUtilDTO {

	/**
	 * File3d to dto.
	 * 
	 * @param emxDataFile
	 *            the emx data file
	 * @return the video3d dto
	 */
	FicheroMDXDTO fileMDXToDTO(EmxDataFile emxDataFile);

	/**
	 * Gets the video3d info list.
	 * 
	 * @param ficheros
	 *            the ficheros
	 * @return the video3d info list
	 */
	List<FicheroMDXInfoDTO> getFicherosMDXInfoList(List<FicheroMDX> ficheros);

	/**
	 * Gets the videos list.
	 * 
	 * @param videos
	 *            the videos
	 * @return the videos list
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	List<VideoDTO> getVideosList(List<Video> videos) throws TransferObjectException;

	/**
	 * To business.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the usuario
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	Paciente toBusiness(PacienteDTO usuarioDTO) throws TransferObjectException;

	/**
	 * To rest.
	 * 
	 * @param paciente
	 *            the paciente
	 * @return the usuario dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	PacienteDTO toRest(Paciente paciente) throws TransferObjectException;

}
