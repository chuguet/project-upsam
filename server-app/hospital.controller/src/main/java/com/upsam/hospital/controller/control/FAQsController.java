package com.upsam.hospital.controller.control;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.util.IFaqUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFaqsService;

// TODO: Auto-generated Javadoc
/**
 * The Class FAQsController.
 */
@Controller
@RequestMapping("/faqs")
public class FAQsController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(FAQsController.class);

	/** The faqs service. */
	@Inject
	private IFaqsService faqsService;

	/** The faq util dto. */
	@Inject
	private IFaqUtilDTO faqUtilDTO;

	/**
	 * Insert.
	 * 
	 * @param faqDTO
	 *            the faq dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody FaqDTO faqDTO) {
		try {
			Faq faq = faqUtilDTO.toBusiness(faqDTO);
			faqsService.save(faq);
			return new MensajeDTO("Faq creada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido insertar una faq");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una faq");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<FaqDTO> listAll() {
		List<FaqDTO> faqsDTO = new ArrayList<FaqDTO>();
		List<Faq> faqs;
		FaqDTO faqDTO;
		try {
			faqs = faqsService.findAll();
			for (Faq faq : faqs) {
				faqDTO = faqUtilDTO.toRest(faq);
				faqsDTO.add(faqDTO);
			}
		}
		catch (DataBaseException e) {
			LOG.info("No se ha podido recuperar todas las faqs");
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una faq");
			LOG.error(e.getMessage());
		}
		return faqsDTO;
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the faq dto
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public FaqDTO retrieve(@PathVariable("id") Integer id) {
		FaqDTO faqDTO = null;
		Faq faq;
		try {
			faq = faqsService.findOne(id);
			faqDTO = faqUtilDTO.toRest(faq);
		}
		catch (DataBaseException e) {
			LOG.error("Error al recuperar una faq");
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una faq");
			LOG.error(e.getMessage());
		}
		return faqDTO;
	}

	/**
	 * Retrieve by seccion.
	 * 
	 * @param seccion
	 *            the seccion
	 * @return the list
	 */
	@RequestMapping(value = "seccion/{seccion}", method = RequestMethod.GET)
	public List<FaqDTO> retrieveBySeccion(@PathVariable("seccion") String seccion) {
		List<FaqDTO> faqsDTO = new ArrayList<FaqDTO>();
		List<Faq> faqs;
		FaqDTO faqDTO;
		try {
			faqs = faqsService.findBySeccion(seccion);
			for (Faq faq : faqs) {
				faqDTO = faqUtilDTO.toRest(faq);
				faqsDTO.add(faqDTO);
			}
		}
		catch (DataBaseException e) {
			LOG.error("Error al recuperar una faq");
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una faq");
			LOG.error(e.getMessage());
		}
		return faqsDTO;
	}

	/**
	 * Update.
	 * 
	 * @param id
	 *            the id
	 * @param faqDTO
	 *            the faq dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@PathVariable("id") Integer id, @RequestBody FaqDTO faqDTO) {
		try {
			Faq faq = faqUtilDTO.toBusiness(faqDTO);
			faqsService.update(faq);
			return new MensajeDTO("Faq creada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido insertar una faq");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una faq");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
	}
}
