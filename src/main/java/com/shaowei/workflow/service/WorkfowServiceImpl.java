package com.shaowei.workflow.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.StepAdvancedRepository;
import com.shaowei.workflow.model.StepAdvanced;
import com.shaowei.workflow.model.StepDecision;
import com.shaowei.workflow.model.StepSimple;

@Service
public class WorkfowServiceImpl implements WorkflowService{

	@Resource
	private StepAdvancedRepository stepAdvancedRepository;
	
	@Override
	public StepAdvanced getStepAdvancedById(int id) {
		
		return stepAdvancedRepository.get(id);
	}

	@Override
	public String getServiceByStepId(int stepId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStepNameByStepId(String stepId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StepAdvanced getStepsByStepId(String stepId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StepAdvanced getFullStepById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StepAdvanced> getWorkflowByVersion(String version) {
		return stepAdvancedRepository.getWorkflowByVersion(version);
	}

	@Override
	public boolean createNewWorkflow(String version) {
		StepAdvanced step = new StepAdvanced();
		step.setVersion(version);
		step.setStepId("00");
		step.setPhase("Init");
		step.setStepName("Initial step");
		try {
			stepAdvancedRepository.add(step);
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addWorkflowStep(String workflowVersion, StepSimple stepSimple, String[] decision, String[] decisionId,String[] condition, String[] nextStepId) {
		List<StepDecision> decisions = new ArrayList<>();
		
		
		StepAdvanced step = new StepAdvanced();
		step.setVersion(workflowVersion);
		step.setStepId(stepSimple.getStep_id());
		step.setStepName(stepSimple.getStep_name());
		step.setPhase(stepSimple.getPhase());
		step.setService(stepSimple.getService());

		
		for(int i=0; i<decision.length; i++){//One decision technical is added in the step creation jsp for add new decisions, and we don't persist this one so length-1
			if(!"".equals(decision[i])){
				StepDecision stepDecision = new StepDecision();
				stepDecision.setCondition(condition[i]);
				stepDecision.setDecision(decision[i]);
				stepDecision.setDecisionId(decisionId[i]);
				if(!nextStepId[i].contains("-")){
					StepAdvanced nextStep = this.getStepAdvancedById(Integer.parseInt(nextStepId[i]));
					stepDecision.setNextStepId(nextStep.getId());
					stepDecision.setNextStepNameId(nextStep.getStepId());
				}
					
//				else
//					stepDecision.setNextStep(step); //Hiberate does not allow next step to be null, so I set the next step to the step himself if user doesn't set one.

				stepDecision.setStepAdvanced(step);// may cause stack overflow error (it is not this cause stack over flow error, it is json transformer who may cause the problem)
				decisions.add(stepDecision);
			}
			
		}
		
		step.setDecisions(decisions);

		try {
			stepAdvancedRepository.add(step);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public List<String> getWorkflowVersions() {
		return stepAdvancedRepository.getWorkflowVersions();
	}

	@Override
	public boolean deleteStep(String idString) {
		int id = Integer.parseInt(idString);
		stepAdvancedRepository.delete(id);
		return true;
	}

}
