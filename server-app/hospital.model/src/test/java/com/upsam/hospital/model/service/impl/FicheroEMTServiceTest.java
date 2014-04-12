package com.upsam.hospital.model.service.impl;

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

import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFicheroEMTRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class FicheroEMTServiceTest extends UnitTest{

    @Mock
    private IFicheroEMTRepository ficheroEMTRepository;
    @InjectMocks
    private FicheroEMTService ficheroEMTService;

    @Test
    public void canSaveAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
        			
    	ficheroEMTService.save(ficheroEMT);
		
		verify(ficheroEMTRepository, times(1)).save(ficheroEMT);
    }
    
    @Test
    public void canUpdateAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
    	ficheroEMT.setId(2);
        			
    	ficheroEMTService.update(ficheroEMT);
		
		verify(ficheroEMTRepository, times(1)).update(ficheroEMT);
    }
    
    @Test
    public void canDeleteAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
        			
    	ficheroEMTService.delete(ficheroEMT);
		
		verify(ficheroEMTRepository, times(1)).delete(ficheroEMT);
    }
    
    @Test
    public void canFindAnEMTFile() throws SQLException, DataBaseException {
    	FicheroEMT ficheroEMT = ficheroEMT();
        when(ficheroEMTRepository.findOne(1)).thenReturn(ficheroEMT);
        			
        FicheroEMT expectedficheroEMT = ficheroEMTService.findOne(1);
        
		assertThat(1, is(equalTo(expectedficheroEMT.getId())));
    }
    
    @Test
    public void canFindByPatient() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
        when(ficheroEMTRepository.findByPaciente(1)).thenReturn(files);
        			
        List<FicheroEMT> expectedFiles = ficheroEMTService.findByPaciente(1);
        
		assertThat(files.size(), is(equalTo(expectedFiles.size())));
    }
    
    @Test
    public void canFindAllEMTFiles() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
        when(ficheroEMTRepository.findAll()).thenReturn(files);
        			
        List<FicheroEMT>expectedFiles = ficheroEMTService.findAll();
        
		assertThat(files.size(), is(equalTo(expectedFiles.size())));
    }
    
    private FicheroEMT ficheroEMT(){
    	FicheroEMT ficheroEMT = new FicheroEMT();
		ficheroEMT.setId(1);
    	
		return ficheroEMT;
    }
}
