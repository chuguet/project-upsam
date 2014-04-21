package com.upsam.hospital.controller.control;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.upsam.hospital.controller.dto.FicheroEMTDTO;
import com.upsam.hospital.controller.dto.FicheroEMTInfoDTO;
import com.upsam.hospital.controller.dto.PacienteMovilDTO;
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IVideoService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PacienteMovilControllerTest {
	@Mock
	private IPacienteService pacienteService;

	@Mock
	private IPacienteMovilUtilDTO pacienteMovilUtilDTO;

	@Mock
	private IVideoService videoService;

	@Mock
	private IVideoUtilDTO videoUtilDTO;

	@Mock
	private IPacienteUtilDTO pacienteUtilDTO;

	@Mock
	private IFicheroEMTService ficheroEMTService;
	@InjectMocks
	private PacienteMovilController pacienteMovilController;
	
	private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.pacienteMovilController).build();
    }

    @After
    public void teardown() {
        mockMvc = null;
    }
    
    @Test
    public void canFindFicherosEMTInfo() throws Exception{
    	List<FicheroEMT> ficherosEMT = new ArrayList<FicheroEMT>();
    	FicheroEMT ficheroEmt = new FicheroEMT();
    	FicheroEMTInfoDTO ficheroEMTInfoDTO = new FicheroEMTInfoDTO();
    	List<FicheroEMTInfoDTO> result = new ArrayList<FicheroEMTInfoDTO>();
    	ficheroEMTInfoDTO.setId(1);
    	result.add(ficheroEMTInfoDTO);
    	ficheroEmt.setId(1);
    	ficherosEMT.add(ficheroEmt);
    	when(ficheroEMTService.findByPaciente(1)).thenReturn(ficherosEMT);
    	when(pacienteUtilDTO.getFicherosEMTInfoList(ficherosEMT)).thenReturn(result);
    	
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/1/ficherosEMT"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$[0].id").value(1));
    }
    
    @Test
    public void canFindFicherosEMTCanAnswerIsBadRequestWhenNullValue() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/null/ficherosEMT"))
									        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void canFindFicheroEMT() throws Exception{
    	FicheroEMT ficheroEmt = new FicheroEMT();
    	FicheroEMTDTO ficheroEMTDTO = new FicheroEMTDTO();
    	ficheroEMTDTO.setId(1);
    	ficheroEmt.setId(1);
    	when(ficheroEMTService.findOne(1)).thenReturn(ficheroEmt);
    	when(pacienteUtilDTO.fileEMTToDTO(ficheroEmt)).thenReturn(ficheroEMTDTO);
    	
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/1/ficheroEMT/1"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$.id").value(1));
    }
    
    @Test
    public void canFindFicheroEMTCanAnswerIsBadRequestWhenNullValue() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/1/ficheroEMT/"+null))
									        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void getVideoFromPaciente() throws Exception{
    	Video video = new Video();
    	VideoDTO videoDTO = new VideoDTO();
    	videoDTO.setId(1);
    	video.setId(1);
    	when(videoService.findOne(1,1)).thenReturn(video);
    	when(videoUtilDTO.toRest(video)).thenReturn(videoDTO);
    	
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/1/video/1"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$.id").value(1));
    }
    
    @Test
    public void getVideoFromPacienteCanAnswerIsBadRequestWhenNullValue() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/1/video/"+null))
									        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void listAll() throws Exception{
    	List<Paciente> pacientes = new ArrayList<Paciente>();
    	Paciente paciente = new Paciente();
    	paciente.setNombre("anyName");
    	paciente.setNumeroIdentificacion("1");
    	pacientes.add(paciente);
    	List<PacienteMovilDTO> pacientesMovilDTO = new ArrayList<PacienteMovilDTO>();
    	PacienteMovilDTO pacienteMovilDTO = new PacienteMovilDTO();
    	pacienteMovilDTO.setId(1);
    	pacienteMovilDTO.setNombre("anyName");
    	pacientesMovilDTO.add(pacienteMovilDTO);
    	when(pacienteService.findByIdNameSurname("anyName")).thenReturn(pacientes);
    	when(pacienteMovilUtilDTO.toRestMovil(paciente)).thenReturn(pacienteMovilDTO);
    	
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil").param("param", "anyName"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$[0].id").value(1));
    }
    
    @Test
    public void listAllResponseBadContent() throws Exception{
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil"))
									        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void getAllVideosFromPaciente() throws Exception{
    	Paciente paciente = new Paciente();
    	paciente.setNombre("anyName");
    	paciente.setNumeroIdentificacion("1");
    	Video video = new Video();
    	List<VideoDTO> videos = new ArrayList<VideoDTO>();
    	VideoDTO videoDTO = new VideoDTO();
    	videoDTO.setId(1);
    	video.setId(1);
    	videos.add(videoDTO);
    	when(pacienteService.findOne(1)).thenReturn(paciente);
    	when(pacienteUtilDTO.getVideosList(anyList())).thenReturn(videos);
    	
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/1/video"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
											.andExpect(jsonPath("$[0].id").value(1));
    }
}
