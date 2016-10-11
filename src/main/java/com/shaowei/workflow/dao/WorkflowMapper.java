package com.shaowei.workflow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shaowei.workflow.model.KeyValue;
import com.shaowei.workflow.model.StepSimple;

public interface WorkflowMapper {
	
 	 
	 @Select("SELECT DECISION as value, ID as keyy FROM wkf_workflow WHERE STEP_ID=#{stepId}")
	 public List<KeyValue> getDecisionByStepId(String stepId);
	 
//	 @Select("SELECT INTERVENORJOB AS value FROM wkf_workflow  WHERE ID=#{id}")
	 @Select("SELECT SERVICE FROM wkf_workflow WHERE STEP_ID = (SELECT NEXT_STEP_ID FROM wkf_workflow  WHERE ID=#{id}) LIMIT 1")
	 public String getNextServiceById(int id);
	 
	 @Select("SELECT * FROM wkf_workflow ORDER BY STEP_ID")
	 public List<StepSimple> getWorkflow();
	 
	 @Select("SELECT * FROM wkf_workflow WHERE STEP_ID=#{stepId}")
	 public List<StepSimple> getStepSimpleByStepId(String stepId);
	 

}
