package com.upsam.hospital.model.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.enums.ParteDelCuerpo;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFaqRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class FaqsServiceTest extends UnitTest{

    @Mock
    private IFaqRepository faqsRepository;
    @InjectMocks
    private FaqService faqsService;
     
    @Test
    public void canSaveAFaq() throws SQLException, DataBaseException {
        Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
        			
        faqsService.save(faq);
		
		verify(faqsRepository, times(1)).save(faq);
    }
    
    @Test
    public void canUpdateAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
        			
        faqsService.update(faq);
		
		verify(faqsRepository, times(1)).update(faq);
    }
    
    @Test
    public void canDeleteAFaq() throws SQLException, DataBaseException {
    	Faq faqs = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
        			
    	faqsService.delete(faqs);
		
		verify(faqsRepository, times(1)).delete(faqs);
    }
    
    @Test
    public void canFindAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
    	when(faqsRepository.findOne(178)).thenReturn(faq);
        			
        Faq expectedFaqs = faqsService.findOne(178);
		
		assertThat("anyDescription", is(equalTo(expectedFaqs.getDescripcion())));
    }
    
    @Test
    public void canFindAllFaqsBySection() throws SQLException, DataBaseException {
    	List<Faq> faqs = createFaqsListWithSize(5);
    	when(faqsRepository.findBySeccion(ParteDelCuerpo.HOMBRO.name())).thenReturn(faqs);
        			
    	List<Faq> expectedFaqs = faqsService.findBySeccion(ParteDelCuerpo.HOMBRO.name());
		
    	assertThat(expectedFaqs, is(equalTo(faqs)));
    }
    
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
    		faqs.add(aFaqWith(178, ParteDelCuerpo.HOMBRO.name()));
		}
    	
    	return faqs;
    }
    
    private Faq aFaqWith(int id, String section){
    	Faq p = new Faq();
		p.setId(id);
		p.setSeccion(section);
		p.setDescripcion("anyDescription");
		return p;
    }
}
