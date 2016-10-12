package com.shaowei.workflow.service;

import java.util.List;

import com.shaowei.workflow.model.StepAdvanced;

public interface WorkflowService {
	
	public StepAdvanced getStepAdvancedById(int id);
	public String getServiceByStepId(int stepId);
	public String getStepNameByStepId(String stepId);
	public StepAdvanced getStepsByStepId(String stepId);
	public StepAdvanced getFullStepById(int id);
	public List<StepAdvanced> getWorkflowByVersion(String version);
	
}
