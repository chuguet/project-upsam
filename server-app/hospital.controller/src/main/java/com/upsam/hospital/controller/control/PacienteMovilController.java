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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IAntecedentesPersonalesService;
import com.upsam.hospital.model.service.IExploracionService;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IVideoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteMovilController.
 */
@Controller
@RequestMapping("/pacientemovil")
public class PacienteMovilController {

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(PacienteMovilController.class);

	/** The antecedentes personales service. */
	@Inject
	private IAntecedentesPersonalesService antecedentesPersonalesService;

	/** The exploracion service. */
	@Inject
	private IExploracionService exploracionService;

	/** The exploracion util dto. */
	@Inject
	private IExploracionUtilDTO exploracionUtilDTO;

	/** The fichero emt service. */
	@Inject
	private IFicheroEMTService ficheroEMTService;

	/** The paciente movil util dto. */
	@Inject
	private IPacienteMovilUtilDTO pacienteMovilUtilDTO;

	/** The paciente service. */
	@Inject
	private IPacienteService pacienteService;

	/** The video service. */
	@Inject
	private IVideoService videoService;

	/** The video util dto. */
	@Inject
	private IVideoUtilDTO videoUtilDTO;

	/**
	 * Descargar video.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param id
	 *            the id
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the model and view
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/videoreproduce/{id}", method = RequestMethod.GET)
	public ModelAndView descargarVideo(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Video video = this.videoService.findOne(idPaciente, idExploracion, id);
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
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/ficheroEMT/{id}")
	public @ResponseBody
	FicheroEMTDTO ficheroEMT(@PathVariable("id") Integer id) {
		FicheroEMTDTO result = null;
		try {
			FicheroEMT ficheroEMT = ficheroEMTService.findOneUnique(id);
			result = exploracionUtilDTO.fileEMTToDTO(ficheroEMT);
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Ficheros emt info.
	 * 
	 * @param idExploracion
	 *            the id exploracion
	 * @return the list
	 */
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/ficherosEMT")
	public @ResponseBody
	List<FicheroEMTInfoDTO> ficherosEMTInfo(@PathVariable("idExploracion") Integer idExploracion) {
		List<FicheroEMTInfoDTO> result = new ArrayList<FicheroEMTInfoDTO>();
		try {
			List<FicheroEMT> ficherosEMT = ficheroEMTService.findByExploracion(idExploracion);
			result.addAll(exploracionUtilDTO.getFicherosEMTInfoList(ficherosEMT));
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Gets the all videos from paciente.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @return the all videos from paciente
	 */
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/video")
	public @ResponseBody
	List<VideoDTO> getAllVideosFromPaciente(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		List<VideoDTO> result = new ArrayList<VideoDTO>();
		try {
			Exploracion exploracion = exploracionService.findOne(idExploracion);
			result.addAll(videoUtilDTO.getVideosList(exploracion.getVideos()));
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	/**
	 * Gets the video from paciente.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @return the video from paciente
	 */
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion/}")
	public @ResponseBody
	ExploracionDTO getVideoFromPaciente(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		ExploracionDTO result = null;

		try {
			Exploracion exploracion = this.exploracionService.findOne(idExploracion);
			result = this.exploracionUtilDTO.toRest(exploracion);
		}
		catch (DataBaseException e1) {
			e1.printStackTrace();
		}
		catch (TransferObjectException e) {
			LOG.error(e.getMessage());
		}

		return result;
	}

	/**
	 * Gets the video from paciente.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param id
	 *            the id
	 * @return the video from paciente
	 */
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion/}video/{id}")
	public @ResponseBody
	VideoDTO getVideoFromPaciente(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id) {
		VideoDTO result = null;
		Video video;
		try {
			video = this.videoService.findOne(idPaciente, idExploracion, id);
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

	/**
	 * Insert.
	 * 
	 * @param pacienteMovilDTO
	 *            the paciente movil dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody PacienteMovilDTO pacienteMovilDTO) {
		try {
			Paciente paciente = pacienteMovilUtilDTO.toBusiness(pacienteMovilDTO);
			pacienteService.save(paciente);
			return new MensajeDTO("Paciente creado correctamente", true, paciente);
		}
		catch (DataBaseException e) {
			return new MensajeDTO(new StringBuffer("Ya existe el paciente con el numero de identificacion ").append(pacienteMovilDTO.getNumeroIdentificacion()).append(" en base de datos.").toString(), false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion del paciente", false);
		}
	}

	/**
	 * Insert antecedentes personales.
	 * 
	 * @param idExploracion
	 *            the id exploracion
	 * @param antecedentesPersonalesDTO
	 *            the antecedentes personales dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesPersonales", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertAntecedentesPersonales(@PathVariable("idExploracion") Integer idExploracion, @RequestBody AntecedentesPersonalesDTO antecedentesPersonalesDTO) {
		try {
			AntecedentesPersonales antecedentesPersonales = exploracionUtilDTO.toBusiness(antecedentesPersonalesDTO);
			antecedentesPersonalesService.save(antecedentesPersonales);
			return new MensajeDTO("Antecedentes personales insertados correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al insertar los antecedentes personales en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de los antecedentes personales", false);
		}
	}

	/**
	 * Insert exploracion.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param exploracionDTO
	 *            the exploracion dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertExploracion(@PathVariable("idPaciente") Integer idPaciente, @RequestBody ExploracionDTO exploracionDTO) {
		try {
			Exploracion exploracion = exploracionUtilDTO.toBusiness(exploracionDTO);
			exploracion.setPaciente(new Paciente(idPaciente));
			exploracionService.save(exploracion);
			return new MensajeDTO("Exploracion insertada correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al insertar la exploracion en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de la exploracion", false);
		}
	}

	/**
	 * List all.
	 * 
	 * @param param
	 *            the param
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<PacienteMovilDTO> listAll(@RequestParam("param") String param) {
		List<PacienteMovilDTO> pacientesMovilDTO = new ArrayList<PacienteMovilDTO>();
		PacienteMovilDTO pacienteMovilDTO;
		try {
			List<Paciente> pacientes = pacienteService.findByIdNameSurname(param);

			for (Paciente paciente : pacientes) {
				pacienteMovilDTO = pacienteMovilUtilDTO.toRest(paciente);
				pacientesMovilDTO.add(pacienteMovilDTO);
			}
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return pacientesMovilDTO;
	}

	/**
	 * Retrieve exploraciones.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @return the list
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion", method = RequestMethod.GET)
	public @ResponseBody
	List<ExploracionDTO> listAllExploraciones(@PathVariable("idPaciente") Integer idPaciente) {
		List<ExploracionDTO> exploracionesDTO = new ArrayList<ExploracionDTO>();
		ExploracionDTO exploracionDTO;
		try {
			List<Exploracion> exploraciones = exploracionService.findReducedListByPatient(idPaciente);
			for (Exploracion exploracion : exploraciones) {
				exploracionDTO = exploracionUtilDTO.toRest(exploracion);
				exploracionesDTO.add(exploracionDTO);
			}
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return exploracionesDTO;
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the paciente movil dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	PacienteMovilDTO retrieve(@PathVariable("id") Integer id) {
		PacienteMovilDTO pacienteMovilDTO = new PacienteMovilDTO();
		try {
			Paciente paciente = pacienteService.findOneUnique(id);
			pacienteMovilDTO = pacienteMovilUtilDTO.toRest(paciente);
		}
		catch (DataBaseException e) {
			LOG.info(new StringBuffer("No existe el paciente con el numero de identificacion ").append(pacienteMovilDTO.getNumeroIdentificacion()).append(" en base de datos.").toString());
		}
		return pacienteMovilDTO;
	}

	/**
	 * Retrieve antecedentes personales.
	 * 
	 * @param id
	 *            the id
	 * @return the antecedentes personales dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesPersonales", method = RequestMethod.GET)
	public @ResponseBody
	AntecedentesPersonalesDTO retrieveAntecedentesPersonales(@PathVariable("idExploracion") Integer idExploracion) {
		AntecedentesPersonalesDTO antecedentesPersonalesDTO = null;
		try {
			AntecedentesPersonales antecedentesPersonales = antecedentesPersonalesService.findByExploracion(idExploracion);
			antecedentesPersonalesDTO = exploracionUtilDTO.toRest(antecedentesPersonales);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return antecedentesPersonalesDTO;
	}

	/**
	 * Retrieve exploracion.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @return the exploracion dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}", method = RequestMethod.GET)
	public @ResponseBody
	ExploracionDTO retrieveExploracion(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		ExploracionDTO exploracionDTO = null;
		try {
			Exploracion exploracion = exploracionService.findOneUnique(idExploracion);
			exploracionDTO = exploracionUtilDTO.toRest(exploracion);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return exploracionDTO;
	}

	/**
	 * Update.
	 * 
	 * @param pacienteMovilDTO
	 *            the paciente movil dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody PacienteMovilDTO pacienteMovilDTO) {
		try {
			Paciente paciente = pacienteMovilUtilDTO.toBusiness(pacienteMovilDTO);
			pacienteService.update(paciente);
			return new MensajeDTO("Paciente modificado correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al actualizar el paciente en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion del paciente", false);
		}
	}

	/**
	 * Update antecedentes personales.
	 * 
	 * @param id
	 *            the id
	 * @param antecedentesPersonalesDTO
	 *            the antecedentes personales dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesPersonales/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateAntecedentesPersonales(@PathVariable("id") Integer id, @RequestBody AntecedentesPersonalesDTO antecedentesPersonalesDTO) {
		try {
			AntecedentesPersonales antecedentesPersonales = exploracionUtilDTO.toBusiness(antecedentesPersonalesDTO);
			antecedentesPersonalesService.update(antecedentesPersonales);
			return new MensajeDTO("Antecedentes personales actualizados correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al actualizar los antecedentes personales en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de los antecedentes personales", false);
		}
	}

	/**
	 * Update exploracion.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param exploracionDTO
	 *            the exploracion dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateExploracion(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @RequestBody ExploracionDTO exploracionDTO) {
		try {
			Exploracion exploracion = exploracionUtilDTO.toBusiness(exploracionDTO);
			exploracion.setPaciente(new Paciente(idPaciente));
			exploracionService.update(exploracion);
			return new MensajeDTO("Exploracion insertada correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al insertar la exploracion en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de la exploracion", false);
		}
	}
}
