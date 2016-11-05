package com.shaowei.authorization.dto;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity(name="AUTHORIZ_ROLE")
public class RoleDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667892146763541193L;

	private int id;
	
	private String roleName;
	

	private int[] privilegesId;
	

	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int[] getPrivilegesId() {
		return privilegesId;
	}

	public void setPrivilegesId(int[] privilegesId) {
		this.privilegesId = privilegesId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	


	
	
	
}
