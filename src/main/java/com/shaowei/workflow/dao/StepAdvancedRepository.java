package com.shaowei.workflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
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
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<StepAdvanced> stepAdvanceds = criteria.list();

		session.getTransaction().commit();
		return stepAdvanceds;
	}
	
	public List<String> getWorkflowVersions(){
		String sql = "SELECT DISTINCT VERSION FROM WKF_WORKFLOW_STEP";
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		SQLQuery query = session.createSQLQuery(sql);
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		@SuppressWarnings("unchecked")
		List<String> results = query.list();
		session.getTransaction().commit();
		return results;
	}
	
}

