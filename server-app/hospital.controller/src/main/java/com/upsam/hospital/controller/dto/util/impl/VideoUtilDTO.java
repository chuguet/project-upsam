package com.upsam.hospital.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Video;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class VideoUtilDTO implements IVideoUtilDTO {

	/** The Constant DATE_TIME_FORMATTER. */
	private static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#getVideosList
	 * (java.util.List)
	 */
	@Override
	public List<VideoDTO> getVideosList(List<Video> videos) throws TransferObjectException {
		List<VideoDTO> result = new ArrayList<VideoDTO>();
		for (Video video : videos) {
			result.add(this.toRest(video));
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IVideoUtilDTO#toBusiness(com.upsam
	 * .hospital.controller.dto.VideoDTO)
	 */
	@Override
	public Video toBusiness(VideoDTO videoDTO) throws TransferObjectException {
		Video video = null;
		try {
			video = new Video();
			video.setDescripcion(videoDTO.getDescripcion());
			video.setDuracion(video.getDuracion());
			video.setFecha(DATE_TIME_FORMATTER.parse(videoDTO.getFecha()));
			video.setId(videoDTO.getId());
			video.setNombre(videoDTO.getNombre());
		}
		catch (ParseException e) {
			throw new TransferObjectException(e.getMessage(), e);
		}
		return video;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IPacienteUtilDTO#toRest(com.upsam
	 * .hospital.model.beans.Paciente)
	 */
	@Override
	public VideoDTO toRest(Video video) throws TransferObjectException {
		VideoDTO videoDTO = new VideoDTO();
		videoDTO.setFecha(DATE_TIME_FORMATTER.format(video.getFecha()));
		videoDTO.setNombre(video.getNombre());
		videoDTO.setId(video.getId());
		videoDTO.setDuracion(video.getDuracion());
		videoDTO.setDescripcion(video.getDescripcion());
		return videoDTO;
	}
}
