package com.mridul.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mridul.todo.dao.TaskRepository;
import com.mridul.todo.entity.TodoTask;

@Service
public class TodoTaskServiceImpl implements TodoTaskService {

	private TaskRepository taskRepository;
	
	@Autowired	
	public TodoTaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository=taskRepository;
	}
	
	
	@Override
	public List<TodoTask> findAll() {
		
		List<TodoTask> tasks = taskRepository.findAll();
		return tasks;
	}

	@Override
	public void save(TodoTask todoTask) {
		// TODO Auto-generated method stub
		taskRepository.save(todoTask);

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		taskRepository.deleteById(id);

	}

	@Override
	public boolean authenticate(String userName, String password) {
		// TODO Auto-generated method stub
		if(userName.equals("admin")&& password.equals("root")) {
			return true;
		}
		else {
			return false;
		}
	}

}
