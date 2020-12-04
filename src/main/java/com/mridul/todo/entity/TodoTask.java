package com.mridul.todo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class TodoTask {

	public TodoTask() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "info")
	private String task;
	
	@Column(name = "date")
	private String date;
	
	
	
	public TodoTask(String task, String date) {
		this.task = task;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TodoTask [id=" + id + ", task=" + task + ", date=" + date + "]";
	}
	
		
}
