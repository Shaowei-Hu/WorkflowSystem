package com.shaowei.workflow.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.shaowei.workflow.model.Document;
import com.shaowei.workflow.model.User;

public interface DocumentMapper {
	
	 @Select("SELECT * FROM wkf_document WHERE RESPONSIBLE_ID=#{responsibleId} ")
	 @Results({
	  @Result(id=true, property="documentId", column="DOCUMENT_ID"),
	  @Result(property="amount", column="amount"),
	  @Result(property="client", column="client"),
	  @Result(property="resource", column="resource"),
	  @Result(property="currentStep", column="CURRENTSTEP"),
	  @Result(property="stepDate", column="STEPDATE"),
	  @Result(property="author", javaType=com.shaowei.workflow.model.User.class, column="AUTHOR_ID", one=@One(select = "getUser")),
	  @Result(property="responsible", javaType=com.shaowei.workflow.model.User.class, column="RESPONSIBLE_ID", one=@One(select = "getUser"))
	 })
	 public List<Document> getAllDocumentByResponsible(int responsibleId);
	 
	 
//	 @Select("SELECT DOCUMENT_ID FROM wkf_intervenor_document WHERE INTERVENOR_ID=#{intervenorId}")
//	 @Results(value={
//			 @Result(javaType=com.shaowei.workflow.model.Document.class, column="DOCUMENT_ID", one=@One(select = "getDocumentById"))	 
//	 }) 
//	 public List<Document> getAllDocumentByIntervenor(int intervenorId);
	 
	 @Select("SELECT USER_ID as userId, NAME as userName FROM wkf_user WHERE USER_ID=#{userId}")
	 public User getUser(int userId);
	 
	 @Select("SELECT * FROM wkf_document WHERE DOCUMENT_ID=#{documentId}" )
	 @Results({
		  @Result(id=true, property="documentId", column="DOCUMENT_ID"),
		  @Result(property="amount", column="amount"),
		  @Result(property="client", column="client"),
		  @Result(property="resource", column="resource"),
		  @Result(property="currentStep", column="CURRENTSTEP"),
		  @Result(property="author", javaType=com.shaowei.workflow.model.User.class, column="AUTHOR_ID", one=@One(select = "getUser")),
		  @Result(property="responsible", javaType=com.shaowei.workflow.model.User.class, column="RESPONSIBLE_ID", one=@One(select = "getUser"))
		 })
	 public Document getDocumentById(int documentId);
	 
	 
	 @Select("SELECT * FROM wkf_intervenor_document i join wkf_document d on i.DOCUMENT_ID=d.DOCUMENT_ID and INTERVENOR_ID=#{intervenorId}")
	 @Results(value = {
		  @Result(id=true, property="documentId", column="DOCUMENT_ID"),
		  @Result(property="amount", column="amount"),
		  @Result(property="client", column="client"),
		  @Result(property="resource", column="resource"),
		  @Result(property="currentStep", column="CURRENTSTEP"),
		  @Result(property="stepDate", column="STEPDATE"),
		  @Result(property="author", javaType=com.shaowei.workflow.model.User.class, column="AUTHOR_ID", one=@One(select = "getUser")),
		  @Result(property="responsible", javaType=com.shaowei.workflow.model.User.class, column="RESPONSIBLE_ID", one=@One(select = "getUser"))
		 })
	 public List<Document> getAllDocumentByIntervenor(int intervenorId);

}
