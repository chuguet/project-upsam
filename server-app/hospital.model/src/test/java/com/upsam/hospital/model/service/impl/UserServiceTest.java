package com.upsam.hospital.model.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IUsuarioRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class UserServiceTest extends UnitTest{

    @Mock
    private IUsuarioRepository usuarioRepository;
    @InjectMocks
    private UsuarioService usuarioService;
     
    @Test
    public void canSaveAnUser() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        			
    	usuarioService.save(usuario);
		
		verify(usuarioRepository, times(1)).save(usuario);
    }
    
    @Test
    public void canUpdateAnUer() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
    	usuario.setApellidos("upsam");
        			
        usuarioService.update(usuario);
		
		verify(usuarioRepository, times(1)).update(usuario);
    }
    
    @Test
    public void canDeleteAnUser() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        			
    	usuarioService.delete(usuario);
		
		verify(usuarioRepository, times(1)).delete(usuario);
    }
    
    @Test
    public void canFindAnUser() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        when(usuarioRepository.findOne(178)).thenReturn(usuario);
        			
        Usuario userFound = usuarioService.findOne(178);
        
		assertThat("any", is(equalTo(userFound.getApellidos())));
    }
    
    @Test
    public void canSelectByUser() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        when(usuarioRepository.selectByUser("user")).thenReturn(usuario);
        			
        Usuario userFound = usuarioService.selectByUser("user");
        
		assertThat("any", is(equalTo(userFound.getApellidos())));
    }
    
    @Test
    public void canSelectByEmail() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        when(usuarioRepository.findUserByEmail("email")).thenReturn(usuario);
        			
        Usuario userFound = usuarioService.findUserByEmail("email");
        
		assertThat("any", is(equalTo(userFound.getApellidos())));
    }
    
    @Test
    public void canSelectByToken() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        when(usuarioRepository.selectByToken("token")).thenReturn(usuario);
        			
        Usuario userFound = usuarioService.selectByToken("token");
        
		assertThat("any", is(equalTo(userFound.getApellidos())));
    }
    
    @Test
    public void canFindAllUsers() throws SQLException, DataBaseException {
    	List<Usuario> usuarios = new ArrayList<Usuario>();
    	usuarios.add(anUser());
        when(usuarioRepository.findAll()).thenReturn(usuarios);
        			
        List<Usuario>usuarioResult = usuarioService.findAll();
        
		assertThat(usuarios.size(), is(equalTo(usuarioResult.size())));
    }
    
    private Usuario anUser(){
    	Usuario u = new Usuario();
		u.setId(178);
		u.setApellidos("any");
		return u;
    }
	
}
