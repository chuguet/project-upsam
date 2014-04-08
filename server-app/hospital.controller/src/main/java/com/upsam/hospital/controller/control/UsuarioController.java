package com.upsam.hospital.controller.control;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.upsam.hospital.controller.dto.MailDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.UsuarioDTO;
import com.upsam.hospital.controller.dto.util.IUsuarioUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IUsuarioService;
import com.upsam.hospital.util.mail.beans.Mail;
import com.upsam.hospital.util.mail.service.IMailUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioController.
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private final static Log LOG = LogFactory.getLog(UsuarioController.class);

	/** The usuario service. */
	@Inject
	private IUsuarioService usuarioService;

	/** The usuario util dto. */
	@Inject
	private IUsuarioUtilDTO usuarioUtilDTO;

	@Inject
	private IMailUtil mailUtil;

	@RequestMapping(value = "/forget", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO forgetPassword(@RequestBody MailDTO mail) {
		try {
			Usuario usuario = usuarioService.findUserByEmail(mail.getValue());
			StringBuffer sb = new StringBuffer("Para cambiar su contraseña, acceda a la URL: http://localhost:8080/hospitalServer/usuario/newPassword/").append(usuario.getUsuario()).append("/").append(usuario.getPassword());
			mailUtil.sendMail(new Mail(mail.getValue(), sb.toString(), "Recuperación de contraseña"));
		}
		catch (DataBaseException e) {
			LOG.info(e.getMessage());
		}
		return new MensajeDTO(new StringBuffer("Se le ha enviado un correo electr&oacute;nico a ").append(mail.getValue()).toString(), true);
	}

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
		return new StringBuffer("usuario/").append(operacion).toString();
	}

	/**
	 * Insert the user.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the mensaje dto
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insert(@RequestBody UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null) {
			return new MensajeDTO("Un usuario es requerido", false);
		}
		try {
			Usuario usuario = usuarioUtilDTO.toBusiness(usuarioDTO);
			usuarioService.save(usuario);
			return new MensajeDTO("Usuario creado correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO(new StringBuffer("Ya existe el usuario ").append(usuarioDTO.getUser()).append(" en base de datos.").toString(), false);
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
	List<UsuarioDTO> listAll() {
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();

		try {
			List<Usuario> usuarios = this.usuarioService.findAll();

			for (Usuario usuario : usuarios) {
				UsuarioDTO e = usuarioUtilDTO.toRest(usuario);
				usuariosDTO.add(e);
			}
		}
		catch (DataBaseException e) {

		}
		catch (TransferObjectException e) {

		}
		return usuariosDTO;
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
			return new MensajeDTO("Un usuario es requerido", false);
		}
		try {
			Usuario usuario = new Usuario();
			usuario.setId(id);
			this.usuarioService.delete(usuario);
			return new MensajeDTO("Usuario eliminado correctamente", true);
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
	UsuarioDTO retrieve(@PathVariable("id") Integer id) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		try {
			Usuario usuario = this.usuarioService.findOne(id);
			usuarioDTO = usuarioUtilDTO.toRest(usuario);
		}
		catch (DataBaseException e) {

		}
		catch (TransferObjectException e) {

		}
		return usuarioDTO;
	}

	/**
	 * Update the user.
	 * 
	 * @param usuarioDTO
	 *            the usuario dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO update(@RequestBody UsuarioDTO usuarioDTO) {
		if (usuarioDTO == null) {
			return new MensajeDTO("Un usuario es requerido", false);
		}
		try {
			Usuario usuario = usuarioUtilDTO.toBusiness(usuarioDTO);
			usuarioService.update(usuario);
			return new MensajeDTO("Usuario modificado correctamente", true);
		}
		catch (DataBaseException e) {
			return new MensajeDTO("Error al actualizar el usuario en base de datos.", false);
		}
		catch (TransferObjectException e) {
			return new MensajeDTO(e.getMessage(), false);
		}
	}
}
