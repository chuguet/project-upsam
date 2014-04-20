package com.upsam.hospital.controller.control;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.After;
import org.junit.Before;
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

import com.upsam.hospital.controller.dto.ChangePasswordDTO;
import com.upsam.hospital.controller.dto.PacienteDTO;
import com.upsam.hospital.controller.dto.UsuarioDTO;
import com.upsam.hospital.controller.dto.util.IPacienteUtilDTO;
import com.upsam.hospital.controller.dto.util.IUsuarioUtilDTO;
import com.upsam.hospital.controller.util.TestUtils;
import com.upsam.hospital.model.beans.Paciente;
import com.upsam.hospital.model.beans.Usuario;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IFicheroEMTService;
import com.upsam.hospital.model.service.IFicheroMDXService;
import com.upsam.hospital.model.service.IPacienteService;
import com.upsam.hospital.model.service.IUsuarioService;
import com.upsam.hospital.util.mail.service.IMailUtil;
@RunWith(MockitoJUnitRunner.class)
public class UsuarioControllerTests {

	    @Mock
	    private IUsuarioService usuarioService;
	    @Mock
	    private IMailUtil mailUtil;
	    @Mock
	    private IUsuarioUtilDTO usuarioUtilDTO;
	    @InjectMocks
	    @Spy
	    private UsuarioController usuarioController;

	    private MockMvc mockMvc;

	    @Before
	    public void setup() {
	        mockMvc = MockMvcBuilders.standaloneSetup(this.usuarioController).build();
	    }

	    @After
	    public void teardown() {
	        mockMvc = null;
	    }
	    
		@Test
	    public void canUpdate() throws Exception{
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setNombre("nombre");
			
	        mockMvc.perform((post("/usuario/1/")
	        		.content(TestUtils.convertObjectToJsonBytes(usuarioDTO))
	        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("Usuario modificado correctamente"))
	        						.andExpect(jsonPath("$.correcto").value(true));
	    }
    
	    @Test
	    public void whenIdToUpdateIsNullThenUnsupportedMediaTypeIsAnswered() throws Exception{
	    	String id = null;
	    	
	        mockMvc.perform(MockMvcRequestBuilders.post("/usuario/"+id))
	                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
	    }
    
	    @Test
	    public void whenIdToUpdateIsEmptyThenUnsupportedMediaTypeIsAnswered() throws Exception{
	    	String id = "";
	    	
	        mockMvc.perform(MockMvcRequestBuilders.post("/usuario/"+id))
	                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
	    }
	    
	    @Test
	    public void canRemove() throws Exception{
	    	
	        mockMvc.perform(MockMvcRequestBuilders.delete("/usuario/1"))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("Usuario eliminado correctamente"))
	        						.andExpect(jsonPath("$.correcto").value(true));
	    }
	    
	    @Test
	    public void whenIdToRemoveIsNullThenBadResponseIsAnswered() throws Exception{
	    	String id = null;
	    	
	        mockMvc.perform(MockMvcRequestBuilders.delete("/usuario/"+id))
	                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
	    }
	    
	    @Test
	    public void whenIdToRemoveIsEmptyThenNotAllowIsAnswered() throws Exception{
	    	String id = "";
	    	
	        mockMvc.perform(MockMvcRequestBuilders.delete("/usuario/"+id))
	                                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
	    }
	    
	    @Test
	    public void whenIdIsEmptyThenFindAll() throws Exception{
	    	String id = "";
	    	
	        mockMvc.perform(MockMvcRequestBuilders.get("/usuario/"+id))
	                                .andExpect(MockMvcResultMatchers.status().isOk());
	        
	        verify(usuarioService, times(1)).findAll();
	    }
	    
	    @Test
	    public void canListAll() throws Exception{
	    	Usuario usuario = new Usuario();
	    	usuario.setNombre("anyName");
	    	List<Usuario> usuarios = new ArrayList<Usuario>();
	    	usuarios.add(usuario);
	    	UsuarioDTO usuarioDTO = new UsuarioDTO();
	    	usuarioDTO.setNombre(usuario.getNombre());
	    	when(usuarioService.findAll()).thenReturn(usuarios);
	    	when(usuarioUtilDTO.toRest(usuario)).thenReturn(usuarioDTO);
	    	
	        mockMvc.perform(MockMvcRequestBuilders.get("/usuario"))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$[0].nombre").value("anyName"));
	    }
	    
	    @Test
	    public void whenIdIsNullThenBadResponseIsAnswered() throws Exception{
	    	String id = null;
	    	
	        mockMvc.perform(MockMvcRequestBuilders.get("/usuario/"+id))
	                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
	    }
	    
