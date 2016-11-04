package com.shaowei.workflow.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.Document;

@Repository
public class DocumentDao extends BaseDao<Document>{
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	@Resource
	DocumentMapper documentMapper;

	DocumentDao(){
		super(Document.class);
	}
	
	public Document getFullDocument(int documentId){
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Document.class);
		criteria.add(Restrictions.eq("documentId", documentId));

		@SuppressWarnings("unchecked")
		List<Document> documents = criteria.list();
		Document document = null;
		if(documents!=null && documents.size()>0){
			document = documents.get(0);
			Hibernate.initialize(document.getComments());
			Hibernate.initialize(document.getHistory());
			Hibernate.initialize(document.getIntervenors());
			Hibernate.initialize(document.getLectors());

		}
		session.getTransaction().commit();
		return document;
	}
	
	public List<Document> getDocumentByResiponble(int responsibleId) {		
//		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();

		try {
//			DocumentMapper documentMapper = sqlSession.getMapper(DocumentMapper.class);
//			return documentMapper.getAllDocumentByResponsible(responsibleId);
			return documentMapper.getAllDocumentByResponsible(responsibleId);
		} finally {
//			sqlSession.close();
		}

	}
	
	public List<Document> getDocumentByIntervenor(int intervenorId){
		return documentMapper.getAllDocumentByIntervenor(intervenorId);
	}
	
}
