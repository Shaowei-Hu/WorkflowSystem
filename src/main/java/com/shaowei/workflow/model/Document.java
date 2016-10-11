package com.shaowei.workflow.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name="wkf_document")
public class Document implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7751937233717296438L;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOCUMENT_ID")
	private int documentId;
	@JoinColumn(name="CLIENT")
	private String client;
	@JoinColumn(name="AMOUNT")
	private BigDecimal amount;
	@JoinColumn(name="RESOURCE")
	private BigDecimal resource;
	
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private User author;
	
	@ManyToOne
	@JoinColumn(name="RESPONSIBLE_ID")
	private User responsible;
	
	@ManyToMany
	@JoinTable(name="wkf_lector_document", joinColumns={@JoinColumn(name="DOCUMENT_ID")}, inverseJoinColumns={@JoinColumn(name="LECTOR_ID")})
	private Set<User> lectors;
	
	@ManyToMany
	@JoinTable(name="wkf_intervenor_document", joinColumns={@JoinColumn(name="DOCUMENT_ID")}, inverseJoinColumns={@JoinColumn(name="INTERVENOR_ID")})
	private Set<User> intervenors;
	
	@Column(name="CURRENTSTEP", length=64)
	private String currentStep;
	
	@Column(name="STEPDATE")
	private Date stepDate;
	
	@OneToMany(mappedBy="document")
	private List<Comment> comments;
	@OneToMany(mappedBy="document")
	private List<History> history;
	
	

	@Transient
	private String amountSt;
	@Transient
	private String resourceSt;

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getResource() {
		return resource;
	}

	public void setResource(BigDecimal resource) {
		this.resource = resource;
	}
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@JsonIgnore
	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public String getStep() {
		return currentStep;
	}

	public void setStep(String step) {
		this.currentStep = step;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResponsible() {
		return responsible;
	}

	public void setResponsible(User responsible) {
		this.responsible = responsible;
	}

	public Set<User> getLectors() {
		return lectors;
	}
	@JsonIgnore
	public void setLectors(Set<User> lectors) {
		this.lectors = lectors;
	}

	public String getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(String currentStep) {
		this.currentStep = currentStep;
	}
	@JsonIgnore
	public Set<User> getIntervenors() {
		return intervenors;
	}

	public void setIntervenors(Set<User> intervenors) {
		this.intervenors = intervenors;
	}

	public String getAmountSt() {
		return amountSt;
	}

	public void setAmountSt(String amountSt) {
		this.amountSt = amountSt;
	}

	public String getResourceSt() {
		return resourceSt;
	}

	public void setResourceSt(String resourceSt) {
		this.resourceSt = resourceSt;
	}

	public Date getStepDate() {
		return stepDate;
	}

	public void setStepDate(Date stepDate) {
		this.stepDate = stepDate;
	}


	
	
	
	

}
