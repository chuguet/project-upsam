package com.upsam.hospital.model.repository.impl;

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
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.upsam.hospital.model.beans.AntecedentesPersonalesPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class AntecedentesPersonalesPCIRepositoryTests extends UnitTest{

	private final int AN_ID = 17;
    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private AntecedentesPersonalesPCIRepository antecedentesPersonalesPCIRepository;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = antecedentesPersonalesPCI();
        			
        antecedentesPersonalesPCIRepository.save(antecedentes);
		
		verify(hibernateTemplate, times(1)).save(antecedentes);
    }
    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = antecedentesPersonalesPCI();
        			
    	antecedentesPersonalesPCIRepository.update(antecedentes);
		
		verify(hibernateTemplate, times(1)).update(antecedentes);
    }
    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes= antecedentesPersonalesPCI();
        			
    	antecedentesPersonalesPCIRepository.delete(antecedentes);
		
		verify(hibernateTemplate, times(1)).delete(antecedentes);
    }
    
    @Test
    public void canFind() throws SQLException, DataBaseException {
        when(hibernateTemplate.get(AntecedentesPersonalesPCI.class,AN_ID)).thenReturn(antecedentesPersonalesPCI());
        			
        AntecedentesPersonalesPCI antecedentes = antecedentesPersonalesPCIRepository.findOne(AN_ID);
        
		assertThat(AN_ID, is(equalTo(antecedentes.getId())));
    }
    
    @Test
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	AntecedentesPersonalesPCI antecedentes = antecedentesPersonalesPCI();
    	List<AntecedentesPersonalesPCI> listaAntecedentes = new ArrayList<AntecedentesPersonalesPCI>();
    	listaAntecedentes.add(antecedentes);
        when(hibernateTemplate.find("Select new AntecedentesPersonalesPCI(ayudasMarcha,cuadriplejiaEspatica,deportes,diplejiaEspatica,dispositivoMasUsado,equipamiento,etiologia,exteriores,fisioterapiaDuracion,fisioterapiaSesiones,gradoI,gradoII,gradoIII,gradoIV,gradoV,hidroterapia,id,interiores,lgDuracion,lgSesiones,localizacion,ortesisDiurna,ortesisNocturna,otra,otras,pciMixta,pruebasComlementarias,terapiaOcupacionalDuracion,terapiaOcupacionalSesiones,terapiasHabituales,tratamientoActual,triplejiaEspatica) from AntecedentesPersonalesPCI where (ID_EXPLORACION = ?)", AN_ID))
        					  .thenReturn(listaAntecedentes);
        			
        AntecedentesPersonalesPCI result = antecedentesPersonalesPCIRepository.findByExploracion(AN_ID);
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<AntecedentesPersonalesPCI> antecedentes = listaAntecedentes();
        when(hibernateTemplate.loadAll(AntecedentesPersonalesPCI.class)).thenReturn(antecedentes);
        			
        List<AntecedentesPersonalesPCI> result = antecedentesPersonalesPCIRepository.findAll();
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    private List<AntecedentesPersonalesPCI> listaAntecedentes(){
    	List<AntecedentesPersonalesPCI> antecedentes = new ArrayList<AntecedentesPersonalesPCI>();
    	antecedentes.add(antecedentesPersonalesPCI());
    	return antecedentes;
    }
    
    private AntecedentesPersonalesPCI antecedentesPersonalesPCI(){
    	AntecedentesPersonalesPCI a = new AntecedentesPersonalesPCI();
		a.setId(AN_ID);
    	
		return a;
    }
}
