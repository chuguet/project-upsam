package com.upsam.hospital.model.service.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IUsuarioRepository;
import com.upsam.hospital.model.service.IUsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
@Service
public class UsuarioService implements IUsuarioService {

	/** The usuario repository. */
	@Inject
	private IUsuarioRepository usuarioRepository;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(Usuario usuario) throws DataBaseException {
		try {
			usuarioRepository.delete(usuario);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IUsuarioService#encriptUser(com.upsam
	 * .hospital.model.beans.Usuario)
	 */
	@Override
	public Usuario encriptUser(Usuario usuario) {
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		String pwd = passwordEncoder.encodePassword(usuario.getPassword(), null);
		usuario.setPassword(pwd);
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.apuestas.model.service.IModelService#findAll()
	 */
	@Override
	public List<Usuario> findAll() throws DataBaseException {
		try {
			return usuarioRepository.findAll();
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#findOne(java.lang.Integer)
	 */
	@Override
	public Usuario findOne(Integer pId) throws DataBaseException {
		try {
			return usuarioRepository.findOne(pId);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IUsuarioService#findUserByEmail(java
	 * .lang.String)
	 */
	@Override
	public Usuario findUserByEmail(String email) throws DataBaseException {
		try {
			return usuarioRepository.findUserByEmail(email);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public Integer save(Usuario usuario) throws DataBaseException {
		try {
			return usuarioRepository.save(encriptUser(usuario));
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.service.IUsuarioService#selectByToken(java.lang
	 * .String)
	 */
	@Override
	public Usuario selectByToken(String token) throws DataBaseException {
		try {
			return usuarioRepository.selectByToken(token);
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.service.IUsuarioService#selectByUser(java.lang
	 * .String)
	 */
	@Override
	public Usuario selectByUser(String user) throws DataBaseException {
		try {
			return usuarioRepository.selectByUser(user);
		}
		catch (SQLException e) {
			throw new DataBaseException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.service.IModelService#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(Usuario usuario) throws DataBaseException {
		try {
			usuarioRepository.update(encriptUser(usuario));
		}
		catch (SQLException e1) {
			throw new DataBaseException(e1);
		}
	}

}
