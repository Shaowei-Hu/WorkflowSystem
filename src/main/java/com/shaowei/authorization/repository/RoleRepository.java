package com.shaowei.authorization.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shaowei.authorization.domain.Role;

@Repository
public class RoleRepository extends BaseRepository<Role>{
	
	RoleRepository(){
		super(Role.class);
	}
	
	public Role getRoleWithPrivilege(int id){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Role.class);
		criteria.add(Restrictions.eq("id", id));

		@SuppressWarnings("unchecked")
		List<Role> roles = criteria.list();
		Role role = null;
		if(roles!=null && roles.size()>0){
			role = roles.get(0);
			Hibernate.initialize(role.getPrivileges());
		}
		session.getTransaction().commit();
		return role;
	}

}
