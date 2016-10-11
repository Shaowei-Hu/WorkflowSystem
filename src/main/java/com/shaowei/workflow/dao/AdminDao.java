package com.shaowei.workflow.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.Admin;


@Repository
public class AdminDao extends BaseDao<Admin> implements AdminDaoInterface{

	public AdminDao() {
		super(Admin.class);
	}

	public Admin getAdminByName(final String name) {
		
		return super.getHibernateTemplate().execute(new HibernateCallback<Admin>(){

			public Admin doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(Admin.class);
				criteria.add(Restrictions.eq("adminName", name));

				@SuppressWarnings("unchecked")
				List<Admin> admins = criteria.list();
				if (admins==null || admins.size()==0)
					return null;
				else
					return admins.get(0);
			}
			
		});
		
//		Session session = super.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		Criteria criteria = session.createCriteria(Admin.class);
//		criteria.add(Restrictions.eq("adminName", name));
//
//		@SuppressWarnings("unchecked")
//		List<Admin> admins = criteria.list();
//		session.getTransaction().commit();
//		if (admins==null || admins.size()==0)
//			return null;
//		else
//			return admins.get(0);
	}

}
