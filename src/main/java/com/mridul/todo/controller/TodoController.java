package com.mridul.todo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mridul.todo.entity.TodoTask;
import com.mridul.todo.service.TodoTaskService;

@Controller
@RequestMapping("/todos")
public class TodoController {

	private TodoTaskService todoTaskService;
	
	@Autowired
	public TodoController(TodoTaskService todoTaskService) {
		this.todoTaskService=todoTaskService;
	}
	
	@GetMapping("/log")
	public String login() {
		return "login";
	}
	
	@PostMapping("/letLogin")
	public String letLogin(@RequestParam("username") String username
			,@RequestParam("password") String password,
			Model theModel,HttpServletRequest request)
	{
		boolean result = todoTaskService.authenticate(username, password);
		if(result) {
			System.out.println("<><><><><><><><><><><><><><>");
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			return "redirect:/todos/list";
		}
		else {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			//return "redirect:/todos/log";
			return "failed";
		}
	}
	
	@GetMapping("/list")
	public String listTasks(Model theModel,HttpServletRequest request) {
		HttpSession session=request.getSession();
		if(session.getAttribute("username")==null) {
			theModel.addAttribute("message","login");
			return "redirect:/todos/log";
		}
		else {
			System.out.println(session.getAttribute("username")+"================================");

			List<TodoTask> tasks = todoTaskService.findAll();
			theModel.addAttribute("tasks",tasks);
			return "index";
		}
		
	}
	
	@PostMapping("/save")
	public String saveRecord(@RequestParam("task") String task, @RequestParam("date") String date)
	{
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+theRecord.isDone()+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if(date.equals("")) {
			Date dat = new Date();
			date= new SimpleDateFormat("yyyy-MM-dd").format(dat);
		}
		TodoTask theTask = new TodoTask(task,date);
		todoTaskService.save(theTask);
		
		return "redirect:/todos/list";
		
	}
	
	@GetMapping("/delete/{theId}")
	public String deleteEmployee(@PathVariable(value = "theId") int id)
	{
		todoTaskService.deleteById(id);
		return "redirect:/todos/list";
	}
	
	@GetMapping("/logout")
	public String loggedOut(Model theModel,HttpServletRequest request) {
		HttpSession session=request.getSession();
		System.out.println(session.getAttribute("username")+"||||||||||||||||||||||||||||||||||");
		session.removeAttribute("username");
		session.invalidate();
		theModel.addAttribute("logout","you have been logged out.");
		return "logout";
	}
}
