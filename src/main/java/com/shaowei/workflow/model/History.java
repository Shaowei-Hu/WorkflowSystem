package com.shaowei.workflow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="wkf_history")
public class History implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HISTORY_ID")
	private int historyId;
	
	@Column(name="DATE")
	private Date date;
	@ManyToOne
	@JoinColumn(name="STEP_ID")
	private Step step;

	@ManyToOne
	@JoinColumn(name="RESPONSIBLE_ID")
	private User responsible;
	
	@ManyToOne
	@JoinColumn(name="NEXT_RESPONSIBLE_ID")
	private User nextResponsible;

	@ManyToOne
	@JoinColumn(name="DOCUMENT_ID")
	private Document document;
	@Column(name="MESSAGE", length=128)
	private String message;
	
	
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getResponsible() {
		return responsible;
	}
	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Step getStep() {
		return step;
	}
	public void setStep(Step step) {
		this.step = step;
	}
	public User getNextResponsible() {
		return nextResponsible;
	}
	public void setNextResponsible(User nextResponsible) {
		this.nextResponsible = nextResponsible;
	}
	
	
	

}
