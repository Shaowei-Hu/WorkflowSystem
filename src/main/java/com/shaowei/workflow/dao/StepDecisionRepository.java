package com.shaowei.workflow.dao;

import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.StepDecision;

@Repository
public class StepDecisionRepository extends BaseDao<StepDecision>{

	StepDecisionRepository(){
		super(StepDecision.class);
	}
		
}

