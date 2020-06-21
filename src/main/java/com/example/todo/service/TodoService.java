package com.example.todo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.todo.dao.TaskDBRepository;
import com.example.todo.dao.UserDBRepository;
import com.example.todo.model.TasksModel;
import com.example.todo.model.UserModel;

@Service
public class TodoService {
	
	@Autowired
	private UserDBRepository userRepository;
	@Autowired
	private TaskDBRepository taskRepository;
	
	/* Implement User Methods */
	public UserModel addUser(UserModel user) {
		return this.userRepository.save(user);
	}
	
	public List<UserModel> getAllUsers(){
		return this.userRepository.findAll();
	}

	public Optional<UserModel> getUser(String id) {
		return this.userRepository.findById(id);
	}
	
	public String deleteUser(String id) {
		 this.userRepository.deleteById(id);
		 return "User "+id+" is deleted";
	}
	
	
	/* Implement Task Methods */
	public TasksModel addTask(TasksModel task) {
		return this.taskRepository.save(task);
	}

	public List<TasksModel> taskByUserID(String userID) {
		// findAllTaskByUserID is custom method 
		return this.taskRepository.findAllTaskByUserID(userID);
	}

	public TasksModel taskByUserAndTaskID(String userID, String taskID) {
		// findTaskByUserAndTaskID is custom method 
		return this.taskRepository.findTaskByUserAndTaskID(userID,taskID);
	}

	public TasksModel updateTask(TasksModel task) {
		return this.taskRepository.save(task);
	}

	public String deleteTask(TasksModel task) {
		this.taskRepository.delete(task);
		return "Task " + task.getTaskID() +" is deleted "; 
	}

}

