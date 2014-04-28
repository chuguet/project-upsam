package com.upsam.hospital.model.service.impl;

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

import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IAntecedentesPersonalesRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class AntecendentesPersonalesServiceTests extends UnitTest {
	
	@Mock
	private IAntecedentesPersonalesRepository antecedentesPersonalesRepository;
	
    @InjectMocks
    private AntecedentesPersonalesService antecedentesPersonalesService;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        			
    	antecedentesPersonalesService.save(antecedentes);
		
		verify(antecedentesPersonalesRepository, times(1)).save(antecedentes);
    }
	    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        			
    	antecedentesPersonalesService.update(antecedentes);
		
		verify(antecedentesPersonalesRepository, times(1)).update(antecedentes);
    }
	    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        			
    	antecedentesPersonalesService.delete(antecedentes);
		
		verify(antecedentesPersonalesRepository, times(1)).delete(antecedentes);
    }
	    
    @Test
    public void canFindOne() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        when(antecedentesPersonalesRepository.findOne(1)).thenReturn(antecedentes);
        			
        AntecedentesPersonales result = antecedentesPersonalesService.findOne(1);
        
		assertThat(1, is(equalTo(result.getId())));
    }
    
    @Test
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        when(antecedentesPersonalesRepository.findByExploracion(1)).thenReturn(antecedentes);
        			
        AntecedentesPersonales result = antecedentesPersonalesService.findByExploracion(1);
        
		assertThat(antecedentes, is(equalTo(result)));
    }

    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<AntecedentesPersonales> antecedentes = new ArrayList<AntecedentesPersonales>();
    	antecedentes.add(antecedentesPersonales());
        when(antecedentesPersonalesRepository.findAll()).thenReturn(antecedentes);
        			
        List<AntecedentesPersonales> result = antecedentesPersonalesService.findAll();
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    private AntecedentesPersonales antecedentesPersonales(){
    	AntecedentesPersonales a = new AntecedentesPersonales();
		a.setId(1);
    	
		return a;
    }
}
