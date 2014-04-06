package unit.repositories;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.orm.hibernate3.HibernateTemplate;

import unit.UnitTest;

import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.impl.PacienteRepository;

public class PacienteRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private PacienteRepository pacienteRepository = new PacienteRepository();

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
    
    private Paciente aPatient(){
    	Paciente p = new Paciente();
		p.setId(178);
		p.setApellidos("any");
		return p;
    }
}
