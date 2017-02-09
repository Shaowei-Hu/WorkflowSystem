package com.shaowei.workflow.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shaowei.workflow.model.Document;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core-test-config.xml"})
public class DocumentServiceIntTest {
	
	@Autowired
	DocumentService documentService;
	
	@Test
	public void testGetAllDocument(){
		List<Document> documents = documentService.getAllDocuments();
		
		assertThat(documents).isNotEmpty();
	}

}
