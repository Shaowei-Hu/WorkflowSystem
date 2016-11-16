package com.shaowei.workflow.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.authorization.domain.Role;
import com.shaowei.authorization.serivce.RoleService;
import com.shaowei.workflow.dao.UserDao;
import com.shaowei.workflow.dto.KeyValue;
import com.shaowei.workflow.dto.RequestObject;
import com.shaowei.workflow.model.User;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private WorkflowService workflowService;
	@Resource
	private RoleService roleService;
	
	public User verifyExistence(String name, String password) {
		User user = userDao.getUserByName(name);
		if (user!=null && user.getUserPassword().equals(password)){
			user = setCapacity(user);
			return user;
		}
		else
			return null;
	}

	public boolean addUser(User user) {
		try {
			user.setUserPassword("initial");
			String managerIdName = user.getManagerId();
			String partnerIdName = user.getPartnerId();
			if(managerIdName!=null && managerIdName!=""){
				int managerId = Integer.parseInt(managerIdName.split("--")[0].trim());
				User manager = userDao.get(managerId);
				if(manager != null){
					user.setManager(manager);		
				}
			}			
			if(partnerIdName != null && partnerIdName != ""){
				int partnerId = Integer.parseInt(partnerIdName.split("--")[0].trim());
				User partner = userDao.get(partnerId);
				if(partner != null)
					user.setPartner(partner);
			}
			

			userDao.add(user);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<User> getAllUsers(){
		
		return userDao.getAll();
	}
	
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	
	public boolean updateUser(User user){
		
		try {
			user.setUserPassword("initial");
			String managerIdName = user.getManagerId();
			String partnerIdName = user.getPartnerId();
			if(managerIdName!=null && managerIdName!=""){
				int managerId = Integer.parseInt(managerIdName.split("--")[0].trim());
				User manager = userDao.get(managerId);
				if(manager != null){
					user.setManager(manager);		
				}
			}			
			if(partnerIdName != null && partnerIdName != ""){
				int partnerId = Integer.parseInt(partnerIdName.split("--")[0].trim());
				User partner = userDao.get(partnerId);
				if(partner != null)
					user.setPartner(partner);
			}
			userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deleteUser(int userId){
		try {
			userDao.delete(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<User> getUserByJob(String job){
		return userDao.getUsersByJob(job);
	}
	
	public List<KeyValue> getUserJobByJob(String job){
		return userDao.getUserJobByJob(job);
	}
	
	public List<KeyValue> getDestionationByDecisionId(int id){
		int nextStepId = workflowService.getDecision(id+"").getNextStepId();
		String job = workflowService.getStepAdvancedById(nextStepId+"").getService();
		return getUserJobByJob(job);
	}
	
	private User setCapacity(User user){
		if(user.getJob().equalsIgnoreCase("Trader")){
			user.setCapacity("Create");
		}
		else
			user.setCapacity("null");
		return user;
	}
	
	public List<KeyValue> getAllUsersKeyValue(){
		return userDao.getAllUserKeyValue();
	}
	
	public User getUserWithRole(String id){
		return userDao.getUserWithRole(Integer.parseInt(id));
	}
	
	@SuppressWarnings("unchecked")
	public boolean updateUserWithRole(RequestObject requestObject){
		User user = userDao.getUserWithRole(Integer.parseInt((String)requestObject.getRequestObject().get("userId")));
//		User user = null;
		Set<Role> roles = new HashSet<>();
		for(String r : (ArrayList<String>)requestObject.getRequestObject().get("rolesId")){
			roles.add(roleService.getRole(r));
			System.out.println(r);
		}
		user.setRoles(roles);
		userDao.update(user);
		return true;
	}

}
