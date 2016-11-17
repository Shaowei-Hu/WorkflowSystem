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

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.authorization.serivce.PrivilegeService;
import com.shaowei.workflow.dto.RequestObject;

@Controller
@RequestMapping("/authorization")
public class PrivilegeController {
	
	@Resource
	PrivilegeService privilegeService;
	
	@RequestMapping(value="/privilege", method=RequestMethod.POST)
	public ResponseEntity<Object> addPrivilege(@RequestBody Privilege privilege){
		privilegeService.addPrivilege(privilege);
		return new ResponseEntity<Object>("OK", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/privilege", method=RequestMethod.GET)
	public @ResponseBody List<Privilege> getAllPrivilege(){
		return privilegeService.getAll();
	}
	
	@RequestMapping(value="/privilege/{id}", method=RequestMethod.GET)
	public @ResponseBody Privilege getPrivilege(@PathVariable String id){
		return privilegeService.getPrivilege(id);
	}
	
	@RequestMapping(value="/privilege", method=RequestMethod.PUT)
	public ResponseEntity<Object> updatePrivilege(@RequestBody RequestObject requestObject){
		boolean flag = privilegeService.updatePrivilege(requestObject);
		if(flag){
			return new ResponseEntity<Object>("OK", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/privilege/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deletePrivilege(@PathVariable String id){
		boolean flag = privilegeService.delete(id);
		if(flag){
			return new ResponseEntity<Object>("OK", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	@RequestMapping(value="/allPrivilegePage", method=RequestMethod.GET)
	public String allPrivilegePage(){
		return "adminViews/showPrivilege";
	}
	
	@RequestMapping(value="/addPrivilegePage", method=RequestMethod.GET)
	public String addPrivilegePage(){
		return "adminViews/addPrivilege";
	}
	
	@RequestMapping(value="/updateAllPrivilegePage", method=RequestMethod.GET)
	public String updateAllPrivilegePage(){
		return "adminViews/updateAllPrivilege";
	}
	
	@RequestMapping(value="/updatePrivilegePage/{id}", method=RequestMethod.GET)
	public String updatePrivilegePage(@PathVariable String id, Model model){
		model.addAttribute("privilegeId", id);
		return "adminViews/updatePrivilege";
	}
}
