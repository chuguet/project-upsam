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
import com.upsam.hospital.controller.dto.ParteCuerpoDTO;
import com.upsam.hospital.controller.dto.SintomaDTO;
import com.upsam.hospital.controller.dto.util.IFaqUtilDTO;
import com.upsam.hospital.controller.dto.util.IParteCuerpoUtilDTO;
import com.upsam.hospital.controller.dto.util.ISintomaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.beans.ParteCuerpo;
import com.upsam.hospital.model.beans.Sintoma;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFaqService;
import com.upsam.hospital.model.service.IParteCuerpoService;
import com.upsam.hospital.model.service.ISintomaService;

// TODO: Auto-generated Javadoc
/**
 * The Class FAQsController.
 */
@Controller
public class FaqController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(FaqController.class);

	/** The faqs service. */
	@Inject
	private IFaqService faqService;

	/** The faq util dto. */
	@Inject
	private IFaqUtilDTO faqUtilDTO;

	/** The parte cuerpo service. */
	@Inject
	private IParteCuerpoService parteCuerpoService;

	/** The parte cuerpo util dto. */
	@Inject
	private IParteCuerpoUtilDTO parteCuerpoUtilDTO;

	/** The sintoma service. */
	@Inject
	private ISintomaService sintomaService;

	/** The sintoma util dto. */
	@Inject
	private ISintomaUtilDTO sintomaUtilDTO;

	/**
	 * Insert.
	 * 
	 * @param faqDTO
	 *            the faq dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "partecuerpo/{idParteCuerpo}/sintoma/{idSintoma}/faq", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertFaq(@RequestBody FaqDTO faqDTO) {
		try {
			Faq faq = faqUtilDTO.toBusiness(faqDTO);
			faqService.save(faq);
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
	 * Insert parte cuerpo.
	 * 
	 * @param parteCuerpoDTO
	 *            the parte cuerpo dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "partecuerpo", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertParteCuerpo(@RequestBody ParteCuerpoDTO parteCuerpoDTO) {
		try {
			ParteCuerpo parteCuerpo = parteCuerpoUtilDTO.toBusiness(parteCuerpoDTO);
			parteCuerpoService.save(parteCuerpo);
			return new MensajeDTO("Faq creada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido insertar una parte del cuerpo");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una parte del cuerpo");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	/**
	 * Insert sintoma.
	 * 
	 * @param sintomaDTO
	 *            the sintoma dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "partecuerpo/{idParteCuerpo}/sintoma", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertSintoma(@RequestBody SintomaDTO sintomaDTO) {
		try {
			Sintoma sintoma = sintomaUtilDTO.toBusiness(sintomaDTO);
			sintomaService.save(sintoma);
			return new MensajeDTO("Sintoma creado correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido insertar un sintoma");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir un sintoma");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(value = "partecuerpo", method = RequestMethod.GET)
	public List<ParteCuerpoDTO> listAll() {
		List<ParteCuerpoDTO> partesCuerpoDTO = new ArrayList<ParteCuerpoDTO>();
		List<ParteCuerpo> partesCuerpo;
		ParteCuerpoDTO parteCuerpoDTO;
		try {
			partesCuerpo = parteCuerpoService.findAll();
			for (ParteCuerpo parteCuerpo : partesCuerpo) {
				parteCuerpoDTO = parteCuerpoUtilDTO.toRest(parteCuerpo);
				partesCuerpoDTO.add(parteCuerpoDTO);
			}
		}
		catch (DataBaseException e) {
			LOG.info("No se ha podido recuperar todas las partes del cuerpo");
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una parte del cuerpo");
			LOG.error(e.getMessage());
		}
		return partesCuerpoDTO;
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the faq dto
	 */
	@RequestMapping(value = "partecuerpo/{idParteCuerpo}/sintoma/{idSintoma}/faq/{id}", method = RequestMethod.GET)
	public FaqDTO retrieveFaq(@PathVariable("id") Integer id) {
		FaqDTO faqDTO = null;
		Faq faq;
		try {
			faq = faqService.findOne(id);
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
	 * Retrieve parte cuerpo.
	 * 
	 * @param id
	 *            the id
	 * @return the parte cuerpo dto
	 */
	@RequestMapping(value = "partecuerpo/{id}", method = RequestMethod.GET)
	public ParteCuerpoDTO retrieveParteCuerpo(@PathVariable("id") Integer id) {
		ParteCuerpoDTO parteCuerpoDTO = null;
		ParteCuerpo parteCuerpo;
		try {
			parteCuerpo = parteCuerpoService.findOne(id);
			parteCuerpoDTO = parteCuerpoUtilDTO.toRest(parteCuerpo);
		}
		catch (DataBaseException e) {
			LOG.error("Error al recuperar una faq");
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una faq");
			LOG.error(e.getMessage());
		}
		return parteCuerpoDTO;
	}

	/**
	 * Retrieve sintoma.
	 * 
	 * @param id
	 *            the id
	 * @return the sintoma dto
	 */
	@RequestMapping(value = "partecuerpo/{idParteCuerpo}/sintoma/{id}", method = RequestMethod.GET)
	public SintomaDTO retrieveSintoma(@PathVariable("id") Integer id) {
		SintomaDTO sintomaDTO = null;
		Sintoma sintoma;
		try {
			sintoma = sintomaService.findOne(id);
			sintomaDTO = sintomaUtilDTO.toRest(sintoma);
		}
		catch (DataBaseException e) {
			LOG.error("Error al recuperar un sintoma");
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir un sintoma");
			LOG.error(e.getMessage());
		}
		return sintomaDTO;
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
	@RequestMapping(value = "partecuerpo/{idParteCuerpo}/sintoma/{idSintoma}/faq/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateFaq(@PathVariable("id") Integer id, @RequestBody FaqDTO faqDTO) {
		try {
			Faq faq = faqUtilDTO.toBusiness(faqDTO);
			faqService.update(faq);
			return new MensajeDTO("Faq actualiada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido actualizar una faq");
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
	 * Update parte cuerpo.
	 * 
	 * @param id
	 *            the id
	 * @param parteCuerpoDTO
	 *            the parte cuerpo dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "partecuerpo/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateParteCuerpo(@PathVariable("id") Integer id, @RequestBody ParteCuerpoDTO parteCuerpoDTO) {
		try {
			ParteCuerpo parteCuerpo = parteCuerpoUtilDTO.toBusiness(parteCuerpoDTO);
			parteCuerpoService.update(parteCuerpo);
			return new MensajeDTO("Parte del cuerpo creada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido insertar una faq");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido convertir una parte del cuerpo");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	/**
	 * Update sintoma.
	 * 
	 * @param id
	 *            the id
	 * @param sintomaDTO
	 *            the sintoma dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "partecuerpo/{idParteCuerpo}/sintoma/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateSintoma(@PathVariable("id") Integer id, @RequestBody SintomaDTO sintomaDTO) {
		try {
			Sintoma sintoma = sintomaUtilDTO.toBusiness(sintomaDTO);
			sintomaService.update(sintoma);
			return new MensajeDTO("Sintoma actualizado correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.error("No se ha podido actualizar un sintoma");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
		catch (TransferObjectException e) {
			LOG.error("No se ha podido actualizar un sintoma");
			LOG.error(e.getMessage());
			return new MensajeDTO(e.getMessage(), false);
		}
	}
}
