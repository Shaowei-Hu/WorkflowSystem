package com.shaowei.workflow.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.StepDao;
import com.shaowei.workflow.dao.WorkflowDao;
import com.shaowei.workflow.model.KeyValue;
import com.shaowei.workflow.model.Step;
import com.shaowei.workflow.model.StepSimple;

@Service
public class WorkflowService {

	@Resource
	WorkflowDao workflowDao;
	@Resource
	private StepDao stepDao;
	
	public List<KeyValue> getDecisionByStepId(String stepId){
		return workflowDao.getDecisionByStepId(stepId);
	}
	
	public String getServiceByStepId(int id){
		return workflowDao.getServiceById(id);
	}
	
	public Step getFullStepById(int id){
		return stepDao.getFullStep(id);
	}
	
	public String getStepNameByStepId(String stepId){
		List<Step> steps = stepDao.getStepByStepId(stepId);
		return stepId + "-" + steps.get(0).getStepName();
	}
	
	public List<Step> getStepsByStepId(String stepId){
		if(stepId.length()==1) stepId = "0" + stepId;
		return stepDao.getStepByStepId(stepId);
	}
	
	public List<StepSimple> getWorkflow(){
		return workflowDao.getWorkflow();
	}
	
	public List<StepSimple> getStepSimpleByStepId(String stepId){
		if(stepId.length()==1) stepId = "0" + stepId;
		return workflowDao.getStepSimpleByStepId(stepId);
	}
	
	public boolean updateWorkflow(StepSimple stepSimple, String id[], String[] decision, String[] condition, String[] nextStep){
		for(int i=0; i<id.length; i++ ){
			String systemId = id[i];
			if(id!=null&&!"".equals(systemId)){
				Step step = stepDao.get(Integer.parseInt(systemId));
				step.setDecision(decision[i]);
//				step.setCondition(condition[i]);
//				int nextId = Integer.parseInt(nextStep[i]);
				Step next = this.getStepsByStepId(nextStep[i]).get(0);
				step.setNextStep(next);
				stepDao.update(step);
			} else {
				if(nextStep[i].substring(0, 1).equals("-")) continue;
				Step step = new Step();
				step.setAutority(stepSimple.getAutority());
				step.setCondition(condition[i]);
				step.setDecision(decision[i]);
				
				Step next = this.getStepsByStepId(nextStep[i]).get(0);
				step.setNextStep(next);
				step.setPhase(stepSimple.getPhase());
				step.setService(stepSimple.getService());
				step.setStepId(stepSimple.getStep_id());
				step.setStepName(stepSimple.getStep_name());
				stepDao.add(step);
			}

		}
		return false;
	}
	
	public boolean addWorkflowStep(StepSimple stepSimple, String id[], String[] decision, String[] condition, String[] nextStep) {
		for (int i = 0; i < id.length; i++) {

			if (nextStep[i].substring(0, 1).equals("-"))
				continue;
			Step step = new Step();
			step.setAutority(stepSimple.getAutority());
			step.setCondition(condition[i]);
			step.setDecision(decision[i]);

			int nextId = Integer.parseInt(nextStep[i]);
			Step next = stepDao.get(nextId);
			step.setNextStep(next);
			step.setPhase(stepSimple.getPhase());
			step.setService(stepSimple.getService());
			step.setStepId(stepSimple.getStep_id());
			step.setStepName(stepSimple.getStep_name());
			stepDao.add(step);

		}
		return false;
	}
}
