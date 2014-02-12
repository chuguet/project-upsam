package com.upsam.hospital.controller.dto.util.impl;

import org.springframework.stereotype.Component;
import com.upsam.hospital.controller.dto.UsuarioDTO;
import com.upsam.hospital.controller.dto.util.IUsuarioUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Rol;
import com.upsam.hospital.model.beans.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Class DataTransferObjectUsuario.
 */
@Component
public class UsuarioUtilDTO implements IUsuarioUtilDTO {

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toBusiness(com
	 * .upsam.apuestas.controller.dto.UsuarioDTO)
	 */
	@Override
	public Usuario toBusiness(UsuarioDTO usuarioDTO) throws TransferObjectException {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioDTO.getId());
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setApellidos(usuarioDTO.getApellidos());
		if (usuarioDTO.getRol().equals(Rol.ROLE_ADMIN.getNameId())) {
			usuario.setRol(Rol.ROLE_ADMIN);
		}
		else if (usuarioDTO.getRol().equals(Rol.ROLE_USER.getNameId())) {
			usuario.setRol(Rol.ROLE_USER);
		}
		usuario.setUsuario(usuarioDTO.getUser());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setPassword(usuarioDTO.getPassword());
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IUsuarioUtilDTO#toRest(com.upsam
	 * .apuestas.model.bean.Usuario)
	 */
	@Override
	public UsuarioDTO toRest(Usuario usuario) throws TransferObjectException {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNombre(usuario.getNombre());
		usuarioDTO.setApellidos(usuario.getApellidos());
		usuarioDTO.setRol(usuario.getRol().getNameId());
		usuarioDTO.setUser(usuario.getUsuario());
		usuarioDTO.setPassword(usuario.getPassword());
		usuarioDTO.setEmail(usuario.getEmail());
		return usuarioDTO;
	}
}
