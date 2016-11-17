package com.shaowei.authorization.serivce;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javassist.Modifier;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shaowei.authorization.domain.Privilege;
import com.shaowei.authorization.repository.PrivilegeRepository;
import com.shaowei.workflow.dto.RequestObject;

@Service
public class PrivilegeService {
	@Resource
	PrivilegeRepository privilegeRepository;
	
	public List<Privilege> getAll(){
		return privilegeRepository.getAll();
	}
	
	public boolean addPrivilege(Privilege privilege){
		privilegeRepository.add(privilege);
		return true;
	}
	
	public boolean delete(String id){
		Privilege privilege = privilegeRepository.get(Integer.parseInt(id));
		privilegeRepository.delete(privilege);
		return true;
	}
	
	public Privilege getPrivilege(String id){
		return privilegeRepository.get(Integer.parseInt(id));
	}
	
	public boolean updatePrivilege(RequestObject requestObject){

		Class<Privilege> clazz = Privilege.class;
		Privilege privilege = null;
		try {
			privilege = clazz.newInstance();

		Field[] fields = clazz.getDeclaredFields();

		for(Field field : fields){
			if(!Modifier.toString(field.getModifiers()).contains("final")){
			String name = field.getName();
		    Pattern r = Pattern.compile("$Id");
		    Matcher m = r.matcher(name);
		    if(m.find()){
		    	String id = ((String)requestObject.getRequestObject().get(name));
		    	if(id!=null || "".equalsIgnoreCase(id)){
		    		return false;
		    	}
		    }
		    field.setAccessible(true);
		    Object value = null;
		    if(field.getType().getSimpleName().contains("String")){
		    	value = requestObject.getRequestObject().get(name);
		    }
		    if(field.getType().getSimpleName().contains("int")){
		    	value = Integer.parseInt((String) requestObject.getRequestObject().get(name));
		    }
		    
			field.set(privilege, value);
			}
		}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		privilegeRepository.update(privilege);
		return true;
	}

}
