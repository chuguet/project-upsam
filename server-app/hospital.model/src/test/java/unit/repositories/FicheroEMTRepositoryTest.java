package unit.repositories;

import static org.hamcrest.CoreMatchers.*;
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

import unit.UnitTest;

import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFicheroEMTRepository;
import com.upsam.hospital.model.repository.impl.FicheroEMTRepository;

public class FicheroEMTRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private IFicheroEMTRepository ficheroEMTRepository = new FicheroEMTRepository();

    @Test
    public void canSaveAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
        			
        ficheroEMTRepository.save(ficheroEMT);
		
		verify(hibernateTemplate, times(1)).save(ficheroEMT);
    }
    
    @Test
    public void canUpdateAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
    	ficheroEMT.setId(2);
        			
    	ficheroEMTRepository.update(ficheroEMT);
		
		verify(hibernateTemplate, times(1)).update(ficheroEMT);
    }
    
    @Test
    public void canDeleteAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
        			
    	ficheroEMTRepository.delete(ficheroEMT);
		
		verify(hibernateTemplate, times(1)).delete(ficheroEMT);
    }
    
    @Test
    public void canFindAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
        when(hibernateTemplate.get(FicheroEMT.class,1)).thenReturn(ficheroEMT);
        			
        FicheroEMT expectedficheroEMT = ficheroEMTRepository.findOne(1);
        
		assertThat(1, is(equalTo(expectedficheroEMT.getId())));
    }
    
    @Test
    public void canFindByPatient() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
        when(hibernateTemplate.find("from FicheroEMT where id_paciente = ?",FicheroEMT.class,1)).thenReturn(files);
        			
        List<FicheroEMT> expectedFiles = ficheroEMTRepository.findByPaciente(1);
        
		assertThat(files.size(), is(equalTo(expectedFiles.size())));
    }
    
    @Test
    public void canFindAllEMTFiles() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
        when(hibernateTemplate.loadAll(FicheroEMT.class)).thenReturn(files);
        			
        List<FicheroEMT>expectedFiles = ficheroEMTRepository.findAll();
        
		assertThat(files.size(), is(equalTo(expectedFiles.size())));
    }
    
    private FicheroEMT ficheroEMT(){
    	FicheroEMT ficheroEMT = new FicheroEMT();
		ficheroEMT.setId(1);
    	
		return ficheroEMT;
    }
}
