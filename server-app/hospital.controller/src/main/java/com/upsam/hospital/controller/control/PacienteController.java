package com.upsam.hospital.controller.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IPacienteService;

// TODO: Auto-generated Javadoc
/**
 * The Class PacienteController.
 */
@Controller
@RequestMapping("/paciente")
public class PacienteController {

	/** The usuario service. */
	@Inject
	private IPacienteService pacienteService;

	/** The paciente util dto. */
	@Inject
	private IPacienteUtilDTO pacienteUtilDTO;

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
			return new MensajeDTO(new StringBuffer("Ya existe el paciente con expediente ").append(pacienteDTO.getExpediente()).append(" en base de datos.").toString(), false);
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

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody
	MensajeDTO fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		if (file.getSize() > 0) { // writing file to a directory
			File upLoadedfile = new File("D:/" + file.getOriginalFilename());

			upLoadedfile.createNewFile();
			FileOutputStream fos = new FileOutputStream(upLoadedfile);
			fos.write(file.getBytes());
			fos.close(); // setting the value of fileUploaded variable
		}
		return new MensajeDTO("Error al procesar el fichero", false);
	}
}
