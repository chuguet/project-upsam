package unit.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

import unit.UnitTest;

import java.sql.SQLException;

import com.upsam.hospital.model.beans.Faqs;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFaqsRepository;
import com.upsam.hospital.model.service.IFaqsService;
import com.upsam.hospital.model.service.impl.FaqsService;

public class FaqsServiceTest extends UnitTest{

    @Mock
    private IFaqsRepository faqsRepository;
    @InjectMocks
    private IFaqsService faqsService = new FaqsService();
     
    @Test
    public void canSaveAFaq() throws SQLException, DataBaseException {
        Faqs faqs = aFaqs();
        			
        faqsService.save(faqs);
		
		verify(faqsRepository, times(1)).save(faqs);
    }
    
    @Test
    public void canUpdateAFaq() throws SQLException, DataBaseException {
    	Faqs faqs = aFaqs();
    	faqs.setDescripcion("upsam");
        			
        faqsService.update(faqs);
		
		verify(faqsRepository, times(1)).update(faqs);
    }
    
    @Test
    public void canDeleteAFaq() throws SQLException, DataBaseException {
    	Faqs faqs = aFaqs();
        			
    	faqsService.delete(faqs);
		
		verify(faqsRepository, times(1)).delete(faqs);
    }
    
    @Test
    public void canFindAFaq() throws SQLException, DataBaseException {
    	Faqs faqs = aFaqs();
        when(faqsRepository.findOne(178)).thenReturn(faqs);
        			
        Faqs expectedFaqs = faqsService.findOne(178);
		
		assertThat("anyDescription", is(equalTo(expectedFaqs.getDescripcion())));
    }
    
    private Faqs aFaqs(){
    	Faqs p = new Faqs();
		p.setId(178);
		p.setDescripcion("anyDescription");
		return p;
    }
}
