package unit.repositories;

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

import unit.UnitTest;

import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IPacienteRepository;
import com.upsam.hospital.model.repository.impl.VideoRepository;

public class VideoRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private IPacienteRepository videoRepository = new VideoRepository();

    @Test
    public void canSaveAVideo() throws SQLException, DataBaseException {
        Paciente paciente = aPatient();
        			
        videoRepository.save(paciente);
		
		verify(hibernateTemplate, times(1)).save(paciente);
    }
    
    @Test
    public void canUpdateAVideo() throws SQLException, DataBaseException {
    	Paciente paciente = aPatient();
    	paciente.setApellidos("upsam");
        			
    	videoRepository.update(paciente);
		
		verify(hibernateTemplate, times(1)).update(paciente);
    }
    
    @Test
    public void canDeleteAVideo() throws SQLException, DataBaseException {
    	Paciente paciente = aPatient();
        			
    	videoRepository.delete(paciente);
		
		verify(hibernateTemplate, times(1)).delete(paciente);
    }
    
    @Test
    public void canFindAFaq() throws SQLException, DataBaseException {
    	Paciente paciente = aPatient();
        when(hibernateTemplate.get(Paciente.class,178)).thenReturn(paciente);
        			
        Paciente expectedPatient = videoRepository.findOne(178);
        
		assertThat("anyDescription", is(equalTo(expectedPatient.getApellidos())));
    }
    
    @Test
    public void canFindAllVideos() throws SQLException, DataBaseException {
    	List<Paciente> patients = new ArrayList<Paciente>();
    	patients.add(aPatient());
        when(hibernateTemplate.loadAll(Paciente.class)).thenReturn(patients);
        			
        List<Paciente>expectedPatients = videoRepository.findAll();
        
		assertThat(patients, is(equalTo(expectedPatients)));
    }
    
    private Paciente aPatient(){
    	Paciente p = new Paciente();
		p.setId(178);
		p.setApellidos("any");
		return p;
    }
}
