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

import com.upsam.hospital.model.beans.FicheroMDX;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFicheroMDXRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class FicheroMDXServiceTest extends UnitTest{

    @Mock
    private IFicheroMDXRepository ficheroMDXRepository;
    @InjectMocks
    private FicheroMDXService ficheroMDXService;

    @Test
    public void canSaveAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
        			
    	ficheroMDXService.save(ficheroMDX);
		
		verify(ficheroMDXRepository, times(1)).save(ficheroMDX);
    }
    
    @Test
    public void canUpdateAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
    	ficheroMDX.setId(2);
        			
    	ficheroMDXService.update(ficheroMDX);
		
		verify(ficheroMDXRepository, times(1)).update(ficheroMDX);
    }
    
    @Test
    public void canDeleteAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
        			
    	ficheroMDXService.delete(ficheroMDX);
		
		verify(ficheroMDXRepository, times(1)).delete(ficheroMDX);
    }
    
    @Test
    public void canFindAMDXFile() throws SQLException, DataBaseException {
    	FicheroMDX ficheroMDX = ficheroMDX();
        when(ficheroMDXRepository.findOne(1)).thenReturn(ficheroMDX);
        			
        FicheroMDX ficheroMDXResult = ficheroMDXService.findOne(1);
        
		assertThat(1, is(equalTo(ficheroMDXResult.getId())));
    }
    
    @Test
    public void canFindAllMDXFiles() throws SQLException, DataBaseException {
    	List<FicheroMDX> files = new ArrayList<FicheroMDX>();
    	files.add(ficheroMDX());
        when(ficheroMDXRepository.findAll()).thenReturn(files);
        			
        List<FicheroMDX>ficheroMDXResult = ficheroMDXService.findAll();
        
		assertThat(files.size(), is(equalTo(ficheroMDXResult.size())));
    }
    
    private FicheroMDX ficheroMDX(){
    	FicheroMDX ficheroMDX = new FicheroMDX();
    	ficheroMDX.setId(1);
    	
		return ficheroMDX;
    }
}
