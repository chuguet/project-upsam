package com.upsam.hospital.controller.dto.util;

import java.util.List;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.Video3dDTO;
import com.upsam.hospital.controller.dto.Video3dInfoDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Fichero3D;
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
	Video3dDTO file3dToDTO(EmxDataFile emxDataFile);

	List<Video3dInfoDTO> getVideo3dInfoList(List<Fichero3D> ficheros);

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

	List<VideoDTO> getVideosList(List<Video> videos) throws TransferObjectException;

}
