package com.shaowei.workflow.model;

import java.io.Serializable;


public class StepSimple implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5004519918038632155L;
	

	private int id;
	

	private String step_id;

	private String step_name;
	

	private String phase;

	private String decision;

	private String condition;
	
	private String service;
	

	private String autority;
	
	private String next_step_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStep_id() {
		return step_id;
	}

	public void setStep_id(String step_id) {
		this.step_id = step_id;
	}

	public String getStep_name() {
		return step_name;
	}

	public void setStep_name(String step_name) {
		this.step_name = step_name;
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


	public String getAutority() {
		return autority;
	}

	public void setAutority(String autority) {
		this.autority = autority;
	}

	public String getNext_step_id() {
		return next_step_id;
	}

	public void setNext_step_id(String next_step_id) {
		this.next_step_id = next_step_id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}


	
	

}
