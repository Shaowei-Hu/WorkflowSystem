package com.shaowei.workflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="wkf_comment")
public class Comment implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = -654209921316096797L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMMENT_ID")
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name="AUTHOT_ID")
	private User author;
	@ManyToOne
	@JoinColumn(name="DOCUMENT_ID")
	private Document document;
	
	@Column(name="NOTATION", length=8)
	private String notation;
	@Column(name="NOTICE", length=16)
	private String notice;
	@Column(name="COMMENT", length=128)
	private String comment;
	
	@Transient
	private int documentId;
	
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getNotation() {
		return notation;
	}
	public void setNotation(String notation) {
		this.notation = notation;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	
	
	

}
