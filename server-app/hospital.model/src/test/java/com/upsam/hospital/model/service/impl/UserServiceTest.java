package com.upsam.hospital.model.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

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
    
    private Usuario anUser(){
    	Usuario u = new Usuario();
		u.setId(178);
		u.setApellidos("any");
		return u;
    }
	
}
