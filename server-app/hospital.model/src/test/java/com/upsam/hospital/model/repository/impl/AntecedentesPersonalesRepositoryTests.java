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

import com.upsam.hospital.model.beans.AntecedentesPersonales;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class AntecedentesPersonalesRepositoryTests extends UnitTest{

	private final int AN_ID = 17;
    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private AntecedentesPersonalesRepository antecedentesPersonalesRepository;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        			
        antecedentesPersonalesRepository.save(antecedentes);
		
		verify(hibernateTemplate, times(1)).save(antecedentes);
    }
    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
        			
    	antecedentesPersonalesRepository.update(antecedentes);
		
		verify(hibernateTemplate, times(1)).update(antecedentes);
    }
    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	AntecedentesPersonales antecedentes= antecedentesPersonales();
        			
    	antecedentesPersonalesRepository.delete(antecedentes);
		
		verify(hibernateTemplate, times(1)).delete(antecedentes);
    }
    
    @Test
    public void canFind() throws SQLException, DataBaseException {
        when(hibernateTemplate.get(AntecedentesPersonales.class,AN_ID)).thenReturn(antecedentesPersonales());
        			
        AntecedentesPersonales antecedentes = antecedentesPersonalesRepository.findOne(AN_ID);
        
		assertThat(AN_ID, is(equalTo(antecedentes.getId())));
    }
    
    @Test
    public void canFindByExploracion() throws SQLException, DataBaseException {
    	List<AntecedentesPersonales> listaAntecedentes = new ArrayList<AntecedentesPersonales>();
    	AntecedentesPersonales antecedentes = antecedentesPersonales();
    	listaAntecedentes.add(antecedentes);
        when(hibernateTemplate.find("Select new AntecedentesPersonales(alergiasMedicamentosasConocidas,antecedentesMedicos,audicion,caidasUltimoAnno,epilepsia,fechaPenultimaSesion,fechaUltimaCaida,fechaUltimaSesion,id,lenguajeCognicion,localizacionTratamiento,numeroAproximado,tratamientoActual,vision) from AntecedentesPersonales where (ID_EXPLORACION = ?)", AN_ID))
        					  .thenReturn(listaAntecedentes);
        			
        AntecedentesPersonales result = antecedentesPersonalesRepository.findByExploracion(AN_ID);
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<AntecedentesPersonales> antecedentes = listaAntecedentes();
        when(hibernateTemplate.loadAll(AntecedentesPersonales.class)).thenReturn(antecedentes);
        			
        List<AntecedentesPersonales> result = antecedentesPersonalesRepository.findAll();
        
		assertThat(antecedentes, is(equalTo(result)));
    }
    
    private List<AntecedentesPersonales> listaAntecedentes(){
    	List<AntecedentesPersonales> antecedentes = new ArrayList<AntecedentesPersonales>();
    	antecedentes.add(antecedentesPersonales());
    	return antecedentes;
    }
    
    private AntecedentesPersonales antecedentesPersonales(){
    	AntecedentesPersonales a = new AntecedentesPersonales();
		a.setId(AN_ID);
    	
		return a;
    }
}
