package com.shaowei.workflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.History;
@Repository
public class HistoryDao extends BaseDao<History>{

	HistoryDao(){
		super(History.class);
	}
	
	public List<History> getHistoriesByDocument(Document document){
		
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(History.class);
		criteria.add(Restrictions.eq("document", document));
		criteria.addOrder(Order.asc("date"));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<History> histories = criteria.list();
		for(History h : histories){
			Hibernate.initialize(h.getStepDecision().getStepAdvanced());
		}
		session.getTransaction().commit();
		return histories;
	}
}
