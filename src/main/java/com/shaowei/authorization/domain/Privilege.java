package com.shaowei.authorization.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="AUTHORIZ_PRIVILEGE")
public class Privilege implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5222494307778660122L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="PRIVILEGE_NAME",length=16)
	private String privilegeName;
	
	@Column(name="PRIVILEGE_DESC",length=16)
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrivilegeName() {
		return privilegeName;
	}
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
