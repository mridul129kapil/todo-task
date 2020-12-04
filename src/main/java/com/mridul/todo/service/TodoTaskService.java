package com.mridul.todo.service;

import java.util.List;

import com.mridul.todo.entity.TodoTask;

public interface TodoTaskService {
	public List<TodoTask> findAll();
	public void save(TodoTask todoTask);
	public void deleteById(int id);
	public boolean authenticate(String userName, String password);
}
