package com.shaowei.workflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.Step;
@Repository
public class StepDao extends BaseDao<Step>{
	
	StepDao(){
		super(Step.class);
	}

	public List<Step> getStepByStepId(String stepId){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Step.class);
		criteria.add(Restrictions.eq("stepId", stepId));

		@SuppressWarnings("unchecked")
		List<Step> steps = criteria.list();
		session.getTransaction().commit();
		return steps;
	}
	
	public Step getFullStep(int id){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Step.class);
		criteria.add(Restrictions.eq("id", id));

		@SuppressWarnings("unchecked")
		List<Step> steps = criteria.list();
		Step step = null;
		if(steps!=null && steps.size()>0){
			step = steps.get(0);
			step.getNextStep().getStepName();
		}
		session.getTransaction().commit();
		return step;
	}
}
