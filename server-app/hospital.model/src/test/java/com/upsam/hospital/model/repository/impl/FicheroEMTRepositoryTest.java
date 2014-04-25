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

	private final int FICHERO_EMT_ID = 12;
	private final int EXPLORACION_ID = 17;
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
        when(hibernateTemplate.get(FicheroEMT.class,FICHERO_EMT_ID)).thenReturn(ficheroEMT());
        			
        FicheroEMT ficheroEMTFound = ficheroEMTRepository.findOne(FICHERO_EMT_ID);
        
		assertThat(FICHERO_EMT_ID, is(equalTo(ficheroEMTFound.getId())));
    }
    
    @Test
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	List<FicheroEMT> files = aListOfFicheroEMT();
        when(hibernateTemplate.find("Select new FicheroEMT(fecha,id) from FicheroEMT where (ID_EXPLORACION = ?)", EXPLORACION_ID))
        					  .thenReturn(files);
        			
        List<FicheroEMT> result = ficheroEMTRepository.findByExploracion(EXPLORACION_ID);
        
		assertThat(files, is(equalTo(result)));
    }
    
    @Test
    public void canFindOneUnique() throws SQLException, DataBaseException {
        when(hibernateTemplate.find("Select new FicheroEMT(ficheroEMT.ciclos,ficheroEMT.fecha,ficheroEMT.id,ficheroEMT.tablaDatos,ficheroEMT.tipoMedida,ficheroEMT.unidadMedida) from FicheroEMT as ficheroEMT where (ficheroEMT.id = ?)",FICHERO_EMT_ID))
        					  .thenReturn(aListOfFicheroEMT());
        			
        FicheroEMT result = ficheroEMTRepository.findOneUnique(FICHERO_EMT_ID);
        
		assertThat(FICHERO_EMT_ID, is(equalTo(result.getId())));
    }
    
    @Test
    public void canFindAllEMTFiles() throws SQLException, DataBaseException {
    	List<FicheroEMT> files =  aListOfFicheroEMT();
        when(hibernateTemplate.loadAll(FicheroEMT.class)).thenReturn(files);
        			
        List<FicheroEMT> result = ficheroEMTRepository.findAll();
        
		assertThat(files, is(equalTo(result)));
    }
    
    private List<FicheroEMT> aListOfFicheroEMT(){
    	List<FicheroEMT> files = new ArrayList<FicheroEMT>();
    	files.add(ficheroEMT());
    	return files;
    }
    
    private FicheroEMT ficheroEMT(){
    	FicheroEMT ficheroEMT = new FicheroEMT();
		ficheroEMT.setId(FICHERO_EMT_ID);
    	
		return ficheroEMT;
    }
}
