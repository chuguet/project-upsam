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

import com.upsam.hospital.model.beans.AntecedentesRelacionadosPCI;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class AntecedentesRelacionadosPCIRepositoryTests extends UnitTest{

	private final int AN_ID = 17;
    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private AntecedentesRelacionadosPCIRepository antecedentesRelacionadosPCIRepository;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();
        			
        antecedentesRelacionadosPCIRepository.save(antecedentes);
		
		verify(hibernateTemplate, times(1)).save(antecedentes);
    }
    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();
        			
    	antecedentesRelacionadosPCIRepository.update(antecedentes);
		
		verify(hibernateTemplate, times(1)).update(antecedentes);
    }
    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	AntecedentesRelacionadosPCI antecedentes= antecedentesRelacionadosPCI();
        			
    	antecedentesRelacionadosPCIRepository.delete(antecedentes);
		
		verify(hibernateTemplate, times(1)).delete(antecedentes);
    }
    
    @Test
    public void canFind() throws SQLException, DataBaseException {
        when(hibernateTemplate.get(AntecedentesRelacionadosPCI.class,AN_ID)).thenReturn(antecedentesRelacionadosPCI());
        			
        AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCIRepository.findOne(AN_ID);
        
		assertThat(AN_ID, is(equalTo(antecedentes.getId())));
    }
    
    @Test
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	AntecedentesRelacionadosPCI antecedentes = antecedentesRelacionadosPCI();
    	List<AntecedentesRelacionadosPCI> listaAntecedentes = new ArrayList<AntecedentesRelacionadosPCI>();
    	listaAntecedentes.add(antecedentes);
        when(hibernateTemplate.find("Select new AntecedentesRelacionadosPCI(id,ayudasMarcha,cuadriplejiaEspatica,deportes,diplejiaEspatica,dispositivoMasUsado,equipamiento,etiologia,exteriores,fisioterapiaDuracion,fisioterapiaSesiones,gradoI,gradoII,gradoIII,gradoIV,gradoV,hidroterapia,interiores,lgDuracion,lgSesiones,localizacion,ortesisDiurna,otraOrtesis,ortesisNocturna,otra,otras,pciMixta,pruebasComplementarias,terapiaOcupacionalDuracion,terapiaOcupacionalSesiones,terapiasHabituales,tratamientoActual,triplejiaEspatica, diagnosticoEspecificar, otrasTerapias) from AntecedentesRelacionadosPCI where (ID_EXPLORACION = ?)", AN_ID))
        					  .thenReturn(listaAntecedentes);
        			
        AntecedentesRelacionadosPCI result = antecedentesRelacionadosPCIRepository.findByExploracion(AN_ID);
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<AntecedentesRelacionadosPCI> antecedentes = listaAntecedentes();
        when(hibernateTemplate.loadAll(AntecedentesRelacionadosPCI.class)).thenReturn(antecedentes);
        			
        List<AntecedentesRelacionadosPCI> result = antecedentesRelacionadosPCIRepository.findAll();
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    private List<AntecedentesRelacionadosPCI> listaAntecedentes(){
    	List<AntecedentesRelacionadosPCI> antecedentes = new ArrayList<AntecedentesRelacionadosPCI>();
    	antecedentes.add(antecedentesRelacionadosPCI());
    	return antecedentes;
    }
    
    private AntecedentesRelacionadosPCI antecedentesRelacionadosPCI(){
    	AntecedentesRelacionadosPCI a = new AntecedentesRelacionadosPCI();
		a.setId(AN_ID);
    	
		return a;
    }
}
