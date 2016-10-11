package com.shaowei.workflow.dao;

import org.springframework.stereotype.Repository;

import com.shaowei.workflow.model.Comment;

@Repository
public class CommentDao extends BaseDao<Comment>{

	CommentDao(){
		super(Comment.class);
	}
	
}
