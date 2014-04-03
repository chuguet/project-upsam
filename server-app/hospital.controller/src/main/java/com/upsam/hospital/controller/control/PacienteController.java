package com.upsam.hospital.controller.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javassist.NotFoundException;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.jaxb.EmxDataFile;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IFicheroMDXService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IVideoService;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteController.
 */
@Controller
@RequestMapping("/paciente")
public class PacienteController {

	private final static Log LOG = LogFactory.getLog(PacienteController.class);

	private static final String MDX_FILE = ".mdx";
	private static final String EMT_FILE = ".emt";

	/** The usuario service. */
	@Inject
	private IPacienteService pacienteService;

	@Inject
	private IFicheroMDXService ficheroMDXService;

	@Inject
	private IFicheroEMTService ficheroEMTService;

	/** The paciente util dto. */
	@Inject
	private IPacienteUtilDTO pacienteUtilDTO;

	@Inject
	private IVideoService videoService;

	@Inject
	private IVideoUtilDTO videoUtilDTO;

	/**
	 * Creates the form.
	 * 
	 * @param operacion
	 *            the operacion
	 * @param uiModel
	 *            the ui model
	 * @return the string
	 */
	@RequestMapping(value = "/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion, final Model uiModel) {
		uiModel.addAttribute("operacion", operacion);
		if (!operacion.equals("list")) {
			operacion = "form";
		}
		return new StringBuffer("paciente/").append(operacion).toString();
	}

