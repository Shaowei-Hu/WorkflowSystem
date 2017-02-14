package com.shaowei.workflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	
	@Column(name="NEXT_STEP_ID")
	private int nextStepId;
	
	@Column(name="NEXT_STEP_NAME_ID")
	private String nextStepNameId;
	
	

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
	public StepAdvanced getStepAdvanced() {
		return stepAdvanced;
	}
	public void setStepAdvanced(StepAdvanced step) {
		this.stepAdvanced = step;
	}
	public String getDecisionId() {
		return decisionId;
	}
	public void setDecisionId(String decisionId) {
		this.decisionId = decisionId;
	}
	public int getNextStepId() {
		return nextStepId;
	}
	public void setNextStepId(int nextStepId) {
		this.nextStepId = nextStepId;
	}
	public String getNextStepNameId() {
		return nextStepNameId;
	}
	public void setNextStepNameId(String nextStepNameId) {
		this.nextStepNameId = nextStepNameId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((decision == null) ? 0 : decision.hashCode());
		result = prime * result + ((decisionId == null) ? 0 : decisionId.hashCode());
		result = prime * result + id;
		result = prime * result + nextStepId;
		result = prime * result + ((nextStepNameId == null) ? 0 : nextStepNameId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StepDecision other = (StepDecision) obj;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (decision == null) {
			if (other.decision != null)
				return false;
		} else if (!decision.equals(other.decision))
			return false;
		if (decisionId == null) {
			if (other.decisionId != null)
				return false;
		} else if (!decisionId.equals(other.decisionId))
			return false;
		if (id != other.id)
			return false;
		if (nextStepId != other.nextStepId)
			return false;
		if (nextStepNameId == null) {
			if (other.nextStepNameId != null)
				return false;
		} else if (!nextStepNameId.equals(other.nextStepNameId))
			return false;
		return true;
	}
	

	
	
	

}
