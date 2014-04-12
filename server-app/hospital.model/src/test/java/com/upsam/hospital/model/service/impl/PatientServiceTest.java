package com.upsam.hospital.model.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import java.sql.SQLException;

import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IPacienteRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class PatientServiceTest extends UnitTest{

    @Mock
    private IPacienteRepository pacienteRepository;
    @InjectMocks
    private PacienteService pacienteService;
     
    @Test
    public void canSaveAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        			
		pacienteService.save(paciente);
		
		verify(pacienteRepository, times(1)).save(paciente);
    }
    
    @Test
    public void canUpdateAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        paciente.setApellidos("upsam");
        			
		pacienteService.update(paciente);
		
		verify(pacienteRepository, times(1)).update(paciente);
    }
    
    @Test
    public void canDeleteAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        			
		pacienteService.delete(paciente);
		
		verify(pacienteRepository, times(1)).delete(paciente);
    }
    
    @Test
    public void canFindAPatient() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        when(pacienteRepository.findOne(178)).thenReturn(paciente);
        			
        Paciente patientFound = pacienteService.findOne(178);
		
		assertThat("any", is(equalTo(patientFound.getApellidos())));
    }
    
    private Paciente aPatient(){
    	Paciente p = new Paciente();
		p.setId(178);
		p.setApellidos("any");
		return p;
    }
}
