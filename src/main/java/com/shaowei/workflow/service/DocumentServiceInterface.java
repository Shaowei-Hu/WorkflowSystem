package com.shaowei.workflow.service;

import java.util.List;

import com.shaowei.workflow.model.Comment;
import com.shaowei.workflow.model.Decision;
import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.History;
import com.shaowei.workflow.model.User;

public interface DocumentServiceInterface {
	
	public boolean addDocument(Document document, User author);
	public Document getFullDocument(int documentId);
	public List<Document> getAllDocuments();
	public boolean addComment(Comment comment, User author);
	public boolean transferDocument(Decision decision);
	public Document getDocumentByComment(Comment comment);
	public List<Document> getAllDocumentByIntervenor(int userId);
	public List<History> getHistoriesByDocumentId(int documentId);
	public List<Document> getAllDocumentByResponsible(int userId);

}
