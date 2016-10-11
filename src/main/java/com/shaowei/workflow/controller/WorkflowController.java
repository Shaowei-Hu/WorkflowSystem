package com.shaowei.workflow.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.workflow.model.KeyValue;
import com.shaowei.workflow.model.StepSimple;
import com.shaowei.workflow.service.WorkflowService;

@Controller
@RequestMapping(value="/workflow")
public class WorkflowController {
	
	@Resource
	WorkflowService workflowService;
	
	@RequestMapping(value="/getDecisionByStepId/{stepId}", method = RequestMethod.GET)
	public @ResponseBody List<KeyValue> getDecisionByStepId(@PathVariable String stepId){		
		return workflowService.getDecisionByStepId(stepId);
	}
	
	@RequestMapping(value="/getWorkflow")
	public @ResponseBody List<StepSimple> getWorkflow(){
		return workflowService.getWorkflow();
	}
	
	@RequestMapping(value="/getWorkflowTable")
	public String getWorkfow(){
		return "workflowViews/showWorkflow";
	}
	
	@RequestMapping(value="/updateWorkflow", method = RequestMethod.GET)
	public String updateWorkfow(){
		return "workflowViews/updateWorkflow";
	}
	
	@RequestMapping(value="/showStep/{stepId}", method = RequestMethod.GET)
	public String showStep(@PathVariable String stepId, Model model){
		List<StepSimple> steps = workflowService.getStepSimpleByStepId(stepId);
		model.addAttribute("steps", steps);
		return "workflowViews/updateWorkflowStep";
	}
	
	@RequestMapping(value="/updateWorkflow", method = RequestMethod.POST)
	public String updateWorkfow(StepSimple stepSimple, String[] system, String[] decision, String[] condition, String[] nextStep){

		workflowService.updateWorkflow(stepSimple, system, decision, condition, nextStep);
		return "workflowViews/updateWorkflow";
	}
	
	@RequestMapping(value="/addWorkflowStep", method = RequestMethod.GET)
	public String addWorkfowStep(StepSimple stepSimple, String[] system, String[] decision, String[] condition, String[] nextStep){
		return "workflowViews/addWorkflowStep";
	}

}
