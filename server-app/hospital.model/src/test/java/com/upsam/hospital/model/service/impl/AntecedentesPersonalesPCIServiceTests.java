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

import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesPCIRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class AntecedentesPersonalesPCIServiceTests extends UnitTest{
	
	@Mock
	private IAntecedentesPersonalesPCIRepository antecedentesPersonalesRepositoryPCI;
    @InjectMocks
    private AntecedentesPersonalesPCIService antecedentesPersonalesPCIService;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = AntecedentesPersonalesPCI();
        			
    	antecedentesPersonalesPCIService.save(antecedentes);
		
		verify(antecedentesPersonalesRepositoryPCI, times(1)).save(antecedentes);
    }
	    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = AntecedentesPersonalesPCI();
        			
    	antecedentesPersonalesPCIService.update(antecedentes);
		
		verify(antecedentesPersonalesRepositoryPCI, times(1)).update(antecedentes);
    }
	    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = AntecedentesPersonalesPCI();
        			
    	antecedentesPersonalesPCIService.delete(antecedentes);
		
		verify(antecedentesPersonalesRepositoryPCI, times(1)).delete(antecedentes);
    }
	    
    @Test
    public void canFindOne() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = AntecedentesPersonalesPCI();
        when(antecedentesPersonalesRepositoryPCI.findOne(1)).thenReturn(antecedentes);
        			
        AntecedentesPersonalesPCI result = antecedentesPersonalesPCIService.findOne(1);
        
		assertThat(1, is(equalTo(result.getId())));
    }
    
    @Test
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = AntecedentesPersonalesPCI();
        when(antecedentesPersonalesRepositoryPCI.findByExploracion(1)).thenReturn(antecedentes);
        			
        AntecedentesPersonalesPCI result = antecedentesPersonalesPCIService.findByExploracion(1);
        
		assertThat(antecedentes, is(equalTo(result)));
    }

    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<AntecedentesPersonalesPCI> antecedentes = new ArrayList<AntecedentesPersonalesPCI>();
    	antecedentes.add(AntecedentesPersonalesPCI());
        when(antecedentesPersonalesRepositoryPCI.findAll()).thenReturn(antecedentes);
        			
        List<AntecedentesPersonalesPCI> result = antecedentesPersonalesPCIService.findAll();
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    private AntecedentesPersonalesPCI AntecedentesPersonalesPCI(){
    	AntecedentesPersonalesPCI a = new AntecedentesPersonalesPCI();
		a.setId(1);
    	
		return a;
    }
}
