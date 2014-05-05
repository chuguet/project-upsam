package com.upsam.hospital.model.service.impl;

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
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFaqRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class FaqServiceTest extends UnitTest{

    @Mock
    private IFaqRepository faqsRepository;
    @InjectMocks
    private FaqService faqsService;
     
    @Test
    public void canSaveAFaq() throws SQLException, DataBaseException {
        Faq faq = aFaqWith(178, "pregunta", "respuesta");
        			
        faqsService.save(faq);
		
		verify(faqsRepository, times(1)).save(faq);
    }
    
    @Test
    public void canUpdateAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, "pregunta", "respuesta");
        			
        faqsService.update(faq);
		
		verify(faqsRepository, times(1)).update(faq);
    }
    
    @Test
    public void canDeleteAFaq() throws SQLException, DataBaseException {
    	Faq faqs = aFaqWith(178, "pregunta", "respuesta");

    	faqsService.delete(faqs);
		
		verify(faqsRepository, times(1)).delete(faqs);
    }
    
    @Test
    public void canFindAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, "pregunta", "respuesta");
    	when(faqsRepository.findOne(178)).thenReturn(faq);
        			
        Faq expectedFaqs = faqsService.findOne(178);
		
		assertThat("pregunta", is(equalTo(expectedFaqs.getPregunta())));
		assertThat("respuesta", is(equalTo(expectedFaqs.getRespuesta())));
    }
    
//    @Test
//    public void canFindAllFaqsBySection() throws SQLException, DataBaseException {
//    	List<Faq> faqs = createFaqsListWithSize(5);
//    	when(faqsRepository.findBySeccion(ParteDelCuerpo.HOMBRO.name())).thenReturn(faqs);
//        			
//    	List<Faq> expectedFaqs = faqsService.findBySeccion(ParteDelCuerpo.HOMBRO.name());
//		
//    	assertThat(expectedFaqs, is(equalTo(faqs)));
//    }
    
    @Test
    public void canFindAllFaqs() throws SQLException, DataBaseException {
    	List<Faq> faqs = createFaqsListWithSize(5);
        when(faqsRepository.findAll()).thenReturn(faqs);
        			
        List<Faq> allFaqs = faqsService.findAll();
        
		assertThat(allFaqs, is(equalTo(faqs)));
    }
    
    private List<Faq> createFaqsListWithSize(int size){
    	List<Faq> faqs = new ArrayList<Faq>();
    	
    	for (int i = 0; i < size; i++) {
    		faqs.add(aFaqWith(178, "pregunta", "respuesta"));
		}
    	
    	return faqs;
    }
    
    private Faq aFaqWith(int id, String pregunta, String respuesta){
    	Faq p = new Faq();
		p.setId(id);
		p.setPregunta(pregunta);
		p.setRespuesta(respuesta);
		return p;
    }
}
