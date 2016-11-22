package com.shaowei.workflow.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shaowei.workflow.model.User;
import com.shaowei.workflow.service.UserService;

@Controller
@RequestMapping("/administrator")
public class AdminUserController {

	@Resource
	private UserService userService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "administratorViews/addUser";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(User user, Model model) {
		if (userService.addUser(user)) {
			return "administratorViews/adminHome";
		} else
			return "error";
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String goWelcome(){
		return "administratorViews/adminHome";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String showAllUsers(Model model){
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allUsers", allUsers);
		return "administratorViews/allUsers";
	}
	
	@RequestMapping(value="/show/{userId}", method = RequestMethod.GET)
	public String showUser(@PathVariable int userId, Model model){
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "administratorViews/showUser";
	}
	
	@RequestMapping(value="/operate", method = RequestMethod.GET)
	public String operateAllUsers(Model model){
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allUsers", allUsers);
		return "administratorViews/updateAllUsers";		
	}
	
	@RequestMapping(value="/update/{userId}", method = RequestMethod.GET)
	public String updateUser(@PathVariable int userId, Model model){
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "administratorViews/updateUser";
	}
	
	@RequestMapping(value="/update/{userId}", method = RequestMethod.POST)
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/administrator/list";
	}
	
	@RequestMapping(value="/delete/{userId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int userId, Model model){
		userService.deleteUser(userId);
		return "redirect:/administrator/operate";
	}
	
	@RequestMapping(value="/technologies", method = RequestMethod.GET)
	public String showTechnologies(){
		return "administratorViews/technologies";		
	}

}
