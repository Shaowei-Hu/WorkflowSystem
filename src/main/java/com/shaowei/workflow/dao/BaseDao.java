package com.shaowei.workflow.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T extends Serializable> extends HibernateDaoSupport implements Dao<T>{
	
	Class<T> type;
	
	@Resource(name="sessionFactory")
	public void setMySessionFactory(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	BaseDao() {
		
	}
	
	BaseDao(Class<T> type) {
		this.type=type;
	}

	
	public void add(T t) {
		getHibernateTemplate().save(t);
		
	}


	public void delete(T t) {
		getHibernateTemplate().delete(t);
		
	}


	public void delete(int id) {
		T t = getHibernateTemplate().get(type, id);
		getHibernateTemplate().delete(t);
		
	}

	
	public void update(T t) {
		getHibernateTemplate().update(t);
		
	}

	
	public T get(int id) {
		
		return getHibernateTemplate().get(type, id);
	}

	
	public List<T> getAll() {
		
		return getHibernateTemplate().loadAll(type);
	}

	public void save(T t) {
		getHibernateTemplate().save(t);
		
	}

}
