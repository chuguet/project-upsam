package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.util.IFaqUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Faq;

// TODO: Auto-generated Javadoc
/**
 * The Class FaqUtilDTO.
 */
@Component
public class FaqUtilDTO implements IFaqUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.controller.dto.util.IFaqUtilDTO#toRest(com.upsam.hospital
	 * .model.beans.Faq)
	 */
	@Override
	public FaqDTO toRest(Faq faq) throws TransferObjectException {
		FaqDTO faqDTO = new FaqDTO();
		faqDTO.setInfoMessages(faq.getInfoMessages());
		faqDTO.setWarningMessages(faq.getWarningMessages());
		return faqDTO;
	}

}
