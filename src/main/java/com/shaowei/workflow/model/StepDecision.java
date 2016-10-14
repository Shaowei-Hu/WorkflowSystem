package com.shaowei.workflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity(name="wkf_workflow_decision")
public class StepDecision implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7595021060386929540L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="STEP_ID")
	private StepAdvanced stepAdvanced;
	
	@Column(name="DECISION_ID", length=8)
	private String decisionId;
	
	@Column(name="DECISION", length=64)
	private String decision;
	
	@Column(name="CONDITIONN", length=64)
	private String condition;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="NEXT_STEP_ID")
	private StepAdvanced nextStep;
	
	

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
	public StepAdvanced getNextStep() {
		return nextStep;
	}
	public void setNextStep(StepAdvanced nextStep) {
		this.nextStep = nextStep;
	}
	public StepAdvanced getStep() {
		return stepAdvanced;
	}
	public void setStep(StepAdvanced step) {
		this.stepAdvanced = step;
	}
	public String getDecisionId() {
		return decisionId;
	}
	public void setDecisionId(String decisionId) {
		this.decisionId = decisionId;
	}

	
	
	

}
