package com.upsam.hospital.controller.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javassist.NotFoundException;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.upsam.hospital.controller.dto.AntecedentesPersonalesDTO;
import com.upsam.hospital.controller.dto.AntecedentesRelacionadosPCIDTO;
import com.upsam.hospital.controller.dto.ExploracionDTO;
import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.GrossMotorFunctionDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.ValoracionArticularMuscularDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IAntecedentesPersonalesUtilDTO;
import com.upsam.hospital.controller.dto.util.IAntecedentesRelacionadosPCIUtilDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.dto.util.IGrossMotorFunctionUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.controller.dto.util.IValoracionArticularMuscularUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.GrossMotorFunction;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.ValoracionArticularMuscular;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IAntecedentesPersonalesService;
import com.upsam.hospital.model.service.IAntecedentesRelacionadosPCIService;
import com.upsam.hospital.model.service.IExploracionService;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IGrossMotorFunctionService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IValoracionArticularMuscularService;
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

	/** The antecedentes personales util dto. */
	@Inject
	private IAntecedentesPersonalesUtilDTO antecedentesPersonalesUtilDTO;

	/** The antecedentes personales pci service. */
	@Inject
	private IAntecedentesRelacionadosPCIService antecedentesRelacionadosPCIService;

	/** The antecedentes relacionados pci util dto. */
	@Inject
	private IAntecedentesRelacionadosPCIUtilDTO antecedentesRelacionadosPCIUtilDTO;

	/** The exploracion service. */
	@Inject
	private IExploracionService exploracionService;

	/** The exploracion util dto. */
	@Inject
	private IExploracionUtilDTO exploracionUtilDTO;

	/** The fichero emt service. */
	@Inject
	private IFicheroEMTService ficheroEMTService;

	/** The gross motor function service. */
	@Inject
	private IGrossMotorFunctionService grossMotorFunctionService;

	/** The gross motor function util dto. */
	@Inject
	private IGrossMotorFunctionUtilDTO grossMotorFunctionUtilDTO;

	/** The paciente movil util dto. */
	@Inject
	private IPacienteMovilUtilDTO pacienteMovilUtilDTO;

	/** The paciente service. */
	@Inject
	private IPacienteService pacienteService;

	/** The valoracion articular muscular service. */
	@Inject
	private IValoracionArticularMuscularService valoracionArticularMuscularService;

	/** The valoracion articular muscular util dto. */
	@Inject
	private IValoracionArticularMuscularUtilDTO valoracionArticularMuscularUtilDTO;

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
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/videoreproduce2/{id}", method = RequestMethod.GET)
	public ModelAndView descargarVideo(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Video video = this.videoService.findOne(idPaciente, idExploracion, id);
			// response.setContentType("video/mp4");
			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + video.getNombre() + "\"");
			// ServletOutputStream outStream = response.getOutputStream();
			File file = this.videoService.recuperarVideo(video.getNombre(), idPaciente);
			int fileSize = (int) file.length();
			response.addIntHeader("Content-Length", fileSize);
			response.flushBuffer();
			byte[] buf = new byte[8192];

			InputStream is = new FileInputStream(file);

			OutputStream os = response.getOutputStream();

			// write to out output stream
			while (true) {
				int bytedata = is.read();

				if (bytedata == -1) {
					break;
				}

				os.write(bytedata);
			}

			// flush and close streams.....
			is.close();
			os.flush();
			os.close();

			/*
			 * int c = 0; try { while ((c = is.read(buf, 0, buf.length)) > 0) {
			 * outStream.write(buf, 0, c); } is.close(); } catch (IOException e)
			 * { e.printStackTrace(); } outStream.flush(); outStream.close();
			 * response.flushBuffer();
			 */
		}
		catch (IOException ex) {
			LOG.debug(ex.getMessage());
			throw ex;
		}
		return null;
	}

	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/videoreproduce3/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getPreview1(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id, HttpServletResponse response) throws Exception {
		ResponseEntity<byte[]> result = null;
		try {
			Video video = this.videoService.findOne(idPaciente, idExploracion, id);
			byte[] image = this.videoService.recuperarVideo2(video.getNombre(), idPaciente);

			response.setStatus(HttpStatus.OK.value());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentLength(image.length);
			result = new ResponseEntity<byte[]>(image, headers, HttpStatus.OK);
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return result;
	}

	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/videoreproduce/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void getPreview2(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id, HttpServletResponse response) {
		try {
			Video video = this.videoService.findOne(idPaciente, idExploracion, id);
			File file = this.videoService.recuperarVideo(video.getNombre(), idPaciente);
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
			response.setHeader("Content-Disposition", "attachment; filename=" + file.getName().replace(" ", "_"));
			InputStream iStream = new FileInputStream(file);
			IOUtils.copy(iStream, response.getOutputStream());
			response.flushBuffer();
			iStream.close();
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@Inject
	ServletContext context;

	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/videoreproduce4/{id}", method = RequestMethod.GET)
	public void doDownload(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int BUFFER_SIZE = 4096;
			Video video = this.videoService.findOne(idPaciente, idExploracion, id);
			File downloadFile = this.videoService.recuperarVideo(video.getNombre(), idPaciente);

			String appPath = context.getRealPath("");
			System.out.println("appPath = " + appPath);

			FileInputStream inputStream = new FileInputStream(downloadFile);

			// get MIME type of the file
			String mimeType = context.getMimeType(downloadFile.getPath());
			if (mimeType == null) {
				// set to binary type if MIME mapping not found
				mimeType = "application/octet-stream";
			}
			System.out.println("MIME type: " + mimeType);

			// set content attributes for the response
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			// set headers for the response
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
			response.setHeader(headerKey, headerValue);

			// get output stream of the response
			OutputStream outStream = response.getOutputStream();

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			// write bytes read from the input stream into the output stream
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();
		}
		catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/videoupload", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody
	MensajeDTO videoUpload(@RequestParam("file") MultipartFile file, @PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) throws IOException, DataBaseException {
		try {
			if (file.getSize() > 0) {
				videoService.save(file.getBytes(), idPaciente, idExploracion, "");
			}
			return new MensajeDTO("Video guardado correctamente.", true);
		}
		catch (Exception e) {
			return new MensajeDTO("No se ha podido guardar el vídeo. Vuelva a intentarlo. Si sigue fallando, póngase en contacto con el administrador del sistema", false);
		}
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
	ExploracionDTO getExploracionFromPaciente(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		ExploracionDTO result = null;

		try {
			Exploracion exploracion = this.exploracionService.findOne(idExploracion);
			result = this.exploracionUtilDTO.toRest(exploracion);
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
	 * @param id
	 *            the id
	 * @return the video from paciente
	 */
	@RequestMapping(value = "{idPaciente}/exploracion/{idExploracion}/video/{id}")
	public @ResponseBody
	VideoDTO getVideoFromPaciente(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @PathVariable("id") Integer id) {
		VideoDTO result = null;
		Video video;
		try {
			video = this.videoService.findOne(idPaciente, idExploracion, id);
			result = this.videoUtilDTO.toRest(video);
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		catch (NotFoundException e) {
			LOG.error(e.getMessage());
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
			LOG.debug(e.getMessage());
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
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param antecedentesPersonalesDTO
	 *            the antecedentes personales dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesPersonales", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertAntecedentesPersonales(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @RequestBody AntecedentesPersonalesDTO antecedentesPersonalesDTO) {
		try {
			AntecedentesPersonales antecedentesPersonales = antecedentesPersonalesUtilDTO.toBusiness(antecedentesPersonalesDTO);
			antecedentesPersonalesService.save(antecedentesPersonales);
			AntecedentesPersonalesDTO nuevosAntecedentesDTO = antecedentesPersonalesUtilDTO.toRest(antecedentesPersonales);
			return new MensajeDTO("Antecedentes personales insertados correctamente", true, nuevosAntecedentesDTO);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al insertar los antecedentes personales en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de los antecedentes personales", false);
		}
	}

	/**
	 * Insert antecedentes relacionados pci.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param antecedentesRelacionadosPCIDTO
	 *            the antecedentes relacionados pcidto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesRelacionadosPCI", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertAntecedentesRelacionadosPCI(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @RequestBody AntecedentesRelacionadosPCIDTO antecedentesRelacionadosPCIDTO) {
		try {
			AntecedentesRelacionadosPCI antecedentesRelacionadosPCI = antecedentesRelacionadosPCIUtilDTO.toBusiness(antecedentesRelacionadosPCIDTO);
			antecedentesRelacionadosPCIService.save(antecedentesRelacionadosPCI);
			AntecedentesRelacionadosPCIDTO nuevosAntecedentesDTO = antecedentesRelacionadosPCIUtilDTO.toRest(antecedentesRelacionadosPCI);
			return new MensajeDTO("Los antecedentes relacionados con PCI se han guardado correctamente", true, nuevosAntecedentesDTO);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al insertar los antecedentes relacionados con PCI en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de los antecedentes relacionados con PCI", false);
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
			ExploracionDTO nuevaExploracion = exploracionUtilDTO.toRest(exploracion);
			return new MensajeDTO("Exploracion guardada correctamente", true, nuevaExploracion);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al guardar la exploracion.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de la exploracion", false);
		}
	}

	/**
	 * Insert gross motor function.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param grossMotorFunctionDTO
	 *            the gross motor function dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/grossMotorFunction", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertGrossMotorFunction(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @RequestBody GrossMotorFunctionDTO grossMotorFunctionDTO) {
		try {
			GrossMotorFunction grossMotorFunction = grossMotorFunctionUtilDTO.toBusiness(grossMotorFunctionDTO);
			grossMotorFunctionService.save(grossMotorFunction);
			GrossMotorFunctionDTO nuevoGrossMotorFunctionDTO = grossMotorFunctionUtilDTO.toRest(grossMotorFunction);
			return new MensajeDTO("Gross motor function insertado correctamente", true, nuevoGrossMotorFunctionDTO);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al insertar gross motor function en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de gross motor function", false);
		}
	}

	/**
	 * Insert valoracion articular muscular.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @param valoracionArticularMuscularDTO
	 *            the valoracion articular muscular dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/valoracionArticularMuscular", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertValoracionArticularMuscular(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion, @RequestBody ValoracionArticularMuscularDTO valoracionArticularMuscularDTO) {
		try {
			ValoracionArticularMuscular valoracionArticularMuscular = valoracionArticularMuscularUtilDTO.toBusiness(valoracionArticularMuscularDTO);
			valoracionArticularMuscularService.save(valoracionArticularMuscular);
			ValoracionArticularMuscularDTO nuevaValoracionArticularMuscularDTO = valoracionArticularMuscularUtilDTO.toRest(valoracionArticularMuscular);
			return new MensajeDTO("La valoracion articular muscular se ha guardado correctamente", true, nuevaValoracionArticularMuscularDTO);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al insertar la valoracion articular muscular en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion en la valoracion articular muscular", false);
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
	 * @param idExploracion
	 *            the id exploracion
	 * @return the antecedentes personales dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesPersonales", method = RequestMethod.GET)
	public @ResponseBody
	AntecedentesPersonalesDTO retrieveAntecedentesPersonales(@PathVariable("idExploracion") Integer idExploracion) {
		AntecedentesPersonalesDTO antecedentesPersonalesDTO = null;
		try {
			AntecedentesPersonales antecedentesPersonales = antecedentesPersonalesService.findByExploracion(idExploracion);
			if (antecedentesPersonales != null) {
				antecedentesPersonalesDTO = antecedentesPersonalesUtilDTO.toRest(antecedentesPersonales);
			}
			else {
				antecedentesPersonalesDTO = new AntecedentesPersonalesDTO();
			}
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
	 * Retrieve antecedentes personales pci.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @return the antecedentes personales pcidto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesRelacionadosPCI", method = RequestMethod.GET)
	public @ResponseBody
	AntecedentesRelacionadosPCIDTO retrieveAntecedentesRelacionadosPCI(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		AntecedentesRelacionadosPCIDTO antecedentesRelacionadosPCIDTO = null;
		try {
			AntecedentesRelacionadosPCI antecedentesRelacionadosPCI = antecedentesRelacionadosPCIService.findByExploracion(idExploracion);
			if (antecedentesRelacionadosPCI != null) {
				antecedentesRelacionadosPCIDTO = antecedentesRelacionadosPCIUtilDTO.toRest(antecedentesRelacionadosPCI);
			}
			else {
				antecedentesRelacionadosPCIDTO = new AntecedentesRelacionadosPCIDTO();
			}
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return antecedentesRelacionadosPCIDTO;
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
	 * Retrieve gross motor function.
	 * 
	 * @param idExploracion
	 *            the id exploracion
	 * @return the gross motor function dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/grossMotorFunction", method = RequestMethod.GET)
	public @ResponseBody
	GrossMotorFunctionDTO retrieveGrossMotorFunction(@PathVariable("idExploracion") Integer idExploracion) {
		GrossMotorFunctionDTO grossMotorFunctionDTO = null;
		try {
			GrossMotorFunction grossMotorFunction = grossMotorFunctionService.findByExploracion(idExploracion);
			if (grossMotorFunction != null) {
				grossMotorFunctionDTO = grossMotorFunctionUtilDTO.toRest(grossMotorFunction);
			}
			else {
				grossMotorFunctionDTO = new GrossMotorFunctionDTO();
			}
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return grossMotorFunctionDTO;
	}

	/**
	 * Retrieve valoracion articular muscular.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param idExploracion
	 *            the id exploracion
	 * @return the valoracion articular muscular dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/valoracionArticularMuscular", method = RequestMethod.GET)
	public @ResponseBody
	ValoracionArticularMuscularDTO retrieveValoracionArticularMuscular(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		ValoracionArticularMuscularDTO valoracionArticularMuscularDTO = null;
		try {
			ValoracionArticularMuscular valoracionArticularMuscular = valoracionArticularMuscularService.findByExploracion(idExploracion);
			if (valoracionArticularMuscular != null) {
				valoracionArticularMuscularDTO = valoracionArticularMuscularUtilDTO.toRest(valoracionArticularMuscular);
			}
			else {
				valoracionArticularMuscularDTO = new ValoracionArticularMuscularDTO();
			}
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return valoracionArticularMuscularDTO;
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
			LOG.debug(e.getMessage());
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
			AntecedentesPersonales antecedentesPersonales = antecedentesPersonalesUtilDTO.toBusiness(antecedentesPersonalesDTO);
			antecedentesPersonalesService.update(antecedentesPersonales);
			return new MensajeDTO("Antecedentes personales actualizados correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al actualizar los antecedentes personales en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de los antecedentes personales", false);
		}
	}

	/**
	 * Update antecedentes relacionados pci.
	 * 
	 * @param id
	 *            the id
	 * @param antecedentesRelacionadosPCIDTO
	 *            the antecedentes relacionados pcidto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/antecedentesRelacionadosPCI/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateAntecedentesRelacionadosPCI(@PathVariable("id") Integer id, @RequestBody AntecedentesRelacionadosPCIDTO antecedentesRelacionadosPCIDTO) {
		try {
			AntecedentesRelacionadosPCI antecedentesRelacionadosPCI = antecedentesRelacionadosPCIUtilDTO.toBusiness(antecedentesRelacionadosPCIDTO);
			antecedentesRelacionadosPCIService.update(antecedentesRelacionadosPCI);
			return new MensajeDTO("Antecedentes personales PCI actualizados correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al actualizar los antecedentes personales PCI en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de los antecedentes personales PCI", false);
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
			ExploracionDTO nuevaExploracion = exploracionUtilDTO.toRest(exploracion);
			return new MensajeDTO("Exploracion actualizada correctamente", true, nuevaExploracion);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al insertar la exploracion en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de la exploracion", false);
		}
	}

	/**
	 * Update gross motor function.
	 * 
	 * @param id
	 *            the id
	 * @param grossMotorFunctionDTO
	 *            the gross motor function dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/grossMotorFunction/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateGrossMotorFunction(@PathVariable("id") Integer id, @RequestBody GrossMotorFunctionDTO grossMotorFunctionDTO) {
		try {
			GrossMotorFunction grossMotorFunction = grossMotorFunctionUtilDTO.toBusiness(grossMotorFunctionDTO);
			grossMotorFunctionService.update(grossMotorFunction);
			return new MensajeDTO("Gross motor function actualizado correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al actualizar gross motor function en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de gross motor function", false);
		}
	}

	/**
	 * Update valoracion articular muscular.
	 * 
	 * @param id
	 *            the id
	 * @param valoracionArticularMuscularDTO
	 *            the valoracion articular muscular dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{idPaciente}/exploracion/{idExploracion}/valoracionArticularMuscular/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO updateValoracionArticularMuscular(@PathVariable("id") Integer id, @RequestBody ValoracionArticularMuscularDTO valoracionArticularMuscularDTO) {
		try {
			ValoracionArticularMuscular valoracionArticularMuscular = valoracionArticularMuscularUtilDTO.toBusiness(valoracionArticularMuscularDTO);
			valoracionArticularMuscularService.update(valoracionArticularMuscular);
			return new MensajeDTO("Valoracion articular muscular actualizada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error al actualizar la valoracion articular muscular en base de datos.", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			return new MensajeDTO("Error de conversion de la Valoracion articular muscular", false);
		}
	}
}
