package com.upsam.hospital.controller.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletContext;
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
import com.upsam.hospital.controller.dto.FicheroMDXDTO;
import com.upsam.hospital.controller.dto.FicheroMDXInfoDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.jaxb.EmxDataFile;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IFicheroMDXService;
import com.upsam.hospital.model.service.IPacienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteController.
 */
@Controller
@RequestMapping("/paciente")
public class PacienteController {

	/** The Constant EMT_FILE. */
	private static final String EMT_FILE = ".emt";

	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(PacienteController.class);

	/** The Constant MDX_FILE. */
	private static final String MDX_FILE = ".mdx";

	/** The fichero emt service. */
	@Inject
	private IFicheroEMTService ficheroEMTService;

	/** The fichero mdx service. */
	@Inject
	private IFicheroMDXService ficheroMDXService;

	/** The usuario service. */
	@Inject
	private IPacienteService pacienteService;

	/** The paciente util dto. */
	@Inject
	private IPacienteUtilDTO pacienteUtilDTO;

	@Inject
	private IExploracionUtilDTO exploracionUtilDTO;

	/** The servlet context. */
	@Inject
	private ServletContext servletContext;

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
	 * Fichero mdx.
	 * 
	 * @param idPaciente
	 *            the id paciente
	 * @param id
	 *            the id
	 * @return the fichero mdxdto
	 */
	@RequestMapping(value = "{idPaciente}/ficheroMDX/{id}")
	public @ResponseBody
	FicheroMDXDTO ficheroMDX(@PathVariable("idPaciente") Integer idPaciente, @PathVariable("id") Integer id) {
		FicheroMDXDTO ficheroMDXDTO = null;
		try {
			FicheroMDX ficheroMDX = ficheroMDXService.findOne(id);
			File file = new File(new StringBuffer(servletContext.getRealPath("/resources/files/PACIENTE_")).append(idPaciente).append("/").append(ficheroMDX.getFecha()).append("_").append(ficheroMDX.getNombre()).toString());
			EmxDataFile emxDataFile = ficheroMDXService.fileReaderMDX(file);
			ficheroMDXDTO = exploracionUtilDTO.fileMDXToDTO(emxDataFile);
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
		return ficheroMDXDTO;
	}

	/**
	 * Ficheros mdx info.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	@RequestMapping(value = "{id}/ficherosMDX")
	public @ResponseBody
	List<FicheroMDXInfoDTO> ficherosMDXInfo(@PathVariable("id") Integer id) {
		List<FicheroMDXInfoDTO> result = new ArrayList<FicheroMDXInfoDTO>();
		// try {
		// Paciente paciente = pacienteService.findOne(id);
		// result.addAll(pacienteUtilDTO.getFicherosMDXInfoList(paciente.getFicheroMDX()));
		// }
		// catch (DataBaseException e) {
		// LOG.error(e.getMessage());
		// }
		return result;
	}

	/**
	 * File upload.
	 * 
	 * @param file
	 *            the file
	 * @param id
	 *            the id
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "paciente/{idPaciente}/exploracion/{idExploracion}/fileUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody
	MensajeDTO fileUpload(@RequestParam("file") MultipartFile file, @PathVariable("idPaciente") Integer idPaciente, @PathVariable("idExploracion") Integer idExploracion) {
		MensajeDTO result = null;
		Date now = new Date();
		Paciente paciente;
		try {
			if (file.getSize() > 0) {
				File folder = new File(servletContext.getRealPath(new StringBuffer("/resources/files").toString()));
				if (!folder.exists()) {
					folder.mkdir();
				}
				folder = new File(servletContext.getRealPath(new StringBuffer("/resources/files/PACIENTE_").append(idPaciente).toString()));
				if (!folder.exists()) {
					folder.mkdir();
				}
				File uploadedFile = new File(new StringBuffer(folder.getAbsolutePath()).append("/").append(now.getTime()).append("_").append(file.getOriginalFilename()).toString());
				FileOutputStream fos = new FileOutputStream(uploadedFile);
				fos.write(file.getBytes());
				fos.close();
				if (uploadedFile.getName().toLowerCase().contains(EMT_FILE)) {
					FicheroEMT ficheroEMT = ficheroEMTService.fileReaderEMT(uploadedFile, idExploracion);
					if (uploadedFile.delete()) {
						ficheroEMTService.save(ficheroEMT);
						result = new MensajeDTO("Archivo subido correctamente.", true);
					}
					else {
						result = new MensajeDTO("Error al borrar el archivo.", false);
					}
				}
				else if (uploadedFile.getName().toLowerCase().contains(MDX_FILE)) {
					paciente = pacienteService.findOne(idPaciente);
					FicheroMDX ficheroMDX = new FicheroMDX();
					ficheroMDX.setFecha(now.getTime());
					ficheroMDX.setNombre(file.getOriginalFilename());
					ficheroMDX.setPaciente(paciente);
					// paciente.addFicheroMDX(ficheroMDX);
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
			return new MensajeDTO("Paciente creado correctamente", true, paciente);
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

}
