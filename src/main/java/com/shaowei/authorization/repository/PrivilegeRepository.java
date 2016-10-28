package com.shaowei.authorization.repository;

import com.shaowei.authorization.domain.Privilege;

public class PrivilegeRepository extends BaseDao<Privilege>{
	
	PrivilegeRepository(){
		super(Privilege.class);
	}

}
