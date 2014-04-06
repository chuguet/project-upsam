package unit.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.orm.hibernate3.HibernateTemplate;

import unit.UnitTest;

import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IUsuarioRepository;
import com.upsam.hospital.model.repository.impl.UsuarioRepository;

public class UsuarioRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private IUsuarioRepository usuarioRepository = new UsuarioRepository();

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
    public void canFindAnUser() throws SQLException, DataBaseException {
    	Usuario usuario = anUser();
        when(hibernateTemplate.get(Usuario.class,178)).thenReturn(usuario);
        			
        Usuario userFound = usuarioRepository.findOne(178);
        
		assertThat("any", is(equalTo(userFound.getApellidos())));
    }
    
    private Usuario anUser(){
    	Usuario u = new Usuario();
		u.setId(178);
		u.setApellidos("any");
		return u;
    }
}
