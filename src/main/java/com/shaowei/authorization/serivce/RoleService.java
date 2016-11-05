package com.shaowei.authorization.serivce;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.authorization.domain.Role;
import com.shaowei.authorization.dto.RoleDto;
import com.shaowei.authorization.repository.RoleRepository;

@Service
public class RoleService {

	@Resource
	RoleRepository roleRepository;
	@Resource
	PrivilegeService privilegeService;
	
	public boolean addRole(RoleDto roleDto){
		try {
			Role role = new Role();
			role.setRoleName(roleDto.getRoleName());
			role.setDescription(roleDto.getDescription());
			List<Privilege> privileges = new ArrayList<>();
			for(Integer i : roleDto.getPrivilegesId()){
				privileges.add(privilegeService.getPrivilege(i));
			}
			role.setPrivileges(privileges);
			roleRepository.add(role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean updateRole(RoleDto roleDto){
		try {
			Role role = new Role();
			role.setId(roleDto.getId());
			role.setRoleName(roleDto.getRoleName());
			role.setDescription(roleDto.getDescription());
			List<Privilege> privileges = new ArrayList<>();
			for(Integer i : roleDto.getPrivilegesId()){
				privileges.add(privilegeService.getPrivilege(i));
			}
			role.setPrivileges(privileges);
			roleRepository.update(role);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Role> getAllRole(){
		return roleRepository.getAll();
	}
	
	public Role getRole(String id){
		return roleRepository.get(Integer.parseInt(id));
	}
	
	public Role getRoleWithPrivilege(String id){
		return roleRepository.getRoleWithPrivilege(Integer.parseInt(id));
	}
	
	public boolean deleteRole(String id){
		roleRepository.delete(Integer.parseInt(id));
		return true;
	}
}
