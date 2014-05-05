package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.ParteCuerpoDTO;
import com.upsam.hospital.controller.dto.util.IParteCuerpoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.ParteCuerpo;

// TODO: Auto-generated Javadoc
/**
 * The Class ParteCuerpoUtilDTO.
 */
@Component
public class ParteCuerpoUtilDTO implements IParteCuerpoUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IParteCuerpoUtilDTO#toBusiness
	 * (com.upsam.hospital.controller.dto.ParteCuerpoDTO)
	 */
	@Override
	public ParteCuerpo toBusiness(ParteCuerpoDTO parteCuerpoDTO) throws TransferObjectException {
		ParteCuerpo parteCuerpo = new ParteCuerpo();
		parteCuerpo.setId(parteCuerpoDTO.getId());
		parteCuerpo.setParte(parteCuerpoDTO.getParte());
		return parteCuerpo;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IParteCuerpoUtilDTO#toRest(com
	 * .upsam.hospital.model.beans.ParteCuerpo)
	 */
	@Override
	public ParteCuerpoDTO toRest(ParteCuerpo parteCuerpo) throws TransferObjectException {
		ParteCuerpoDTO parteCuerpoDTO = new ParteCuerpoDTO();
		parteCuerpoDTO.setId(parteCuerpo.getId());
		parteCuerpoDTO.setParte(parteCuerpo.getParte());
		return parteCuerpoDTO;
	}

}