	/**
	 * Insert the user.
	 * 
	 * @param pacienteDTO
	 *            the paciente dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody PacienteDTO pacienteDTO) {
		if (pacienteDTO == null) {
			return new MensajeDTO("Un paciente es requerido", false);
		}
		try {
			Paciente paciente = pacienteUtilDTO.toBusiness(pacienteDTO);
			pacienteService.save(paciente);
			return new MensajeDTO("Paciente creado correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO(new StringBuffer("Ya existe el paciente con el numero de identificacion ").append(pacienteDTO.getNumeroIdentificacion()).append(" en base de datos.").toString(), false);
		}
		catch (TransferObjectException e) {
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	/**
	 * List all users.
	 * 
	 * @return the list
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<PacienteDTO> listAll() {
		List<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>();
		try {
			List<Paciente> pacientes = this.pacienteService.findAll();

			for (Paciente paciente : pacientes) {
				PacienteDTO e = pacienteUtilDTO.toRest(paciente);
				pacientesDTO.add(e);
			}
		}
		catch (DataBaseException e) {

		}
		catch (TransferObjectException e) {

		}
		return pacientesDTO;
	}

	/**
	 * Removes the user by id.
	 * 
	 * @param id
	 *            the id
	 * @param uiModel
	 *            the ui model
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	MensajeDTO remove(@PathVariable Integer id, Model uiModel) {
		if (id == null) {
			return new MensajeDTO("Un paciente es requerido", false);
		}
		try {
			Paciente paciente = new Paciente();
			paciente.setId(id);
			this.pacienteService.delete(paciente);
			return new MensajeDTO("Paciente eliminado correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	/**
	 * Retrieve one User.
	 * 
	 * @param id
	 *            the id
	 * @return the usuario dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	PacienteDTO retrieve(@PathVariable("id") Integer id) {
		PacienteDTO pacienteDTO = new PacienteDTO();
		try {
			Paciente paciente = pacienteService.findOne(id);
			pacienteDTO = pacienteUtilDTO.toRest(paciente);
		}
		catch (TransferObjectException e) {

		}
		catch (DataBaseException e) {

		}
		return pacienteDTO;
	}

	/**
	 * Update the user.
	 * 
	 * @param pacienteDTO
	 *            the paciente dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody PacienteDTO pacienteDTO) {
		if (pacienteDTO == null) {
			return new MensajeDTO("Un paciente es requerido", false);
		}
		try {
			Paciente paciente = pacienteUtilDTO.toBusiness(pacienteDTO);
			pacienteService.update(paciente);
			return new MensajeDTO("Paciente modificado correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al actualizar el paciente en base de datos.", false);
		}
		catch (TransferObjectException e) {
			return new MensajeDTO(e.getMessage(), false);
		}
	}

	@Inject
	private ServletContext servletContext;

	@RequestMapping(value = "/fileUpload/{id}", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody
	MensajeDTO fileUpload(@RequestParam("file") MultipartFile file, @PathVariable("id") Integer id) {
		MensajeDTO result = null;
		Date now = new Date();
		Paciente paciente;
		try {
			if (file.getSize() > 0) {
				File folder = new File(servletContext.getRealPath(new StringBuffer("/resources/files/PACIENTE_").append(id).toString()));
				if (!folder.exists()) {
					folder.mkdir();
				}
				File uploadedFile = new File(new StringBuffer(folder.getAbsolutePath()).append("/").append(now.getTime()).append("_").append(file.getOriginalFilename()).toString());
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(file.getBytes());
				fos.close();
				if (uploadedFile.getName().toLowerCase().contains(EMT_FILE)) {
					paciente = pacienteService.findOne(id);
					FicheroEMT ficheroEMT = ficheroEMTService.fileReaderEMT(uploadedFile, paciente);
					paciente.addFicheroEMT(ficheroEMT);
					if (uploadedFile.delete()) {
						pacienteService.update(paciente);
						result = new MensajeDTO("Archivo subido correctamente.", true);
					}
					else {
						result = new MensajeDTO("Error al borrar el archivo.", false);
					}
				}
				else if (uploadedFile.getName().toLowerCase().contains(MDX_FILE)) {
					paciente = pacienteService.findOne(id);
					FicheroMDX ficheroMDX = new FicheroMDX();
					ficheroMDX.setFecha(now.getTime());
					ficheroMDX.setNombre(file.getOriginalFilename());
					ficheroMDX.setPaciente(paciente);
					paciente.addFicheroMDX(ficheroMDX);
					pacienteService.update(paciente);
					result = new MensajeDTO("Archivo subido correctamente.", true);
				}
				else {
					uploadedFile.delete();
					result = new MensajeDTO("Extension de archivo incorrecto.", false);
				}
			}
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
			result = new MensajeDTO("El paciente asociado al fichero no existe.", false);
		}
		catch (IOException e) {
			LOG.error(e.getMessage());
			result = new MensajeDTO("El fichero esta en un formato incorrecto.", false);
		}
		return result;
	}

	@RequestMapping(value = "{id}/ficherosMDX")
	public @ResponseBody
	List<FicheroMDXInfoDTO> ficherosMDXInfo(@PathVariable("id") Integer id) {
		List<FicheroMDXInfoDTO> result = new ArrayList<FicheroMDXInfoDTO>();
		try {
			Paciente paciente = pacienteService.findOne(id);
			result.addAll(pacienteUtilDTO.getFicherosMDXInfoList(paciente.getFicheroMDX()));
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "{id}/ficherosEMT")
	public @ResponseBody
	List<FicheroMDXInfoDTO> ficherosEMTInfo(@PathVariable("id") Integer id) {
		List<FicheroMDXInfoDTO> result = new ArrayList<FicheroMDXInfoDTO>();
		try {
			Paciente paciente = pacienteService.findOne(id);
			result.addAll(pacienteUtilDTO.getFicherosMDXInfoList(paciente.getFicheroMDX()));
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "{idPaciente}/ficheroMDX/{id}")
	public @ResponseBody
	FicheroMDXDTO ficheroMDXInfo(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("id") Integer id) {
		FicheroMDXDTO result = null;
		try {
			FicheroMDX ficheroMDX = ficheroMDXService.findOne(id);
			File file = new File(new StringBuffer(servletContext.getRealPath("/resources/files/PACIENTE_")).append(idPaciente).append("/").append(ficheroMDX.getFecha()).append("_").append(ficheroMDX.getNombre()).toString());
			EmxDataFile emxDataFile = ficheroMDXService.fileReaderMDX(file);
			result = pacienteUtilDTO.fileMDXToDTO(emxDataFile);
		}
		catch (DataBaseException e) {
			LOG.error(e.getMessage());
		}
		catch (JAXBException e) {
			LOG.error(e.getMessage());
		}
		catch (IOException e) {
			LOG.error(e.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "{id}/videoUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody
	MensajeDTO videoUpload(@RequestParam("file") MultipartFile file, @PathVariable("id") Integer id) throws IOException, DataBaseException {
		if (file.getSize() > 0) {
			videoService.save(file.getBytes(), id);
		}
		return new MensajeDTO("Video guardado correctamente.", true);
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
			// TODO Auto-generated catch block
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

	@RequestMapping(value = "{idPaciente}/videoReproduce/{id}", method = RequestMethod.GET)
	public ModelAndView informeExcel(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
}
