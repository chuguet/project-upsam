package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.repository.IUsuarioRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRepository.
 */
@Repository
class UsuarioRepository extends AbstractRepositoryDAO<Usuario> implements IUsuarioRepository {

	/** The Constant QUERY_EMAIL. */
	private static final String QUERY_EMAIL = "from Usuario where EMAIL = ?";

	/** The Constant QUERY_TOKEN. */
	private static final String QUERY_TOKEN = "from Usuario where TOKEN = ?";

	/** The Constant QUERY_USER. */
	private static final String QUERY_USER = "from Usuario where USUARIO = ?";

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IUsuarioRepository#findUserByEmail
	 * (java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Usuario findUserByEmail(String email) throws SQLException {
		Usuario result = null;
		List<Usuario> usuarios = getHibernateTemplate().find(QUERY_EMAIL, email);
		if (usuarios != null && !usuarios.isEmpty()) {
			result = usuarios.get(0);
		}
		return result;
	}

	/**
	 * Gets the clazz.
	 * 
	 * @return the clazz
	 */
	@Override
	protected Class<Usuario> getClazz() {
		return Usuario.class;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.hospital.model.repository.IUsuarioRepository#selectByToken(
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Usuario selectByToken(String token) throws SQLException {
		Usuario result = null;
		List<Usuario> usuarios = getHibernateTemplate().find(QUERY_TOKEN, token);
		if (usuarios != null && !usuarios.isEmpty()) {
			result = usuarios.get(0);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.repository.IUsuarioRepository#selectByUser(java
	 * .lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Usuario selectByUser(String user) throws SQLException {
		Usuario result = null;
		List<Usuario> usuarios = getHibernateTemplate().find(QUERY_USER, user);
		if (usuarios != null && !usuarios.isEmpty()) {
			result = usuarios.get(0);
		}
		return result;
	}

}
