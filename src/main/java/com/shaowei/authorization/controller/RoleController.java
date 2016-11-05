package com.shaowei.authorization.controller;

import java.util.List;

import javax.annotation.Resource;

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
	public String addRole(@RequestBody RoleDto roleDto){
		roleService.addRole(roleDto);
		return "adminViews/addRole";
	}
	
	@RequestMapping(value="/role", method=RequestMethod.PUT)
	public void updateRole(@RequestBody RoleDto roleDto){
		roleService.updateRole(roleDto);
	}
	
	@RequestMapping(value="/role", method=RequestMethod.GET)
	public @ResponseBody List<Role> getAllRole(){
		return roleService.getAllRole();
	}
	
	@RequestMapping(value="/role/{id}", method=RequestMethod.GET)
	public @ResponseBody Role getRole(@PathVariable String id){
		return roleService.getRoleWithPrivilege(id);
	}
	
	@RequestMapping(value="/addRolePage", method=RequestMethod.GET)
	public String addRolePage(){
		return "adminViews/addRole";
	}
	
	@RequestMapping(value="/getAllRolePage", method=RequestMethod.GET)
	public String getAllRolePage(){
		return "adminViews/allRole";
	}
	
	@RequestMapping(value="/showRolePage/{id}", method=RequestMethod.GET)
	public String showRolePage(@PathVariable String id, Model model){
		model.addAttribute("roleId", id);
		return "adminViews/showRole";
	}

}
