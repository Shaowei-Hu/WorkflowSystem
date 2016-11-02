package com.shaowei.authorization.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.authorization.serivce.PrivilegeService;

@Controller
@RequestMapping("/authorization")
public class PrivilegeController {
	
	@Resource
	PrivilegeService privilegeService;
	
	@RequestMapping(value="/privilege", method=RequestMethod.POST)
	public String addPrivilege(@RequestBody Privilege privilege){
		privilegeService.addPrivilege(privilege);
		return "adminViews/showPrivilege";
	}
	
	@RequestMapping(value="/privilege", method=RequestMethod.GET)
	public @ResponseBody List<Privilege> getAllPrivilege(){
		return privilegeService.getAll();
	}
	
	
	@RequestMapping(value="/allPrivilegePage", method=RequestMethod.GET)
	public String allPrivilegePage(){
		return "adminViews/showPrivilege";
	}
	
	@RequestMapping(value="/addPrivilegePage", method=RequestMethod.GET)
	public String addPrivilegePage(){
		return "adminViews/addPrivilege";
	}
}
