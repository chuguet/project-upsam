package com.upsam.hospital.model.repository.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class UsuarioRepositoryTest extends UnitTest {

	@Mock
	private HibernateTemplate hibernateTemplate;
	@InjectMocks
	private UsuarioRepository usuarioRepository;

	@Test
	public void canSaveAPatient() throws SQLException, DataBaseException {
		Usuario user = anUser();

		usuarioRepository.save(user);

		verify(hibernateTemplate, times(1)).save(user);
	}

	@Test
	public void canUpdateAnUer() throws SQLException, DataBaseException {
		Usuario usuario = anUser();
		usuario.setApellidos("upsam");

		usuarioRepository.update(usuario);

		verify(hibernateTemplate, times(1)).update(usuario);
	}

	@Test
	public void canDeleteAnUser() throws SQLException, DataBaseException {
		Usuario usuario = anUser();

		usuarioRepository.delete(usuario);

		verify(hibernateTemplate, times(1)).delete(usuario);
	}

	@Test
	public void canSelectByUser() throws SQLException, DataBaseException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(anUser());
		when(hibernateTemplate.find("from Usuario where USUARIO = ?", "user")).thenReturn(usuarios);

		Usuario userFound = usuarioRepository.selectByUser("user");

		assertThat("any", is(equalTo(userFound.getApellidos())));
	}

	@Test
	public void canSelectByToken() throws SQLException, DataBaseException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(anUser());
		when(hibernateTemplate.find("from Usuario where TOKEN = ?", "token")).thenReturn(usuarios);

		Usuario userFound = usuarioRepository.selectByToken("token");

		assertThat("any", is(equalTo(userFound.getApellidos())));
	}

	@Test
	public void canFindAnUserByEmail() throws SQLException, DataBaseException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(anUser());
		when(hibernateTemplate.find("from Usuario where EMAIL = ?", "email")).thenReturn(usuarios);

		Usuario userFound = usuarioRepository.findUserByEmail("email");

		assertThat("any", is(equalTo(userFound.getApellidos())));
	}

	@Test
	public void canFindAnUser() throws SQLException, DataBaseException {
		Usuario usuario = anUser();
		when(hibernateTemplate.get(Usuario.class, 178)).thenReturn(usuario);

		Usuario userFound = usuarioRepository.findOne(178);

		assertThat("any", is(equalTo(userFound.getApellidos())));
	}

	@Test
	public void canFindAllUsers() throws SQLException, DataBaseException {
		List<Usuario> users = new ArrayList<Usuario>();
		users.add(anUser());
		when(hibernateTemplate.loadAll(Usuario.class)).thenReturn(users);

		List<Usuario> expectedUsers = usuarioRepository.findAll();

		assertThat(users.size(), is(equalTo(expectedUsers.size())));
	}

	private Usuario anUser() {
		Usuario u = new Usuario();
		u.setId(178);
		u.setApellidos("any");
		return u;
	}
}
