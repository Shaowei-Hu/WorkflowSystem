package com.shaowei.authorization.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="AUTHORIZ_ROLE")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667892146763541193L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ROLE_NAME",length=32)
	private String roleName;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="AUTHORIZ_ROLE_PRIVILEGE", joinColumns={@JoinColumn(name="ROLE_ID")}, inverseJoinColumns={@JoinColumn(name="PRIVILEGE_ID")})
	private List<Privilege> privileges;
	
	@Column(name="ROLE_DESC",length=64)
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
