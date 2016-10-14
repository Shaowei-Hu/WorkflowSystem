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
		System.out.println(decisions.size());
		
		for(int i=0; i<decision.length-1; i++){//One decision technical is added in the step creation jsp for add new decisions, and we don't persist this one so length-1
			StepDecision stepDecision = new StepDecision();
			stepDecision.setCondition(condition[i]);
			stepDecision.setDecision(decision[i]);
			stepDecision.setDecisionId(decisionId[i]);
			if(!nextStepId[i].contains("-"))
				stepDecision.setNextStep(this.getStepAdvancedById(Integer.parseInt(nextStepId[i])));
			else
				stepDecision.setNextStep(step); //Hiberate does not allow next step to be null, so I set the next step to the step himself if user doesn't set one.
			System.out.println(nextStepId[i]);
			stepDecision.setStep(step);// may cause stack overflow error
			decisions.add(stepDecision);
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

}