	    @Test
	    public void canRetrieve() throws Exception{
	    	Usuario usuario = new Usuario();
	    	usuario.setNombre("anyName");
	    	UsuarioDTO usuarioDTO = new UsuarioDTO();
	    	usuarioDTO.setNombre(usuario.getNombre());
	    	when(usuarioService.findOne(1)).thenReturn(usuario);
	    	when(usuarioUtilDTO.toRest(usuario)).thenReturn(usuarioDTO);
	    	
	        mockMvc.perform(MockMvcRequestBuilders.get("/usuario/1"))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.nombre").value("anyName"));
	    }
	    
	    @Test
	    public void canInsert() throws Exception{
	    	UsuarioDTO usuarioDTO = new UsuarioDTO();
	    	usuarioDTO.setId(1);
	    	usuarioDTO.setUser("testUser");
	    	
	        mockMvc.perform((post("/usuario/")
	        		.content(TestUtils.convertObjectToJsonBytes(usuarioDTO))
	        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("Usuario creado correctamente"))
	        						.andExpect(jsonPath("$.correcto").value(true));
	    }
	    
	    @Test
	    public void canShowMessageWhenErrorOnInsert() throws Exception{
	    	Usuario usuario = new Usuario();
	    	UsuarioDTO usuarioDTO = new UsuarioDTO();
	    	usuarioDTO.setId(1);
	    	usuarioDTO.setUser("testUser");
	    	when(usuarioUtilDTO.toBusiness(usuarioDTO)).thenReturn(usuario);
	    	when(usuarioService.save(any(Usuario.class))).thenThrow(new DataBaseException());
	    	
	        mockMvc.perform((post("/usuario/")
	        		.content(TestUtils.convertObjectToJsonBytes(usuarioDTO))
	        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("Ya existe el usuario testUser en base de datos."))
	        						.andExpect(jsonPath("$.correcto").value(false));
	    }
	    
	    @Test
	    public void whenPacienteToInsertIsNullThenUnsupportedMediaTypeIsAnswered() throws Exception{
	    	UsuarioDTO usuarioDTO = null;
	    	
	        mockMvc.perform(MockMvcRequestBuilders.post("/usuario/").content(TestUtils.convertObjectToJsonBytes(usuarioDTO)))
	                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
	    }
	    
	    @Test
	    public void whenPacienteToInserIsEmptyThenUnsupportedMediaTypeIsAnswered() throws Exception{
	    	
	        mockMvc.perform(MockMvcRequestBuilders.post("/usuario/").content(TestUtils.convertObjectToJsonBytes("")))
	                                .andExpect(MockMvcResultMatchers.status().isUnsupportedMediaType());
	    }
	    
	    @Test
	    public void canChangePassword() throws Exception{
	    	Usuario usuario = new Usuario();
	    	usuario.setId(1);
	    	usuario.setGenerate_token(new Date());
	    	ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
	    	changePasswordDTO.setToken("token");
	    	when(usuarioService.selectByToken(any(String.class))).thenReturn(usuario);
	    	
	        mockMvc.perform((post("/usuario/changePassword")
	        		.content(TestUtils.convertObjectToJsonBytes(changePasswordDTO))
	        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("Su contrase&ntilde;a ha sido modificada correctamente."))
	        						.andExpect(jsonPath("$.correcto").value(true));
	    }
	    
	    @Test
	    public void whenTokenTimeIsNotValidThenCanNotChangePassword() throws Exception{
	    	Usuario usuario = new Usuario();
	    	usuario.setId(1);
	    	Date customDate = new Date();
	    	customDate.setTime(new Date().getTime() - 400000);
	    	usuario.setGenerate_token(customDate);
	    	ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
	    	changePasswordDTO.setToken("token");
	    	when(usuarioService.selectByToken(any(String.class))).thenReturn(usuario);
	    	
	        mockMvc.perform((post("/usuario/changePassword")
	        		.content(TestUtils.convertObjectToJsonBytes(changePasswordDTO))
	        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("Han pasado m&aacute;s de 5 minutos. Vuelva a realizar el proceso."))
	        						.andExpect(jsonPath("$.correcto").value(false));
	    }
	    
	    @Test
	    public void whenNoUserByEmailThenCanNotChangePassword() throws Exception{
	    	ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
	    	changePasswordDTO.setToken("token");
	    	when(usuarioService.selectByToken(any(String.class))).thenReturn(null);
	    	
	        mockMvc.perform((post("/usuario/changePassword")
	        		.content(TestUtils.convertObjectToJsonBytes(changePasswordDTO))
	        		.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)))
	                                .andExpect(MockMvcResultMatchers.status().isOk())
	                                .andExpect(content().contentType("application/json;charset=UTF-8"))
									.andExpect(jsonPath("$.mensaje").value("El token ha cambiado. Introduzca el token del ultimo mail."))
	        						.andExpect(jsonPath("$.correcto").value(false));
	    }
}
