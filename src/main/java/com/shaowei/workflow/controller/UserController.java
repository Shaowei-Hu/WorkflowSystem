package com.shaowei.workflow.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaowei.workflow.dto.KeyValue;
import com.shaowei.workflow.dto.Menu;
import com.shaowei.workflow.dto.RequestObject;
import com.shaowei.workflow.exception.CustomGenericException;
import com.shaowei.workflow.model.User;
import com.shaowei.workflow.service.DocumentService;
import com.shaowei.workflow.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	UserService userService;
	@Resource
	DocumentService documentService;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request) {
		User user = userService.verifyExistence(username, password);
		if (user != null){
			request.getSession().setAttribute("user", user);
			
			String path = request.getContextPath();
			@SuppressWarnings("unchecked")
			List<Menu> menus = (List<Menu>)request.getSession().getAttribute("menu");
			if(menus==null){
				menus = userService.getUserMenu(request.getSession().getAttribute("user"), path);
				request.getSession().setAttribute("menu", menus);
			} 	
			
			return "userViews/userHome";
		} else
			throw new CustomGenericException("100", "Login error");
	}
	

	/*
	 * get the next step service add the user in the service
	 */
	@RequestMapping(value="/getDestinationByDecisionID/{id}", method = RequestMethod.GET)
	public @ResponseBody List<KeyValue> getDestinationByDecisionID(@PathVariable int id){		
		return userService.getDestionationByDecisionId(id);
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(){
		return "userViews/userHome";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
			request.getSession().removeAttribute("user");
			request.getSession().invalidate();
			return "../index";
	}
	
	@RequestMapping(value="/getUsersKeyValue", method = RequestMethod.GET)
	public @ResponseBody List<KeyValue> getUsersKeyValue(){		
		return userService.getAllUsersKeyValue();
	}
	
	@RequestMapping(value="/userRole/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUserRole(@PathVariable String userId){
		return userService.getUserWithRole(userId);
	}
	
	@RequestMapping(value="/userRole", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateUserRole(@RequestBody RequestObject requestObject){
		userService.updateUserWithRole(requestObject);
		return new ResponseEntity<Object>("OK", HttpStatus.OK);
	}
	
	@RequestMapping(value="/userRolePage/{userId}", method = RequestMethod.GET)
	public String updateUserRolePage(@PathVariable String userId, Model model){
		model.addAttribute("userId", userId);
		return "authorizationViews/updateUserRole";
	}
	
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public @ResponseBody List<Menu> getUserMenu(HttpServletRequest request){
		
		String path = request.getContextPath();
		@SuppressWarnings("unchecked")
		List<Menu> menus = (List<Menu>)request.getSession().getAttribute("menu");
		if(menus==null){
			menus = userService.getUserMenu(request.getSession().getAttribute("user"), path);
			request.getSession().setAttribute("menu", menus);
		} 	
		return menus;
	}
	
	
}
