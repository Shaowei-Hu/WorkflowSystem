package com.shaowei.authorization.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.authorization.domain.Role;
import com.shaowei.authorization.dto.RoleDto;
import com.shaowei.authorization.serivce.RoleService;

@Controller
@RequestMapping("/authorization")
public class RoleController {
	
	@Resource
	RoleService roleService;
	
	@RequestMapping(value="/role", method=RequestMethod.POST)
	public ResponseEntity<Object> addRole(@RequestBody RoleDto roleDto){
		roleService.addRole(roleDto);
		return new ResponseEntity<Object>("OK", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateRole(@RequestBody RoleDto roleDto){
		roleService.updateRole(roleDto);
		return new ResponseEntity<Object>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public @ResponseBody List<Role> getAllRole(){
		return roleService.getAllRole();
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.GET)
	public @ResponseBody Role getRole(@PathVariable String id){
		return roleService.getRoleWithPrivilege(id);
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteRole(@PathVariable String id){
		roleService.deleteRole(id);
		return new ResponseEntity<Object>(id, HttpStatus.OK);
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
