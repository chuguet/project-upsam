package com.upsam.hospital.controller.control;

import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IExploracionService;

// TODO: Auto-generated Javadoc
/**
 * The Class FaqController.
 */
@Controller
@RequestMapping("/pacientemovil")
public class FaqController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(FaqController.class);

	/** The exploracion service. */
	@Inject
	private IExploracionService exploracionService;

	/** The exploracion util dto. */
	@Inject
	private IExploracionUtilDTO exploracionUtilDTO;

	/**
	 * Retrieve faq.
	 * 
	 * @param idExploracion
	 *            the id exploracion
	 * @return the faq dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/faq", method = RequestMethod.GET)
	public @ResponseBody
	FaqDTO retrieveFaq(@PathVariable("idExploracion") Integer idExploracion) {
		FaqDTO faqDTO = null;
		try {
			Exploracion exploracion = exploracionService.findOne(idExploracion);
			faqDTO = exploracionUtilDTO.doFaq(exploracion);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return faqDTO;
	}

}
