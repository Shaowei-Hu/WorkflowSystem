package com.shaowei.workflow.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shaowei.workflow.model.Decision;
import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core-test-config.xml"})
public class DocumentServiceIntTest {
	
	@Autowired
	private DocumentService documentService;
	@Autowired
	private UserService userService;
	@Autowired
	private Decision decision1, decision2, decision3, decision4, decision5, decision6, decision7, decision8;
	
	static List<Decision> decisions;
	
	@Autowired
	private Document document4test;
	private Integer generatedId;
	
	

	public void init() {
		decisions = new ArrayList<>();
		decisions.add(decision1);
		decisions.add(decision2);
		decisions.add(decision3);
		decisions.add(decision4);
		decisions.add(decision5);
		decisions.add(decision6);
		decisions.add(decision7);
//		decisions.add(decision8);
		
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");
		Date date = new Date();
		document4test.setClient(document4test.getClient() + "_" + formater.format(date));
	}
	
	@Test
	public void testGetAllDocument(){
		List<Document> documents = documentService.getAllDocuments();
		
		assertThat(documents).isNotEmpty();
	}
	
	@Test
	public void testDocumentLifeCircle() {
		init();
		testCreateDocument();
		testTraficInWorkflow();
			
	}
	
	public void testCreateDocument() {
		User firstTrader = userService.getUserById(1);
		generatedId = documentService.addDocument(document4test, firstTrader);
		
		List<Document> documents = documentService.getAllDocuments();
		assertThat(documents).extracting("client", String.class).contains(document4test.getClient());
		
		assertThat(documentService.getAllDocumentByResponsible(firstTrader.getUserId())).extracting("client", String.class).contains(document4test.getClient());
		assertThat(documentService.getAllDocumentByIntervenor(firstTrader.getUserId())).extracting("client", String.class).doesNotContain(document4test.getClient());
		
		Document document = documentService.getFullDocument(generatedId);
		
		assertThat(document.getClient()).isEqualTo(document4test.getClient());
		assertThat(document.getAmount()).isEqualByComparingTo(new BigDecimal(10000.00));
		assertThat(document.getResource()).isEqualByComparingTo(new BigDecimal(800.00));
	}
	
	public void testTraficInWorkflow() {
		for(Decision d : decisions){
			d.setDocumentId(generatedId);
		}
		
		Document document = documentService.getFullDocument(generatedId);
		
		for(int i=0; i<decisions.size(); i++){
			User responsiblePrecedent = document.getResponsible();
			System.out.println(responsiblePrecedent.getUserName() + ":::" + decisions.get(i).getComment());	
			
			try {
				Thread.sleep(1023);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			documentService.transferDocument(decisions.get(i));
			
			assertThat(documentService.getAllDocumentByResponsible(responsiblePrecedent.getUserId())).extracting("client", String.class).doesNotContain(document4test.getClient());
			assertThat(documentService.getAllDocumentByIntervenor(responsiblePrecedent.getUserId())).extracting("client", String.class).contains(document4test.getClient());
			
			document = documentService.getFullDocument(generatedId);
			User responsibleCurrent = document.getResponsible();
			assertThat(documentService.getAllDocumentByResponsible(responsibleCurrent.getUserId())).extracting("client", String.class).contains(document4test.getClient());	
		}
	}

}
