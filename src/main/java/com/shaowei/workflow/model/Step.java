package com.shaowei.workflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name="wkf_workflow")
public class Step implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5004519918038632155L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="STEP_ID", length=8)
	private String stepId;
	@Column(name="STEP_NAME", length=64)
	private String stepName;
	
	@Column(name="PHASE", length=64)
	private String phase;
	@Column(name="DECISION", length=64)
	private String decision;
	@Column(name="CONDITIONN", length=64)
	private String condition;
	
	@Column(name="SERVICE", length=32)
	private String service;
	@Column(name="AUTORITY", length=16)
	private String autority;
	
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="NEXT_STEP_ID")
	private Step nextStep;
	
	
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonIgnore
	public Step getNextStep() {
		return nextStep;
	}
	public void setNextStep(Step nextStep) {
		this.nextStep = nextStep;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getAutority() {
		return autority;
	}
	public void setAutority(String autority) {
		this.autority = autority;
	}
	
	

}
