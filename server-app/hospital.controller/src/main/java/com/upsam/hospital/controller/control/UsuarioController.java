package com.upsam.hospital.controller.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.upsam.hospital.controller.dto.ChangePasswordDTO;
import com.upsam.hospital.controller.dto.ForgetDTO;
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

	@Secured("permitAll")
	@RequestMapping(value = "/forget", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO forgetPassword(@RequestBody ForgetDTO forgetDTO) {
		MensajeDTO result = null;
		try {
			Usuario usuario = usuarioService.findUserByEmail(forgetDTO.getValue());
			if (usuario == null) {
				usuario = usuarioService.selectByUser(forgetDTO.getValue());
			}
			if (usuario == null) {
				result = new MensajeDTO("El usuario o el correo son incorrectos.", false);
			}
			else {
				String token = UUID.randomUUID().toString().substring(0, 5);
				Date generateToken = new Date();
				usuario.setGenerate_token(generateToken);
				usuario.setToken(token);
				usuarioService.update(usuario);
				StringBuffer sb = new StringBuffer("Este es su token de seguridad ").append(token).append("<br>Estará activo durante 5 minutos.");
				mailUtil.sendMail(new Mail(usuario.getEmail(), sb.toString(), "Recuperación de contraseña"));
				String message = new StringBuffer("Se le ha enviado un correo electr&oacute;nico a ").append(usuario.getEmail()).append(" con la clave de seguridad. Introdúzcala junto con la nueva contraseña que desea utilizar").toString();
				result = new MensajeDTO(message, true);
			}
		}
		catch (DataBaseException e) {
			LOG.info(e.getMessage());
			return new MensajeDTO("Se ha producido un error interno en el servidor.", false);
		}
		return result;
	}

	@Secured("permitAll")
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		MensajeDTO result = null;
		try {
			Usuario usuario = usuarioService.selectByToken(changePasswordDTO.getToken());
			if (usuario == null) {
				result = new MensajeDTO("El token ha cambiado. Introduzca el token del ultimo mail.", false);
			}
			else {
				Date dateNow = new Date();
				Date dateCreation = usuario.getGenerate_token();
				if (dateNow.getTime() - dateCreation.getTime() < 300000) {
					result = new MensajeDTO("Han pasado m&aacute;s de 5 minutos. Vuelva a realizar el proceso.", false);
				}
				else {
					usuario.setPassword(changePasswordDTO.getPassword());
					usuarioService.update(usuarioService.encriptUser(usuario));
					result = new MensajeDTO("Su contrase&ntilde;a ha sido modificada correctamente.", true);
				}
			}
		}
		catch (DataBaseException e) {
			LOG.info(e.getMessage());
		}
		return result;
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
