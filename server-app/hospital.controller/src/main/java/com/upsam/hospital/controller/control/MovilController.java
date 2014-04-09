package com.upsam.hospital.controller.control;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IPacienteService;

@Controller
@RequestMapping("/pacientem")
public class MovilController {

	private final static Log LOG = LogFactory.getLog(MovilController.class);
	@Inject
	private IPacienteService pacienteService;

	@Inject
	private IPacienteMovilUtilDTO pacienteMovilUtilDTO;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<PacienteMovilDTO> listAll(@RequestParam("param") String param) {
		List<PacienteMovilDTO> pacientesMovilDTO = new ArrayList<PacienteMovilDTO>();
		PacienteMovilDTO pacienteMovilDTO;
		try {
			List<Paciente> pacientes = pacienteService.findByIdNameSurname(param);

			for (Paciente paciente : pacientes) {
				pacienteMovilDTO = pacienteMovilUtilDTO.toRestMovil(paciente);
				pacientesMovilDTO.add(pacienteMovilDTO);
			}
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return pacientesMovilDTO;
	}
}
