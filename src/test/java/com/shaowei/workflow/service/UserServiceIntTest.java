package com.shaowei.workflow.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.shaowei.workflow.dao.UserDao;
import com.shaowei.workflow.model.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core-test-config.xml", "classpath:spring-mvc-test-config.xml"})
@WebAppConfiguration
public class UserServiceIntTest {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private User rootAdmin;
	@Autowired
	private User notExisteUser;
	@Autowired
	private User faultPassword;

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
	}

}
