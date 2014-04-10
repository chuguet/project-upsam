package com.upsam.hospital.controller.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javassist.NotFoundException;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IVideoService;

@Controller
@RequestMapping("/pacientemovil")
public class PacienteMovilController {

	private final static Log LOG = LogFactory.getLog(PacienteMovilController.class);
	@Inject
	private IPacienteService pacienteService;

	@Inject
	private IPacienteMovilUtilDTO pacienteMovilUtilDTO;

	@Inject
	private IVideoService videoService;

	@Inject
	private IVideoUtilDTO videoUtilDTO;

	@Inject
	private IPacienteUtilDTO pacienteUtilDTO;

	/** The fichero emt service. */
	@Inject
	private IFicheroEMTService ficheroEMTService;

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

	@RequestMapping(value = "{idPaciente}/video")
	public @ResponseBody
	List<VideoDTO> getAllVideosFromPaciente(@PathVariable("idPaciente") Integer idPaciente) {
		List<VideoDTO> result = new ArrayList<VideoDTO>();
		try {
			Paciente paciente = pacienteService.findOne(idPaciente);
			result.addAll(pacienteUtilDTO.getVideosList(paciente.getVideos()));
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "{idPaciente}/video/{id}")
	public @ResponseBody
	VideoDTO getVideoFromPaciente(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("id") Integer id) {
		VideoDTO result = null;
		Video video;
		try {
			video = this.videoService.findOne(idPaciente, id);
			result = this.videoUtilDTO.toRest(video);
		}
		catch (DataBaseException | NotFoundException e1) {
			e1.printStackTrace();
		}
		catch (TransferObjectException e) {
			LOG.error(e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "{idPaciente}/videoreproduce/{id}", method = RequestMethod.GET)
	public ModelAndView descargarVideo(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Video video = this.videoService.findOne(idPaciente, id);
			response.setContentType("video/mp4");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + video.getNombre() + "\"");
			ServletOutputStream outStream = response.getOutputStream();
			this.videoService.recuperarVideo(outStream, video.getNombre(), idPaciente);

			outStream.flush();
			outStream.close();
			response.flushBuffer();
		}
		catch (IOException ex) {
			throw ex;
		}
		return null;
	}

	/**
	 * Fichero emt.
	 * 
	 * @param id
	 *            the id
	 * @return the fichero emtdto
	 */
	@RequestMapping(value = "{idPaciente}/ficheroEMT/{id}")
	public @ResponseBody
	FicheroEMTDTO ficheroEMT(@PathVariable("id") Integer id) {
		FicheroEMTDTO result = null;
		try {
			FicheroEMT ficheroEMT = ficheroEMTService.findOne(id);
			result = pacienteUtilDTO.fileEMTToDTO(ficheroEMT);
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Ficheros emt info.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	@RequestMapping(value = "{id}/ficherosEMT")
	public @ResponseBody
	List<FicheroEMTInfoDTO> ficherosEMTInfo(@PathVariable("id") Integer id) {
		List<FicheroEMTInfoDTO> result = new ArrayList<FicheroEMTInfoDTO>();
		try {
			List<FicheroEMT> ficherosEMT = ficheroEMTService.findByPaciente(id);
			result.addAll(pacienteUtilDTO.getFicherosEMTInfoList(ficherosEMT));
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}
}
