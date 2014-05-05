package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.SintomaDTO;
import com.upsam.hospital.controller.dto.util.ISintomaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.ParteCuerpo;
import com.upsam.hospital.model.beans.Sintoma;

// TODO: Auto-generated Javadoc
/**
 * The Class SintomaUtilDTO.
 */
@Component
public class SintomaUtilDTO implements ISintomaUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.ISintomaUtilDTO#toBusiness(com
	 * .upsam.hospital.controller.dto.SintomaDTO)
	 */
	@Override
	public Sintoma toBusiness(SintomaDTO sintomaDTO) throws TransferObjectException {
		Sintoma sintoma = new Sintoma();
		sintoma.setId(sintomaDTO.getId());
		sintoma.setSintoma(sintomaDTO.getSintoma());
		sintoma.setParteCuerpo(new ParteCuerpo(sintomaDTO.getIdParteCuerpo()));
		return sintoma;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.ISintomaUtilDTO#toRest(com.upsam
	 * .hospital.model.beans.Sintoma)
	 */
	@Override
	public SintomaDTO toRest(Sintoma sintoma) throws TransferObjectException {
		SintomaDTO sintomaDTO = new SintomaDTO();
		sintomaDTO.setId(sintoma.getId());
		sintomaDTO.setSintoma(sintoma.getSintoma());
		return sintomaDTO;
	}

}
