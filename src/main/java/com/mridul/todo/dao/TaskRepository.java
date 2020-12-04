package com.mridul.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mridul.todo.entity.TodoTask;

public interface TaskRepository extends JpaRepository<TodoTask, Integer> {

}
