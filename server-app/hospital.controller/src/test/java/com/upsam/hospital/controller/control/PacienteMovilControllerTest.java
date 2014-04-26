package com.upsam.hospital.controller.control;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
import com.upsam.hospital.controller.dto.VideoDTO;
import com.upsam.hospital.controller.dto.util.IExploracionUtilDTO;
import com.upsam.hospital.controller.dto.util.IPacienteMovilUtilDTO;
import com.upsam.hospital.controller.dto.util.IVideoUtilDTO;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.FicheroEMT;
import com.upsam.hospital.model.beans.Video;
import com.upsam.hospital.model.service.IExploracionService;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IVideoService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PacienteMovilControllerTest {
	
	private static final int FICHERO_EMT_ID = 1523;
	private static final int FICHERO_EMT_INFO_ID = 1523;
	private static final int PACIENTE_ID = 11355;
	private static final int EXPLORACION_ID = 1123;
	private static final int VIDEO_ID = 12;
	
	@Mock
	private IPacienteService pacienteService;

	@Mock
	private IPacienteMovilUtilDTO pacienteMovilUtilDTO;

	@Mock
	private IVideoService videoService;
	
	@Mock
	private IExploracionService exploracionService;

	@Mock
	private IVideoUtilDTO videoUtilDTO;

	@Mock
	private IExploracionUtilDTO exploracionUtilDTO;

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
    	List<FicheroEMT> ficherosEMT = aListOfFicherosEMT();
    	when(ficheroEMTService.findByExploracion(EXPLORACION_ID)).thenReturn(ficherosEMT);
    	when(exploracionUtilDTO.getFicherosEMTInfoList(ficherosEMT)).thenReturn(aListOfFicheroEMTInfoDTO());
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/"+PACIENTE_ID+"/exploracion/"+EXPLORACION_ID+"/ficherosEMT"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$[0].id").value(FICHERO_EMT_INFO_ID));
    }
    
    @Test
    public void CanAnswerIsBadRequestWhenCanNotParseToIntUrlParams() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/"+PACIENTE_ID+"/exploracion/12222222222222222222/ficherosEMT"))
									        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    @Test
    public void canFindFicheroEMT() throws Exception{
    	FicheroEMT ficheroEmt = aFicheroEMT();
    	when(ficheroEMTService.findOneUnique(FICHERO_EMT_ID)).thenReturn(ficheroEmt);
    	when(exploracionUtilDTO.fileEMTToDTO(ficheroEmt)).thenReturn(aFicheroEMTDTO());

        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/"+PACIENTE_ID+"/exploracion/"+EXPLORACION_ID+"/ficheroEMT/"+FICHERO_EMT_ID))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$.id").value(FICHERO_EMT_ID));
    }
    
    @Ignore
    public void getVideoFromPaciente() throws Exception{
    	Video video = new Video();
    	VideoDTO videoDTO = new VideoDTO();
    	videoDTO.setId(VIDEO_ID);
    	when(videoService.findOne(PACIENTE_ID, EXPLORACION_ID, VIDEO_ID)).thenReturn(video);
    	when(videoUtilDTO.toRest(video)).thenReturn(videoDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/"+PACIENTE_ID+"/exploracion/"+EXPLORACION_ID+"/video/"+VIDEO_ID))
									        .andExpect(MockMvcResultMatchers.status().isOk())
									        .andExpect(content().contentType("application/json;charset=UTF-8"))
											.andExpect(jsonPath("$.id").value(VIDEO_ID));
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void getAllVideosFromPaciente() throws Exception{
    	Video video = new Video();
    	List<VideoDTO> videos = new ArrayList<VideoDTO>();
    	VideoDTO videoDTO = new VideoDTO();
    	videoDTO.setId(VIDEO_ID);
    	video.setId(VIDEO_ID);
    	videos.add(videoDTO);
    	when(exploracionService.findOne(EXPLORACION_ID)).thenReturn(anExploracion());
    	when(videoUtilDTO.getVideosList(anyList())).thenReturn(videos);
    	
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientemovil/"+PACIENTE_ID+"/exploracion/"+EXPLORACION_ID+"/video"))
									        .andExpect(MockMvcResultMatchers.status().isOk())
											.andExpect(jsonPath("$[0].id").value(VIDEO_ID));
    }

    private List<FicheroEMTInfoDTO> aListOfFicheroEMTInfoDTO() {
		List<FicheroEMTInfoDTO> files = new ArrayList<FicheroEMTInfoDTO>();
    	files.add(aFicheroEMTinfoDTO());
		return files;
	}

	private List<FicheroEMT> aListOfFicherosEMT() {
		List<FicheroEMT> ficherosEMT = new ArrayList<FicheroEMT>();
    	ficherosEMT.add(aFicheroEMT());
		return ficherosEMT;
	}
    
    private FicheroEMTInfoDTO aFicheroEMTinfoDTO() {
		FicheroEMTInfoDTO ficheroEMTInfoDTO = new FicheroEMTInfoDTO();
    	ficheroEMTInfoDTO.setId(FICHERO_EMT_INFO_ID);
		return ficheroEMTInfoDTO;
	}
    
    private FicheroEMT aFicheroEMT() {
		FicheroEMT ficheroEmt = new FicheroEMT();
    	ficheroEmt.setId(FICHERO_EMT_ID);
		return ficheroEmt;
	}
    
    private FicheroEMTDTO aFicheroEMTDTO() {
		FicheroEMTDTO ficheroEMTDTO = new FicheroEMTDTO();
    	ficheroEMTDTO.setId(FICHERO_EMT_ID);
		return ficheroEMTDTO;
	}
    
    private Exploracion anExploracion() {
		Exploracion exploracion = new Exploracion();
    	exploracion.setId(EXPLORACION_ID);
		return exploracion;
	}
}
