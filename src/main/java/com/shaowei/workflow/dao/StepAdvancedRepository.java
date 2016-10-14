package com.shaowei.workflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.StepAdvanced;

@Repository
public class StepAdvancedRepository extends BaseDao<StepAdvanced>{

	StepAdvancedRepository(){
		super(StepAdvanced.class);
	}
	
	public List<StepAdvanced> getWorkflowByVersion(String version){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(StepAdvanced.class);
		criteria.add(Restrictions.eq("version", version));

		@SuppressWarnings("unchecked")
		List<StepAdvanced> stepAdvanceds = criteria.list();

		session.getTransaction().commit();
		return stepAdvanceds;
	}
	
}

