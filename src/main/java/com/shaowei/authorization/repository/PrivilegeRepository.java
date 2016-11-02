package com.shaowei.authorization.repository;

import org.springframework.stereotype.Repository;

import com.shaowei.authorization.domain.Privilege;

@Repository
public class PrivilegeRepository extends BaseRepository<Privilege>{
	
	PrivilegeRepository(){
		super(Privilege.class);
	}

}
