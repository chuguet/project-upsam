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

import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFicheroMDXRepository;
import com.upsam.hospital.model.repository.impl.FicheroMDXRepository;

public class FicheroMDXRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private IFicheroMDXRepository ficheroMDXRepository = new FicheroMDXRepository();

    @Test
    public void canSaveAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
        			
        ficheroMDXRepository.save(ficheroMDX);
		
		verify(hibernateTemplate, times(1)).save(ficheroMDX);
    }
    
    @Test
    public void canUpdateAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
    	ficheroMDX.setId(2);
        			
    	ficheroMDXRepository.update(ficheroMDX);
		
		verify(hibernateTemplate, times(1)).update(ficheroMDX);
    }
    
    @Test
    public void canDeleteAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
        			
    	ficheroMDXRepository.delete(ficheroMDX);
		
		verify(hibernateTemplate, times(1)).delete(ficheroMDX);
    }
    
    @Test
    public void canFindAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
        when(hibernateTemplate.get(FicheroMDX.class,1)).thenReturn(ficheroMDX);
        			
        FicheroMDX expectedficheroMDX = ficheroMDXRepository.findOne(1);
        
		assertThat(1, is(equalTo(expectedficheroMDX.getId())));
    }
    
    @Test
    public void canFindAllMDXFiles() throws SQLException, DataBaseException {
    	List<FicheroMDX> files = new ArrayList<FicheroMDX>();
    	files.add(ficheroMDX());
        when(hibernateTemplate.loadAll(FicheroMDX.class)).thenReturn(files);
        			
        List<FicheroMDX>expectedFiles = ficheroMDXRepository.findAll();
        
		assertThat(files.size(), is(equalTo(expectedFiles.size())));
    }
    
    private FicheroMDX ficheroMDX(){
    	FicheroMDX ficheroMDX = new FicheroMDX();
    	ficheroMDX.setId(1);
    	
		return ficheroMDX;
    }
}
