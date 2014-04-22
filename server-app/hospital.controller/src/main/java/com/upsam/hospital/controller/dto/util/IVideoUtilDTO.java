package com.upsam.hospital.controller.dto.util;

import java.util.List;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Video;

// TODO: Auto-generated Javadoc
/**
 * The Interface IVideoUtilDTO.
 */
public interface IVideoUtilDTO {

	/**
	 * Gets the videos list.
	 *
	 * @param videos the videos
	 * @return the videos list
	 * @throws TransferObjectException the transfer object exception
	 */
	List<VideoDTO> getVideosList(List<Video> videos) throws TransferObjectException;

	/**
	 * To business.
	 *
	 * @param videoDTO the video dto
	 * @return the video
	 * @throws TransferObjectException the transfer object exception
	 */
	Video toBusiness(VideoDTO videoDTO) throws TransferObjectException;

	/**
	 * To rest.
	 *
	 * @param video the video
	 * @return the video dto
	 * @throws TransferObjectException the transfer object exception
	 */
	VideoDTO toRest(Video video) throws TransferObjectException;
}
