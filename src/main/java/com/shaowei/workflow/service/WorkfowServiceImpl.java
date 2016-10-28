package com.shaowei.workflow.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.StepAdvancedRepository;
import com.shaowei.workflow.dao.StepDecisionRepository;
import com.shaowei.workflow.exception.CustomGenericException;
import com.shaowei.workflow.model.StepAdvanced;
import com.shaowei.workflow.model.StepDecision;
import com.shaowei.workflow.model.StepSimple;

@Service
public class WorkfowServiceImpl implements WorkflowService{

	@Resource
	private StepAdvancedRepository stepAdvancedRepository;
	
	@Resource
	StepDecisionRepository stepDecisionRepository;
	
	@Override
	public StepAdvanced getStepAdvancedById(String idString) {
		int id = Integer.parseInt(idString);
		return stepAdvancedRepository.get(id);
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
					StepAdvanced nextStep = this.getStepAdvancedById(nextStepId[i]);
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

	@Override
	public boolean updateWorkflowStep(StepAdvanced step, 
			String[] decisionId, String[] decisionNameId, String[] condition, String[] decision,  String[] nextStepId) {
		

		StepAdvanced stepAdvanced = stepAdvancedRepository.get(step.getId());
		stepAdvanced.setVersion(step.getVersion());
		stepAdvanced.setStepId(step.getStepId());
		stepAdvanced.setStepName(step.getStepName());
		stepAdvanced.setPhase(step.getPhase());
		stepAdvanced.setService(step.getService());

		
		for(int i=0; i<decision.length; i++){//One decision technical is added in the step creation jsp for add new decisions, and we don't persist this one so length-1
			if(!"".equals(decision[i])){
				if(i<stepAdvanced.getDecisions().size()){
					StepDecision stepDecision = stepAdvanced.getDecisions().get(i);
					stepDecision.setCondition(condition[i]);
					stepDecision.setDecision(decision[i]);
					stepDecision.setDecisionId(decisionId[i]);
					if(!"".equals(nextStepId[i])&&!nextStepId[i].contains("-")){
						StepAdvanced nextStep = this.getStepAdvancedById(nextStepId[i]);
						if(nextStep==null){
							throw new CustomGenericException("500", "Workflow step null or next step null");
						}
						stepDecision.setNextStepId(nextStep.getId());
						stepDecision.setNextStepNameId(nextStep.getStepId());
					}
				} else {
					StepDecision stepDecision = new StepDecision();
					stepDecision.setCondition(condition[i]);
					stepDecision.setDecision(decision[i]);
					stepDecision.setDecisionId(decisionId[i]);
					if(!nextStepId[i].contains("-")){
						StepAdvanced nextStep = this.getStepAdvancedById(nextStepId[i]);
						stepDecision.setNextStepId(nextStep.getId());
						stepDecision.setNextStepNameId(nextStep.getStepId());
					}
					stepDecision.setStepAdvanced(step);// may cause stack overflow error (it is not this cause stack over flow error, it is json transformer who may cause the problem)
					stepAdvanced.getDecisions().add(stepDecision);
					
				}

			}
			
		}
		
		stepAdvancedRepository.update(stepAdvanced);
		
		return false;
	}

	@Override
	public boolean deleteDecision(String id) {
		stepDecisionRepository.delete(Integer.parseInt(id));
		return false;
	}

	@Override
	public StepDecision getDecision(String id) {
		return stepDecisionRepository.get(Integer.parseInt(id));
	}


}
