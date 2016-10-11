package com.shaowei.workflow.dao;

import java.util.List;

public interface Dao<T> {
	
	public void add(T t);
	public void delete(T t);
	public void delete(int id);
	public void update(T t);
	public T get(int id);
	public List<T> getAll();
	public void save(T t);

}
