package com.shaowei.workflow.service;

import java.util.List;

import com.shaowei.workflow.model.StepAdvanced;
import com.shaowei.workflow.model.StepSimple;

public interface WorkflowService {
	
	
	public String getServiceByStepId(int stepId);
	public String getStepNameByStepId(String stepId);
	public StepAdvanced getStepsByStepId(String stepId);
	public StepAdvanced getFullStepById(int id);
	
	
	public StepAdvanced getStepAdvancedById(String id);
	public List<StepAdvanced> getWorkflowByVersion(String version);
	public boolean createNewWorkflow(String version);
	public boolean addWorkflowStep(String workflowVersion, StepSimple stepSimple, String[] decision, String[] decisionId, String[] condition, String[] nextStep);
	public List<String> getWorkflowVersions();
	public boolean deleteStep(String id);
	public boolean updateWorkflowStep(StepAdvanced step, String[] decisionId, String[] decisionNameId, String[] condition, String[] decision, String[] nextStep);
	public boolean deleteDecision(String id);

	
}
