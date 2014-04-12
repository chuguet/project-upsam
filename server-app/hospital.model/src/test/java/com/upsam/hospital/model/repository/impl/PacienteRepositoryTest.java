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

import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.unit.UnitTest;

public class PacienteRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private PacienteRepository pacienteRepository;

    @Test
    public void canSaveAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        			
        pacienteRepository.save(paciente);
		
		verify(hibernateTemplate, times(1)).save(paciente);
    }
    
    @Test
    public void canUpdateAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        paciente.setApellidos("upsam");
        			
        pacienteRepository.update(paciente);
		
		verify(hibernateTemplate, times(1)).update(paciente);
    }
    
    @Test
    public void canDeleteAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        			
        pacienteRepository.delete(paciente);
		
		verify(hibernateTemplate, times(1)).delete(paciente);
    }
    
    @Test
    public void canFindAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        when(hibernateTemplate.get(Paciente.class, 178)).thenReturn(paciente);
        			
        Paciente patientFound = pacienteRepository.findOne(178);
		
		assertThat("any", is(equalTo(patientFound.getApellidos())));
    }
    
    @Test
    public void canFindAllPatients() throws SQLException, DataBaseException {
    	List<Paciente> patients = new ArrayList<Paciente>();
    	patients.add(aPatient());
        when(hibernateTemplate.loadAll(Paciente.class)).thenReturn(patients);
        			
        List<Paciente>expectedPatients = pacienteRepository.findAll();
        
		assertThat(patients, is(equalTo(expectedPatients)));
    }
    
    private Paciente aPatient(){
    	Paciente p = new Paciente();
		p.setId(178);
		p.setApellidos("any");
		return p;
    }
}
