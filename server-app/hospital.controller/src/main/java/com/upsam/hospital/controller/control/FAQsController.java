package com.upsam.hospital.controller.control;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFaqsService;

@Controller
@RequestMapping("/faqs")
public class FAQsController {
	
	private final static Log LOG = LogFactory.getLog(FAQsController.class);

	@Inject
	private IFaqsService faqsService;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody FaqDTO faqDTO) {
		try {
			Faq faqs = new Faq();
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {
		List<Faq> models = null;
		
		try {
			models = faqsService.findAll();
		} catch (DataBaseException e) {
			LOG.error(e.getMessage() + " ********* " + e.getStackTrace());
		}
		model.addAttribute("faqs", models);
		return "faqs/faqs";
    }
}
