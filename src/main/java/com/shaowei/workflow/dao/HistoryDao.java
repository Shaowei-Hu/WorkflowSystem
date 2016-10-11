package com.shaowei.workflow.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
		@SuppressWarnings("unchecked")
		List<History> histories = criteria.list();
		session.getTransaction().commit();
		return histories;
	}
}
