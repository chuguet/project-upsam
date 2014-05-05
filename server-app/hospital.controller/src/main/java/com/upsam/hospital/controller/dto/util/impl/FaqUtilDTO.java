package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.util.IFaqUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.beans.Sintoma;

// TODO: Auto-generated Javadoc
/**
 * The Class FaqUtilDTO.
 */
@Component
public class FaqUtilDTO implements IFaqUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IFaqUtilDTO#toBusiness(com.upsam
	 * .hospital.controller.dto.FaqDTO)
	 */
	@Override
	public Faq toBusiness(FaqDTO faqDTO) throws TransferObjectException {
		Faq faq = new Faq();
		faq.setPregunta(faqDTO.getPregunta());
		faq.setRespuesta(faqDTO.getRespuesta());
		faq.setId(faqDTO.getId());
		faq.setSintoma(new Sintoma(faqDTO.getIdSintoma()));
		return faq;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IFaqUtilDTO#toRest(com.upsam.hospital
	 * .model.beans.Faq)
	 */
	@Override
	public FaqDTO toRest(Faq faq) throws TransferObjectException {
		FaqDTO faqDTO = new FaqDTO();
		faqDTO.setPregunta(faq.getPregunta());
		faqDTO.setRespuesta(faq.getRespuesta());
		faqDTO.setId(faq.getId());
		return faqDTO;
	}

}
