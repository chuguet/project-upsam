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
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class ExploracionRepositoryTests extends UnitTest{

	private final int AN_ID = 1346;
	
    @Mock
    private HibernateTemplate hibernateTemplate;
    
    @InjectMocks
    private ExploracionRepository exploracionRepository;

    @Test
    public void canSave() throws SQLException, DataBaseException {
    	Exploracion antecendentes = exploracion();
        			
        exploracionRepository.save(antecendentes);
		
		verify(hibernateTemplate, times(1)).save(antecendentes);
    }
    
    @Test
    public void canUpdate() throws SQLException, DataBaseException {
    	Exploracion exploracion = exploracion();
        			
    	exploracionRepository.update(exploracion);
		
		verify(hibernateTemplate, times(1)).update(exploracion);
    }
    
    @Test
    public void canDelete() throws SQLException, DataBaseException {
    	Exploracion exploracion= exploracion();
        			
    	exploracionRepository.delete(exploracion);
		
		verify(hibernateTemplate, times(1)).delete(exploracion);
    }
    
    @Test
    public void canFind() throws SQLException, DataBaseException {
        when(hibernateTemplate.get(Exploracion.class,AN_ID)).thenReturn(exploracion());
        			
        Exploracion exploracion = exploracionRepository.findOne(AN_ID);
        
		assertThat(AN_ID, is(equalTo(exploracion.getId())));
    }
    
    @Test
    public void canFindOneUnique() throws SQLException, DataBaseException {
        when(hibernateTemplate.find("Select new Exploracion(analisisObservacionalMarcha,controlMotorSelectivo,evaluacionMuscular,fecha,fechaActualizacion, id,longitudMiembroDerecho,longitudMiembroIzquierdo,puntuacion500Metros,puntuacion50Metros,puntuacion5Metros,usuario.id, caderaFlexionIzquierda,caderaFlexionDerecha,caderaInflexionIzquierda,caderaInflexionDerecha,rodillaFlexionIzquierda,rodillaFlexionDerecha,rodillaInflexionIzquierda,rodillaInflexionDerecha,tobilloFlexionIzquierda,tobilloFlexionDerecha,tobilloInflexionIzquierda,tobilloInflexionDerecha) from Exploracion where ID_EXPLORACION = ?",AN_ID))
        					  .thenReturn(exploraciones());
        			
        Exploracion exploracion = exploracionRepository.findOneUnique(AN_ID);
        
		assertThat(AN_ID, is(equalTo(exploracion.getId())));
    }
    
    @Test
    public void canFindReducedListByPatient() throws SQLException, DataBaseException {
    	List<Exploracion> exploracion = exploraciones();
        when(hibernateTemplate.find("Select new Exploracion(id,fecha,usuario.apellidos,usuario.id,usuario.nombre) from Exploracion where ID_PACIENTE = ?", AN_ID))
        					  .thenReturn(exploracion);
        			
        List<Exploracion> result = exploracionRepository.findReducedListByPatient(AN_ID);
        
		assertThat(exploracion, is(equalTo(result)));
    }
    
    @Test
    public void canFindAll() throws SQLException, DataBaseException {
    	List<Exploracion> exploraciones = exploraciones();
        when(hibernateTemplate.loadAll(Exploracion.class)).thenReturn(exploraciones);
        			
        List<Exploracion> result = exploracionRepository.findAll();
        
		assertThat(exploraciones, is(equalTo(result)));
    }
    
    private List<Exploracion> exploraciones(){
    	List<Exploracion> listaExploraciones = new ArrayList<Exploracion>();
    	listaExploraciones.add(exploracion());
    	return listaExploraciones;
    }
    
    private Exploracion exploracion(){
    	Exploracion e = new Exploracion();
		e.setId(AN_ID);
    	
		return e;
    }
}