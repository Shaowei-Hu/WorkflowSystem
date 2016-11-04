package com.shaowei.workflow.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="wkf_workflow_step")
public class StepAdvanced implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 4744891175664788790L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="VERSION", length=16)
	private String version;
	
	@Column(name="STEP_ID", length=8)
	private String stepId;
	@Column(name="STEP_NAME", length=64)
	private String stepName;
	
	@Column(name="PHASE", length=64)
	private String phase;

	
	@Column(name="SERVICE", length=32)
	private String service;
	@Column(name="AUTORITY", length=16)
	private String autority;
	
	//mappedBy an attribute in the other class
	@OneToMany(mappedBy="stepAdvanced", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<StepDecision> decisions;
	
	
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

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public List<StepDecision> getDecisions() {
		return decisions;
	}
	public void setDecisions(List<StepDecision> decisions) {
		this.decisions = decisions;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "StepAdvanced [id=" + id + ", version=" + version + ", stepId=" + stepId + ", stepName=" + stepName + ", phase=" + phase + ", service="
				+ service + ", autority=" + autority + ", decisions=" + decisions + "]";
	}
	
	
	

}
