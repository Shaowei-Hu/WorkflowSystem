package com.shaowei.workflow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shaowei.workflow.model.KeyValue;

public interface UserMapper {
	
 
	 
	 
	 @Select("SELECT CONCAT_WS(\" - \", JOB, NAME) as value, USER_ID as keyy FROM wkf_user WHERE JOB=#{job}")
	 public List<KeyValue> getUserKVByJob(String job);
	 
	 @Select("SELECT NAME as value, USER_ID as keyy FROM wkf_user")
	 public List<KeyValue> getAllUsers();
	 

}
