package com.shaowei.authorization.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.shaowei.authorization.domain.Role;
import com.shaowei.authorization.dto.RoleDto;
import com.shaowei.authorization.serivce.RoleService;

@Controller
@RequestMapping("/authorization")
public class RoleController {
	
	@Resource
	RoleService roleService;
	
	@RequestMapping(value="/role", method=RequestMethod.POST)
	public ResponseEntity<Void> addRole(@RequestBody RoleDto roleDto, UriComponentsBuilder ucBuilder){
		roleService.addRole(roleDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/role/{id}").buildAndExpand(roleDto.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.PUT)
	public ResponseEntity<Role> updateRole(@RequestBody RoleDto roleDto){
		Role currentRole = roleService.updateRole(roleDto);
		if(currentRole == null){
			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Role>(currentRole, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public ResponseEntity<List<Role>> getAllRole(){
		List<Role> roles = roleService.getAllRole();
		if(roles.isEmpty()){
			return new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.GET)
	public ResponseEntity<Role> getRole(@PathVariable String id){
		Role role = roleService.getRoleWithPrivilege(id);
		if(role == null){
			return new ResponseEntity<Role>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Role> deleteRole(@PathVariable String id){
		roleService.deleteRole(id);
		return new ResponseEntity<Role>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/addRolePage", method=RequestMethod.GET)
	public String addRolePage(){
		return "authorizationViews/addRole";
	}
	
	@RequestMapping(value="/getAllRolePage", method=RequestMethod.GET)
	public String getAllRolePage(){
		return "authorizationViews/allRole";
	}
	
	@RequestMapping(value="/showRolePage/{id}", method=RequestMethod.GET)
	public String showRolePage(@PathVariable String id, Model model){
		model.addAttribute("roleId", id);
		return "authorizationViews/showRole";
	}
	
	@RequestMapping(value="/updateAllRolePage", method=RequestMethod.GET)
	public String updateAllRolePage(){
		return "authorizationViews/updateAllRole";
	}
	
	@RequestMapping(value="/updateRolePage/{id}", method=RequestMethod.GET)
	public String updateRolePage(@PathVariable String id, Model model){
		model.addAttribute("roleId", id);
		return "authorizationViews/updateRole";
	}

}
