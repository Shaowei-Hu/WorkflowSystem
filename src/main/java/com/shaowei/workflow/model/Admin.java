package com.shaowei.workflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="WKF_ADMIN")
public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7976084457032271442L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADMIN_ID")
	private int adminId;
	@Column(name="ADMIN_NAME",length=64)
	private String adminName;
	@Column(name="ADMIN_PASSWORD",length=32)
	private String password;
	@Column(name="ADMIN_EMAIL",length=64)
	private String email;
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	


		

}
