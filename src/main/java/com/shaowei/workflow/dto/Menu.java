package com.shaowei.workflow.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5320230601925686185L;
	
	private String name;
	private String text;
	private String href;
	private String icon;
	private List<Menu> children;
	
	public Menu(String name, String text, String icon, String href) {
		super();
		this.name = name;
		this.text = text;
		this.href = href;
		this.icon = icon;
		children = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	
}
