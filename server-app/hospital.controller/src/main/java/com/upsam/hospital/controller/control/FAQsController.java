package com.upsam.hospital.controller.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.model.beans.Faqs;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFaqsService;

@Controller
@RequestMapping("/faqs")
public class FAQsController {

	@Inject
	private IFaqsService faqsService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody FaqDTO faqDTO) {
		try {
			Faqs faqs = new Faqs();
			faqs.setSeccion(faqDTO.seccion);
			faqs.setDescripcion(faqDTO.descripcion);
			faqs.setTitulo(faqDTO.titulo);
			faqs.setFotos(faqDTO.fotos);
			faqs.setTituloUrl(faqDTO.tituloUrl);
			faqsService.save(faqs);
			
			return new MensajeDTO("faq creada correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO(e.getMessage(), false);
		}
	}
	
	@RequestMapping(value = "/faqs", method = RequestMethod.GET)
	public String printWelcome() {
		System.out.println("********************faqs****************");
		return "faqs/faqs";
	}
}
