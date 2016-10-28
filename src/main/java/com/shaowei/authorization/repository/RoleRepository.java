package com.shaowei.authorization.repository;

import com.shaowei.authorization.domain.Role;

public class RoleRepository extends BaseDao<Role>{
	
	RoleRepository(){
		super(Role.class);
	}

}
