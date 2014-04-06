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

import com.upsam.hospital.model.beans.Faqs;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.repository.IFaqsRepository;
import com.upsam.hospital.model.repository.impl.FaqsRepository;

public class FaqsRepositoryTest extends UnitTest{

    @Mock
    private HibernateTemplate hibernateTemplate;
    @InjectMocks
    private IFaqsRepository faqsRepository = new FaqsRepository();

    @Test
    public void canSaveAFaq() throws SQLException, DataBaseException {
        Faqs faqs = aFaqs();
        			
        faqsRepository.save(faqs);
		
		verify(hibernateTemplate, times(1)).save(faqs);
    }
    
    @Test
    public void canUpdateAFaq() throws SQLException, DataBaseException {
    	Faqs faqs = aFaqs();
    	faqs.setDescripcion("upsam");
        			
    	faqsRepository.update(faqs);
		
		verify(hibernateTemplate, times(1)).update(faqs);
    }
    
    @Test
    public void canDeleteAFaq() throws SQLException, DataBaseException {
    	Faqs faqs = aFaqs();
        			
    	faqsRepository.delete(faqs);
		
		verify(hibernateTemplate, times(1)).delete(faqs);
    }
    
    @Test
    public void canFindAFaq() throws SQLException, DataBaseException {
    	Faqs faqs = aFaqs();
        when(hibernateTemplate.get(Faqs.class,178)).thenReturn(faqs);
        			
        Faqs expectedFaqs = faqsRepository.findOne(178);
        
		assertThat("anyDescription", is(equalTo(expectedFaqs.getDescripcion())));
    }
    
    private Faqs aFaqs(){
    	Faqs p = new Faqs();
		p.setId(178);
		p.setDescripcion("anyDescription");
		return p;
    }
}
