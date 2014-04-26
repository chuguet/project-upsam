package com.upsam.hospital.controller.control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.util.TestUtils;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IFicheroMDXService;
import com.upsam.hospital.model.service.IPacienteService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PacienteControllerTest {
	    
    @Mock
    private ServletContext servletContext;
    @Mock
    private IPacienteUtilDTO pacienteUtilDTO;
    @Mock
    private IFicheroMDXService ficheroMDXService;
    @Mock
    private IFicheroEMTService ficheroEMTService;
    @Mock
    private IPacienteService pacienteService;
    @InjectMocks
    @Spy
    private PacienteController pacienteController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.pacienteController).build();
    }

    @After
    public void teardown() {
        mockMvc = null;
    }
    
    @Test
    public void whenIdIsNullThenBadResponseIsAnswered() throws Exception{
    	String id = null;
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/paciente/"+id))
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void whenIdIsEmptyThenFindAll() throws Exception{
    	String id = "";
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/paciente/"+id))
                                .andExpect(MockMvcResultMatchers.status().isOk());
        
        verify(pacienteService, times(1)).findAll();
    }
    
    @Test
    public void canListAll() throws Exception{
    	Paciente paciente = new Paciente();
    	paciente.setNombre("anyName");
    	List<Paciente> pacientes = new ArrayList<Paciente>();
    	pacientes.add(paciente);
    	PacienteDTO pacienteDTO = new PacienteDTO();
    	pacienteDTO.setNombre(paciente.getNombre());
    	when(pacienteService.findAll()).thenReturn(pacientes);
    	when(pacienteUtilDTO.toRest(paciente)).thenReturn(pacienteDTO);
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/paciente"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(content().contentType("application/json;charset=UTF-8"))
								.andExpect(jsonPath("$[0].nombre").value("anyName"));
    }
    
    @Test
    public void canRetrieve() throws Exception{
    	Paciente paciente = new Paciente();
    	paciente.setNombre("anyName");
    	PacienteDTO pacienteDTO = new PacienteDTO();
    	pacienteDTO.setNombre(paciente.getNombre());
    	when(pacienteService.findOne(1)).thenReturn(paciente);
    	when(pacienteUtilDTO.toRest(paciente)).thenReturn(pacienteDTO);
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/paciente/1"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(content().contentType("application/json;charset=UTF-8"))
								.andExpect(jsonPath("$.nombre").value("anyName"));
    }
    
    @Test
    public void canRemove() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/1"))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(content().contentType("application/json;charset=UTF-8"))
								.andExpect(jsonPath("$.mensaje").value("Paciente eliminado correctamente"))
        						.andExpect(jsonPath("$.correcto").value(true));
    }
    
    @Test
    public void whenIdToRemoveIsNullThenBadResponseIsAnswered() throws Exception{
    	String id = null;
    	
        mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/"+id))
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void whenIdToRemoveIsEmptyThenNotAllowIsAnswered() throws Exception{
    	String id = "";
    	
        mockMvc.perform(MockMvcRequestBuilders.delete("/paciente/"+id))
                                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }
    
    @Test
    public void canUpdate() throws Exception{
    	PacienteDTO pacienteDTO = new PacienteDTO();
    	pacienteDTO.setNombre("nombre");
    	
        mockMvc.perform((post("/paciente/1/")
        		.content(TestUtils.convertObjectToJsonBytes(pacienteDTO))
        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(content().contentType("application/json;charset=UTF-8"))
								.andExpect(jsonPath("$.mensaje").value("Paciente modificado correctamente"))
        						.andExpect(jsonPath("$.correcto").value(true));
    }
    
    @Test
    public void whenIdToUpdateIsNullThenUnsupportedMediaTypeIsAnswered() throws Exception{
    	String id = null;
    	
        mockMvc.perform(MockMvcRequestBuilders.post("/paciente/"+id))
                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    }
    
    @Test
    public void whenIdToUpdateIsEmptyThenUnsupportedMediaTypeIsAnswered() throws Exception{
    	String id = "";
    	
        mockMvc.perform(MockMvcRequestBuilders.post("/paciente/"+id))
                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    }
    
    @Test
    public void canInsert() throws Exception{
    	PacienteDTO pacienteDTO = new PacienteDTO();
    	pacienteDTO.setNombre("nombre");
    	
        mockMvc.perform((post("/paciente/")
        		.content(TestUtils.convertObjectToJsonBytes(pacienteDTO))
        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(content().contentType("application/json;charset=UTF-8"))
								.andExpect(jsonPath("$.mensaje").value("Paciente creado correctamente"))
        						.andExpect(jsonPath("$.correcto").value(true));
    }
    
    @Test
    public void canShowMessageWhenErrorOnInsert() throws Exception{
    	Paciente paciente = new Paciente();
    	paciente.setNombre("anyName");
    	paciente.setNumeroIdentificacion("12");
    	PacienteDTO pacienteDTO = new PacienteDTO();
    	pacienteDTO.setNombre(paciente.getNombre());
    	pacienteDTO.setNumeroIdentificacion("12");
    	when(pacienteUtilDTO.toBusiness(pacienteDTO)).thenReturn(paciente);
    	when(pacienteService.save(any(Paciente.class))).thenThrow(new DataBaseException());
    	
        mockMvc.perform((post("/paciente/")
        		.content(TestUtils.convertObjectToJsonBytes(pacienteDTO))
        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(content().contentType("application/json;charset=UTF-8"))
								.andExpect(jsonPath("$.mensaje").value("Ya existe el paciente con el numero de identificacion 12 en base de datos."))
        						.andExpect(jsonPath("$.correcto").value(false));
    }
    
    @Test
    public void whenPacienteToInsertIsNullThenUnsupportedMediaTypeIsAnswered() throws Exception{
    	PacienteDTO pacienteDTO = null;
    	
        mockMvc.perform(MockMvcRequestBuilders.post("/paciente/").content(TestUtils.convertObjectToJsonBytes(pacienteDTO)))
                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    }
    
    @Test
    public void whenPacienteToInserIsEmptyThenUnsupportedMediaTypeIsAnswered() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/paciente/").content(TestUtils.convertObjectToJsonBytes("")))
                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
    }
}
