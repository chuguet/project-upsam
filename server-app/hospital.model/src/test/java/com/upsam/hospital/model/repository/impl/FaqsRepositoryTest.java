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

import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.enums.ParteDelCuerpo;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.impl.FaqsRepository;
import com.upsam.hospital.model.unit.UnitTest;

public class FaqsRepositoryTest extends UnitTest{

	@Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private FaqsRepository faqsRepository;

    @Test
    public void canSaveAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
        			
        faqsRepository.save(faq);
		
		verify(hibernateTemplate, times(1)).save(faq);
    }
    
    @Test
    public void canUpdateAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
        			
    	faqsRepository.update(faq);
		
		verify(hibernateTemplate, times(1)).update(faq);
    }
    
    @Test
    public void canDeleteAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
        			
    	faqsRepository.delete(faq);
		
		verify(hibernateTemplate, times(1)).delete(faq);
    }
    
    @Test
    public void canFindAFaq() throws SQLException, DataBaseException {
    	Faq faq = aFaqWith(178, ParteDelCuerpo.HOMBRO.name());
    	when(hibernateTemplate.get(Faq.class,178)).thenReturn(faq);
        			
        Faq expectedFaq = faqsRepository.findOne(178);
        
		assertThat("anyDescription", is(equalTo(expectedFaq.getDescripcion())));
    }
    
    @Test
    public void canFindBySeccion() throws SQLException, DataBaseException {
		List<Faq> faqs = CreateFaqsListWithSize(5);
    	when(hibernateTemplate.find("Select new Faq(id, seccion, fotos, titulo, descripcion) from Faqs where (seccion = ?)", ParteDelCuerpo.HOMBRO.name()))
    		.thenReturn(faqs);
        			
    	List<Faq> expectedFaqs = faqsRepository.findBySeccion(ParteDelCuerpo.HOMBRO.name());
		
    	assertThat(expectedFaqs, is(equalTo(faqs)));
    }
    
    @Test
    public void canFindAllFaqs() throws SQLException, DataBaseException {
        when(hibernateTemplate.loadAll(Faq.class)).thenReturn(CreateFaqsListWithSize(9));
        			
        List<Faq>expectedFaqs = faqsRepository.findAll();
        
		assertThat(9, is(equalTo(expectedFaqs.size())));
    }
    
    private List<Faq> CreateFaqsListWithSize(int size){
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
