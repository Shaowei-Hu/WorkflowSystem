package com.shaowei.workflow.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.workflow.dao.UserDao;
import com.shaowei.workflow.model.KeyValue;
import com.shaowei.workflow.model.User;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private WorkflowService workflowService;
	
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
	
	public List<KeyValue> getDestionationByStepId(int id){
		String job = workflowService.getServiceByStepId(id);
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

}
