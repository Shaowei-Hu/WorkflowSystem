package com.shaowei.workflow.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.workflow.exception.CustomGenericException;
import com.shaowei.workflow.model.KeyValue;
import com.shaowei.workflow.model.User;
import com.shaowei.workflow.service.DocumentServiceInterface;
import com.shaowei.workflow.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	UserService userService;
	@Resource
	DocumentServiceInterface documentService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		User user = userService.verifyExistence(username, password);
		if (user != null){
			request.getSession().setAttribute("user", user);
			return "userViews/userHome";
		} else
			throw new CustomGenericException("100", "Login error");
	}
	
	@RequestMapping(value="/getDestinationByStepID/{id}", method = RequestMethod.GET)
	public @ResponseBody List<KeyValue> getDestinationByStepID(@PathVariable int id){		
		return userService.getDestionationByStepId(id);
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(){
		return "userViews/userHome";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
			request.getSession().removeAttribute("user");
			return "../index";
	}
	
	@RequestMapping(value="/getUsersKeyValue", method = RequestMethod.GET)
	public @ResponseBody List<KeyValue> getUsersKeyValue(){		
		return userService.getAllUsersKeyValue();
	}
	
	
	
	
}
