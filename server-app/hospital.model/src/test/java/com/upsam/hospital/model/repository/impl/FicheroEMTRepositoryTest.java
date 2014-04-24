package com.upsam.hospital.model.repository.impl;

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

import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class FicheroEMTRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private FicheroEMTRepository ficheroEMTRepository;

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
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
        when(hibernateTemplate.find("Select new FicheroEMT(fecha,id) from FicheroEMT where (ID_EXPLORACION = ?)",1)).thenReturn(files);
        			
        List<FicheroEMT> expectedFiles = ficheroEMTRepository.findByExploracion(1);
        
		assertThat(files.size(), is(equalTo(expectedFiles.size())));
    }
    
    @Test
    public void canFindOneUnique() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
        when(hibernateTemplate.find("Select new FicheroEMT(ficheroEMT.ciclos,ficheroEMT.fecha,ficheroEMT.id,ficheroEMT.tablaDatos,ficheroEMT.tipoMedida,ficheroEMT.unidadMedida) from FicheroEMT as ficheroEMT where (ficheroEMT.id = ?)"));
        			
        List<FicheroEMT> expectedFiles = ficheroEMTRepository.findByExploracion(1);
        
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
