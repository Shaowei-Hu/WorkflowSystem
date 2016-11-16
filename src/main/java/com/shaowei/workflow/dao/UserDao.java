package com.shaowei.workflow.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shaowei.workflow.dto.KeyValue;
import com.shaowei.workflow.model.User;

@Repository
public class UserDao extends BaseDao<User>{
	
	@Resource
	UserMapper userMapper;
	
	public UserDao(){
		super(User.class);
	}
	
	public User getUserByName(String name) {
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", name));

		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		session.getTransaction().commit();
		if (users==null || users.size()==0)
			return null;
		else
			return users.get(0);
	}
	
	public List<User> getUsersByJob(String job){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("job", job));
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		session.getTransaction().commit();
		return users;
	}
	
	public List<KeyValue> getUserJobByJob(String job){
		return userMapper.getUserKVByJob(job);
	}
	
	public List<KeyValue> getAllUserKeyValue(){
		return userMapper.getAllUsers();
	}
	
	public User getUserWithRole(int id){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, id);
		Hibernate.initialize(user.getRoles());	
		session.getTransaction().commit();
		return user;

	}

}
