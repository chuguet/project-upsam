package com.upsam.hospital.model.repository.impl;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.repository.IUsuarioRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioRepository.
 */
@Repository
public class UsuarioRepository implements IUsuarioRepository {

	/** The Constant QUERY_EMAIL. */
	private static final String QUERY_EMAIL = "from Usuario where email = ?";

	/** The Constant QUERY_TOKEN. */
	private static final String QUERY_TOKEN = "from Usuario where token = ?";

	/** The Constant QUERY_USER. */
	private static final String QUERY_USER = "from Usuario where usuario = ?";

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#delete(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void delete(Usuario usuario) throws SQLException {
		hibernateTemplate.delete(usuario);
	}

	/*
	 * (non-Javadoc)
	 * @see com.upsam.apuestas.model.repository.IRepositoryDAO#findAll()
	 */
	@Override
	public List<Usuario> findAll() throws SQLException {
		return hibernateTemplate.loadAll(Usuario.class);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#findOne(java.lang.
	 * Integer)
	 */
	@Override
	public Usuario findOne(Integer pId) throws SQLException {
		return hibernateTemplate.get(Usuario.class, pId);
	}

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
		List<Usuario> usuarios = hibernateTemplate.find(QUERY_EMAIL, email);
		if (usuarios != null && !usuarios.isEmpty()) {
			result = usuarios.get(0);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#save(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public Integer save(Usuario usuario) throws SQLException {
		return (Integer) hibernateTemplate.save(usuario);
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
		List<Usuario> usuarios = hibernateTemplate.find(QUERY_TOKEN, token);
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
		List<Usuario> usuarios = hibernateTemplate.find(QUERY_USER, user);
		if (usuarios != null && !usuarios.isEmpty()) {
			result = usuarios.get(0);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.upsam.apuestas.model.repository.IRepositoryDAO#update(com.upsam.apuestas
	 * .model.bean.IModelTable)
	 */
	@Override
	public void update(Usuario usuario) throws SQLException {
		hibernateTemplate.update(usuario);
	}

}
