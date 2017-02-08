package com.shaowei.workflow.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shaowei.workflow.dao.UserDao;
import com.shaowei.workflow.model.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core-test-config.xml", "classpath:spring-mvc-test-config.xml"})
public class UserServiceIntTest {

	@Autowired
	private UserDao userDao;
	
	@Autowired( required = true )
	private UserService userService;
	
	@Autowired
	private User rootAdmin;
	@Autowired
	private User notExisteUser;
	@Autowired
	private User faultPassword;
	
	@Autowired
	private User newUser;
	
	public static final Condition<User> ALL = new Condition<User>() {
		  public boolean matches(User value) {
			    return true;
			  }
	};
	
	@Test
	public void testLogin() {
		User root = userService.verifyExistence(rootAdmin.getUserName(), rootAdmin.getUserPassword());
		User notExiste = userService.verifyExistence(notExisteUser.getUserName(), notExisteUser.getUserPassword());
		User fault = userService.verifyExistence(faultPassword.getUserName(), faultPassword.getUserPassword());
		
		assertNotNull("Root administrator login", root);
		assertNull("User not existe login", notExiste);
		assertNull("Fault password login", fault);

	}
	
	@Test
	public void testGetAllUser() {
		List<User> users = userService.getAllUsers();
		
		assertThat(users).isNotEmpty();
		assertThat(users).extracting("userName", String.class).contains("RootAdmin", "First Trader", "First Responsible", "first risk", "first backoffice");
	}
	
	@Test
	public void testGetUserById() {
		User user = userService.getUserById(rootAdmin.getUserId());
		
		assertThat(user.getUserName()).as("Check user's name", user.getUserName()).isEqualTo(rootAdmin.getUserName());
		assertThat(user.getJob()).as("Check user's job", user.getJob()).isEqualTo(rootAdmin.getJob());
	}
	
	@Test
	public void testAddUpdateDeleteUser() {
		userService.addUser(newUser);
		List<User> users = userService.getAllUsers();
		
		assertThat(users).isNotEmpty().areExactly(10, ALL);
		assertThat(users).extracting("userName", String.class).contains("NewUser4Test");
		
		
		
		userService.deleteUser(newUser.getUserId());
		users = userService.getAllUsers();
		
		assertThat(users).isNotEmpty().areExactly(9, ALL);
		assertThat(users).extracting("userName", String.class).doesNotContain("NewUser4Test");
	}
	

}
