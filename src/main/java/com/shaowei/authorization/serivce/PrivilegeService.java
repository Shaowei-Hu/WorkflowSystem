package com.shaowei.authorization.serivce;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.authorization.repository.PrivilegeRepository;

@Service
public class PrivilegeService {
	@Resource
	PrivilegeRepository privilegeRepository;
	
	public List<Privilege> getAll(){
		return privilegeRepository.getAll();
	}
	
	public boolean addPrivilege(Privilege privilege){
		privilegeRepository.add(privilege);
		return true;
	}

}
