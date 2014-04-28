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

import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IExploracionRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class ExploracionServiceTests extends UnitTest {
	
	private static final int EXPLORACION_ID = 1;
	@Mock
	private IExploracionRepository exploracionRepository;
    @InjectMocks
    private ExploracionService exploracionService;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	Exploracion exploracion = exploracion();
        			
    	exploracionService.save(exploracion);
		
		verify(exploracionRepository, times(1)).save(exploracion);
    }
	    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	Exploracion exploracion = exploracion();
        			
    	exploracionService.update(exploracion);
		
		verify(exploracionRepository, times(1)).update(exploracion);
    }
	    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	Exploracion exploracion = exploracion();
        			
    	exploracionService.delete(exploracion);
		
		verify(exploracionRepository, times(1)).delete(exploracion);
    }
	    
    @Test
    public void canFindOne() throws SQLException, DataBaseException {
    	Exploracion exploracion = exploracion();
        when(exploracionRepository.findOne(EXPLORACION_ID)).thenReturn(exploracion);
        			
        Exploracion result = exploracionService.findOne(EXPLORACION_ID);
        
		assertThat(1, is(equalTo(result.getId())));
    }
    
    @Test
    public void canFindOneUnique() throws SQLException, DataBaseException {
    	Exploracion exploracion = exploracion();
        when(exploracionRepository.findOneUnique(EXPLORACION_ID)).thenReturn(exploracion);
        			
        Exploracion result = exploracionService.findOneUnique(EXPLORACION_ID);
        
		assertThat(exploracion, is(equalTo(result)));
    }
    
    @Test
    public void canFindReducedListByPatient() throws SQLException, DataBaseException {
    	List<Exploracion> exploracion = new ArrayList<Exploracion>();
    	exploracion.add(exploracion());
        when(exploracionRepository.findReducedListByPatient(EXPLORACION_ID)).thenReturn(exploracion);
        			
        List<Exploracion> result = exploracionService.findReducedListByPatient(EXPLORACION_ID);
        
		assertThat(exploracion, is(equalTo(result)));
    }

    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<Exploracion> exploracion = new ArrayList<Exploracion>();
    	exploracion.add(exploracion());
        when(exploracionRepository.findAll()).thenReturn(exploracion);
        			
        List<Exploracion> result = exploracionService.findAll();
        
		assertThat(exploracion, is(equalTo(result)));
    }
    
    private Exploracion exploracion(){
    	Exploracion e = new Exploracion();
		e.setId(EXPLORACION_ID);
    	
		return e;
    }
}
