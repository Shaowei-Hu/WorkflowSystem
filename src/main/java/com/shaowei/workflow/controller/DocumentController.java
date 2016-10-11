package com.shaowei.workflow.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.workflow.exception.CustomGenericException;
import com.shaowei.workflow.model.Comment;
import com.shaowei.workflow.model.Decision;
import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.History;
import com.shaowei.workflow.model.User;
import com.shaowei.workflow.service.DocumentServiceInterface;
import com.shaowei.workflow.service.UserService;

@Controller
@RequestMapping(value="/document")
public class DocumentController {
	
	@Resource
	UserService userService;
	@Resource
	DocumentServiceInterface documentService;
	

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createDocument(Model model){
		model.addAttribute("document", new Document());
		return "userViews/createWorkflowDocument";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createDocument(Document document, HttpServletRequest request, Model model){
		User author = (User) request.getSession().getAttribute("user");
		if(documentService.addDocument(document, author)){
			model.addAttribute("document", document);
			model.addAttribute("comment", new Comment());
			model.addAttribute("decision", new Decision());
			return "userViews/showWorkflowDocument";
		}
			
		else
			throw new CustomGenericException("200", "Document has not been created, some exceptions have been found");
	}
	
	@RequestMapping(value="/show/{documentId}", method=RequestMethod.GET)
	public String showDocument(@PathVariable int documentId, Model model){
		Document document = documentService.getFullDocument(documentId);
//		List<Step> steps = documentService.getStepsByDocument(document);
		model.addAttribute("document", document);
		model.addAttribute("comment", new Comment());
		model.addAttribute("decision", new Decision());
		return "userViews/showWorkflowDocument";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listDocuments(Model model){
		List<Document> allDocuments = documentService.getAllDocuments();
		model.addAttribute("allDocuments", allDocuments);
		return "userViews/allWorkflowDocuments";
	}
	
	@RequestMapping(value="/myList", method=RequestMethod.GET)
	public String listMyDocuments(Model model, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");	
		List<Document> allDocuments = documentService.getAllDocumentByResponsible(user.getUserId());
		model.addAttribute("allDocuments", allDocuments);
		model.addAttribute("tab", 0);
		return "userViews/allWorkflowDocuments";
	}
	
	@RequestMapping(value="/myintervenedList", method=RequestMethod.GET)
	public String listMyIntervenedDocuments(Model model, HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");	
		List<Document> allDocuments = documentService.getAllDocumentByIntervenor(user.getUserId());
		model.addAttribute("allDocuments", allDocuments);
		model.addAttribute("tab", 1);
		return "userViews/allWorkflowDocuments";
	}
	
	@RequestMapping(value={"/show/addComment", "/addComment"}, method=RequestMethod.POST)
	public String addComment(Comment comment, HttpServletRequest request, Model model){
		User responsible = (User) request.getSession().getAttribute("user");
		boolean sucess = documentService.addComment(comment, responsible);
		if(sucess){
			Document newDocument = documentService.getDocumentByComment(comment);
//			List<Step> steps = documentService.getStepsByDocument(newDocument);
			model.addAttribute("document", newDocument);
			model.addAttribute("comment", new Comment());
			model.addAttribute("decision", new Decision());
			return "userViews/showWorkflowDocument";
		} else
			throw new CustomGenericException("202", "Comment has not been created, some exceptions have been found");
		
	}
	
	@RequestMapping(value="/transfer", method=RequestMethod.POST)
	public String transferDocument(Decision decision){
		if(documentService.transferDocument(decision)){
			return "redirect:myList";
		} else
			throw new CustomGenericException("500", "Something error document has not been transfered");
	}
	
	@RequestMapping(value="/history/{documentId}")
	public @ResponseBody List<History> getHistoriesByDocumentId(@PathVariable int documentId){
		return documentService.getHistoriesByDocumentId(documentId);
	}

}
