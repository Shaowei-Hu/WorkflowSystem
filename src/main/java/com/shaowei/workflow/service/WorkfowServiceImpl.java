package com.shaowei.workflow.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.StepAdvancedRepository;
import com.shaowei.workflow.model.StepAdvanced;

@Service
public class WorkfowServiceImpl implements WorkflowService2{

	@Resource
	private StepAdvancedRepository stepAdvancedRepository;
	
	@Override
	public StepAdvanced getStepAdvancedById(int id) {
		
		return stepAdvancedRepository.findOne(id);
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
		// TODO Auto-generated method stub
		return null;
	}

}
