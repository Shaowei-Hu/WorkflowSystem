package com.shaowei.workflow.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.workflow.model.KeyValue;
import com.shaowei.workflow.model.StepAdvanced;
import com.shaowei.workflow.model.StepSimple;
import com.shaowei.workflow.service.WorkflowService;

@Controller
@RequestMapping(value="/workflow")
public class WorkflowController {
	
	@Resource
	WorkflowService workflowService;
	
	@RequestMapping(value="/getDecisionByStepId/{stepId}", method = RequestMethod.GET)
	public @ResponseBody List<KeyValue> getDecisionByStepId(@PathVariable String stepId){		
//		return workflowService.getDecisionByStepId(stepId);
		return null;
	}
	
	@RequestMapping(value="/workflow/{version}")
	public @ResponseBody List<StepAdvanced> getWorkflow(@PathVariable String version){
		return workflowService.getWorkflowByVersion(version);
//		return null;
	}
	
	@RequestMapping(value="/getWorkflowTable")
	public String getWorkfow(){
		return "workflowViews/showWorkflow";
	}
	
	@RequestMapping(value="/updateWorkflow", method = RequestMethod.GET)
	public String updateWorkfow(){
		return "workflowViews/updateWorkflow";
	}
	
	
	@RequestMapping(value="/updateWorkflow", method = RequestMethod.POST)
	public String updateWorkfow(StepSimple stepSimple, String[] system, String[] decision, String[] condition, String[] nextStep){

//		workflowService.updateWorkflow(stepSimple, system, decision, condition, nextStep);
		return "workflowViews/updateWorkflow";
	}
	
	@RequestMapping(value="/addWorkflowStep/{version}", method = RequestMethod.GET)
	public String addWorkfowStep(@PathVariable String version, Model model){
		model.addAttribute("workflowVersion", version);
		return "workflowViews/addWorkflowStep";
	}
	
	@RequestMapping(value="/createWorkflowPage", method = RequestMethod.GET)
	public String createWorkflowPage(){
		return "workflowViews/createWorkflowPage";
	}
	
	@RequestMapping(value="/newWorkflow", method = RequestMethod.POST)
	public String createNewWorkflow(String workflowVersion, Model model){
		model.addAttribute("workflowVersion", workflowVersion);
		workflowService.createNewWorkflow(workflowVersion);
		return "workflowViews/addWorkflowStep";
	}
	
	
	@RequestMapping(value="/workflowStep", method = RequestMethod.POST)
	public String createWorkflowStep(String workflowVersion, StepSimple stepSimple, 
			String[] decision, String[] decisionId, String[] condition, String[] nextStep, Model model){
		workflowService.addWorkflowStep(workflowVersion, stepSimple, decision, decisionId, condition, nextStep);
		model.addAttribute("workflowVersion", workflowVersion);
		return "workflowViews/addWorkflowStep";
	}
	
	@RequestMapping(value="/workflowVersion", method = RequestMethod.GET)
	public @ResponseBody List<String> getWorkflowVersions(){
		return workflowService.getWorkflowVersions();
	}
	
	@RequestMapping(value="/workflowStep/{id}", method = RequestMethod.DELETE)
	public String deleteWorkflowStep(@PathVariable String id){
		workflowService.deleteStep(id);
		return "workflowViews/updateWorkflow";
	}
	
	@RequestMapping(value="/step/{id}", method = RequestMethod.GET)
	public String showStep(@PathVariable String id, Model model){
		StepAdvanced step = workflowService.getStepAdvancedById(id);	
		model.addAttribute("step", step);
		return "workflowViews/updateWorkflowStep";
	}
	
	@RequestMapping(value="/updateWorkflowStep", method = RequestMethod.POST)
	public String updateWorkflowStep(@ModelAttribute("step") StepAdvanced step, 
			String[] decisionId, String[] decisionNameId, String[] condition, String[] decision,  String[] nextStep){
		workflowService.updateWorkflowStep(step, decisionId, decisionNameId, condition, decision, nextStep);
		return "workflowViews/updateWorkflow";
	}

}
