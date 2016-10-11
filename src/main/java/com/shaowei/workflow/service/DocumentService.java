package com.shaowei.workflow.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.CommentDao;
import com.shaowei.workflow.dao.DocumentDao;
import com.shaowei.workflow.model.Comment;
import com.shaowei.workflow.model.Decision;
import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.History;
import com.shaowei.workflow.model.Step;
import com.shaowei.workflow.model.User;

@Service
public class DocumentService implements DocumentServiceInterface{

	@Resource
	private DocumentDao documentDao;
	@Resource
	private CommentDao commentDao;

	@Resource
	private UserService userService;
	@Resource
	private WorkflowService workflowService;
	@Resource
	private HistoryService historyService;

	public boolean addDocument(Document document, User author) {
		try {
			String amount = document.getAmountSt();
			amount = amount.replaceAll(",", "");
			document.setAmount(new BigDecimal(amount));
			String resource = document.getResourceSt();
			resource = resource.replaceAll(",", "");
			document.setResource(new BigDecimal(resource));
			document.setAuthor(author);
			document.setResponsible(author);
			String currentStep = workflowService.getStepNameByStepId("01");
			document.setCurrentStep(currentStep);
			document.setStepDate(new Date());

			documentDao.add(document);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Document getFullDocument(int documentId){
		return documentDao.getFullDocument(documentId);
	}
	
	public List<Document> getAllDocuments(){
		return documentDao.getAll();
	}
	
	public boolean addComment(Comment comment, User author){
		try {
			Document document = documentDao.get(comment.getDocumentId());
			comment.setDocument(document);
			comment.setAuthor(author);
			commentDao.add(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Document getDocumentByComment(Comment comment){
		return getFullDocument(comment.getDocumentId());
	}
	
	public List<Document> getAllDocumentByResponsible(int responsibleId){
		return documentDao.getDocumentByResiponble(responsibleId);
	}
	
	public List<Document> getAllDocumentByIntervenor(int intervenorId){
		return documentDao.getDocumentByIntervenor(intervenorId);
	}
	

	
	public List<Step> getStepsByDocument(Document document){
		String stepId = document.getCurrentStep().split("-")[0];		
		return workflowService.getStepsByStepId(stepId);
	}
	
	public boolean transferDocument(Decision decision){
		
		try {
			Date transferDate = new Date();
			int documentId = decision.getDocumentId();
			int nextResponsibleId = decision.getDestinationId();
			Step step = workflowService.getFullStepById(decision.getDecisionId());
			Step nextStep = step.getNextStep();

			Document document = getFullDocument(documentId);
			User nextResponsible = userService.getUserById(nextResponsibleId);
			User responsible = document.getResponsible();
			
			document.getIntervenors().add(responsible);
			document.setResponsible(nextResponsible);
			document.setCurrentStep(nextStep.getStepId()+"-"+nextStep.getStepName());
			document.setStepDate(transferDate);
			documentDao.update(document);
			
			
			History history = new History();
			history.setDate(transferDate);
			history.setDocument(document);
			history.setMessage(decision.getComment());
			history.setResponsible(responsible);
			history.setNextResponsible(nextResponsible);
			history.setStep(step);
			historyService.addHistory(history);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<History> getHistoriesByDocumentId(int documentId){
		Document document = documentDao.get(documentId);
		return historyService.getHistoriesByDocument(document);
	}
}
