package com.shaowei.workflow.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.CommentDao;
import com.shaowei.workflow.dao.DocumentDao;
import com.shaowei.workflow.exception.WorkflowDeniedException;
import com.shaowei.workflow.model.Comment;
import com.shaowei.workflow.model.Decision;
import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.History;
import com.shaowei.workflow.model.StepAdvanced;
import com.shaowei.workflow.model.StepDecision;
import com.shaowei.workflow.model.User;

@Service
public class DocumentServiceImpl implements DocumentService{

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

	public Integer addDocument(Document document, User author) {
		Integer generatedId;
		try {
			String amount = document.getAmountSt();
			amount = amount.replaceAll(",", "");
			document.setAmount(new BigDecimal(amount));
			String resource = document.getResourceSt();
			resource = resource.replaceAll(",", "");
			document.setResource(new BigDecimal(resource));
			document.setAuthor(author);
			document.setResponsible(author);
			StepAdvanced currentStep = workflowService.getStepAdvancedById("2");
			document.setCurrentStep(currentStep);
			document.setStepDate(new Date());

			generatedId = (Integer) documentDao.add(document);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return generatedId;
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
		List<Document> documents = documentDao.getDocumentByResiponble(responsibleId);
//		if(documents.get(0)!=null)
//		System.out.println("Current step name : " + documents.get(0));
		return documents;
	}
	
	public List<Document> getAllDocumentByIntervenor(int intervenorId){
		return documentDao.getDocumentByIntervenor(intervenorId);
	}
	
	
	public boolean transferDocument(Decision decision){
		
		try {
			Date transferDate = new Date();
			int documentId = decision.getDocumentId();
			int nextResponsibleId = decision.getDestinationId();
//			StepAdvanced step = workflowService.getStepAdvancedById(decision.getDecisionId()+"");
			StepDecision stepDecision = workflowService.getDecision(decision.getDecisionId()+"");

			StepAdvanced nextStep = workflowService.getStepAdvancedById(stepDecision.getNextStepId()+"");
			
			Document document = getFullDocument(documentId);
			StepAdvanced currentStep = document.getCurrentStep();

			if(!currentStep.getDecisions().contains(stepDecision))
				throw new WorkflowDeniedException("Decision not match current workflow");
			
			User nextResponsible = userService.getUserById(nextResponsibleId);
			User responsible = document.getResponsible();
			
			document.getIntervenors().add(responsible);
			document.setResponsible(nextResponsible);
			document.setCurrentStep(nextStep);
			document.setStepDate(transferDate);
			documentDao.update(document);
			
			
			History history = new History();
			history.setDate(transferDate);
			history.setDocument(document);
			history.setMessage(decision.getComment());
			history.setResponsible(responsible);
			history.setNextResponsible(nextResponsible);
			history.setStepDecision(stepDecision);
			history.setStepAdvanced(currentStep);
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

	@Override
	public void deleteDocument(int id) {
		documentDao.delete(id);		
	}
}
