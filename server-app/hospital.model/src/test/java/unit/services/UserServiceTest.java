package unit.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import unit.UnitTest;

import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IUsuarioRepository;
import com.upsam.hospital.model.service.IUsuarioService;
import com.upsam.hospital.model.service.impl.UsuarioService;

public class UserServiceTest extends UnitTest{

    @Mock
    private IUsuarioRepository usuarioRepository;
    @InjectMocks
    private IUsuarioService usuarioService = new UsuarioService();
     
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
