package com.shaowei.workflow.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shaowei.workflow.exception.CustomGenericException;
import com.shaowei.workflow.model.Admin;
import com.shaowei.workflow.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private AdminService adminService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		Admin admin = adminService.verifyExistence(username, password);
		if (admin != null){
			request.getSession().setAttribute("admin", admin);
			return "adminViews/adminHome";
		} else
			throw new CustomGenericException("100", "Login error");
	}
	
	@RequestMapping(value="/technologies", method = RequestMethod.GET)
	public String showTechnologies(){
		return "adminViews/technologies";		
	}
	

}
