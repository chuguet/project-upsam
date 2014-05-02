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
	 * com.upsam.hospital.controller.dto.util.IFaqUtilDTO#toBusiness(com.upsam
	 * .hospital.controller.dto.FaqDTO)
	 */
	@Override
	public Faq toBusiness(FaqDTO faqDTO) throws TransferObjectException {
		Faq faq = new Faq();
		faq.setDescripcion(faqDTO.getDescripcion());
		faq.setFotos(faqDTO.getFotos());
		faq.setId(faqDTO.getId());
		faq.setSeccion(faqDTO.getSeccion());
		faq.setTitulo(faqDTO.getTitulo());
		faq.setTituloUrl(faqDTO.getTituloUrl());
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
		faqDTO.setDescripcion(faq.getDescripcion());
		faqDTO.setFotos(faq.getFotos());
		faqDTO.setId(faq.getId());
		faqDTO.setSeccion(faq.getSeccion());
		faqDTO.setTitulo(faq.getTitulo());
		faqDTO.setTituloUrl(faq.getTituloUrl());
		return faqDTO;
	}

}
