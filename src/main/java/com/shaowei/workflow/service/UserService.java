package com.shaowei.workflow.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.authorization.domain.Role;
import com.shaowei.authorization.serivce.RoleService;
import com.shaowei.workflow.dao.UserDao;
import com.shaowei.workflow.dto.KeyValue;
import com.shaowei.workflow.dto.Menu;
import com.shaowei.workflow.dto.RequestObject;
import com.shaowei.workflow.model.User;
import com.shaowei.workflow.util.PropertiesUtil;

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

	public Integer addUser(User user) {
		Integer generatedId;
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
			

			generatedId = (Integer) userDao.add(user);
		} catch (Exception e) {
			return -1;
		}
		return generatedId;
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
		Set<Role> roles = new HashSet<>();
		for(String r : (ArrayList<String>)requestObject.getRequestObject().get("rolesId")){
			roles.add(roleService.getRole(r));
			System.out.println(r);
		}
		user.setRoles(roles);
		userDao.update(user);
		return true;
	}
	
	public List<Menu> getUserMenu(Object object, String contextPath){

		int userId = ((User)object).getUserId();
		User user = userDao.getUserWithRole(userId);
		Set<String> privileges = new HashSet<>();
		List<Menu> menus = new ArrayList<>();
		Map<String, Menu> menusMap= new LinkedHashMap<>();
		for(Role role : user.getRoles()){
			Role roleWithPrivilege = roleService.getRoleWithPrivilege(role.getId()+"");
			for(Privilege privilege : roleWithPrivilege.getPrivileges()){
				privileges.add(privilege.getPrivilegeName());
			}
		}
		
		List<KeyValue> keyValues = PropertiesUtil.getAllPropertiesOrdered("menu.properties");
		for(KeyValue kv : keyValues){
			if(privileges.contains(kv.getKeyy())){
				String result = kv.getValue();
				String[] elements = result.split(";");
				if(!"#".equals(elements[2])){
					elements[2] = contextPath + elements[2];
				}
				Menu menu = new Menu(kv.getKeyy(), elements[0], elements[1], elements[2]);
				if(elements.length==3){
					menusMap.put(kv.getKeyy(), menu);
				}
				if(elements.length==4){
					menusMap.get(elements[3]).getChildren().add(menu);
				}			
				
			}
		}
		for(String s : menusMap.keySet()){
			menus.add(menusMap.get(s));
		}
		return menus;
	}

}
