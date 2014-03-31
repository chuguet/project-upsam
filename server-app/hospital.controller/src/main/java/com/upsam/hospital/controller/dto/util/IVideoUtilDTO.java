package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Video;

public interface IVideoUtilDTO {

	Video toBusiness(VideoDTO videoDTO);

	VideoDTO toRest(Video video) throws TransferObjectException;
}
