package com.example.todo.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.todo.model.TasksModel;
import com.example.todo.model.UserModel;
import com.example.todo.service.TodoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/todoApp")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	/* Handling  User APIs */
	@ApiOperation("Use this method to create a new user for the TODO application so that the user can manage his/her todo lists")
	@PostMapping("/addUser")
	/*EXAMPLE: http://localhost:8082/todoApp/addUser*/
	public UserModel addUser(@RequestBody UserModel user){
		return this.todoService.addUser(user);
	} 
	
	@ApiOperation("Use this method to fetch all the users of this TODO application")
	@GetMapping("/allUsers")
	/*http://localhost:8082/todoApp/allUsers*/
	public List<UserModel> getAllUsers(){
		return this.todoService.getAllUsers();
	}
	
	@ApiOperation("Use this method to get single user details")
	@GetMapping("/user/{userID}")
	/*http://localhost:8082/todoApp/user/5e650f1d7a2d7b6344806690*/
	public Optional<UserModel> getSingleUser(@ApiParam("Provide the unique user ID")@PathVariable String userID){
		return this.todoService.getUser(userID);
	}
	
	@ApiOperation("Use this method to delete a user from this application")
	@DeleteMapping("/deleteUser/{userID}")
	/*http://localhost:8082/todoApp/deleteUser/5e650f1d7a2d7b6344806690*/
	public String deleteUser(@ApiParam("Provide the unique user ID")@PathVariable String userID) {
		return this.todoService.deleteUser(userID);
	}
	
	/* Handling  Task APIs */
	@ApiOperation("Use this method to create a task for a user which is why we have to provide the user ID and the task ")
	@PostMapping("/addTask")
	/*http://localhost:8082/todoApp/addTask*/
	public TasksModel addTaskOfUser(@ApiParam("Provide the task details")@RequestBody TasksModel task) {
		return this.todoService.addTask(task);
	}
	
	@ApiOperation("Use this method to fetch all tasks of a particular user using his/her user ID")
	@GetMapping("/tasks/{userID}")
	/*http://localhost:8082/todoApp/tasks/5e65457ee179385539f6c101*/
	public List<TasksModel> getAllTasksOfUser(@ApiParam("Provide the unique user ID")@PathVariable String userID){
		return this.todoService.taskByUserID(userID);
	}
	
	@ApiOperation("Use this method to fetch a particular task of a particular user, by providing the task ID and the user ID")
	@GetMapping("/task/{userID}/{taskID}")
	/*http://localhost:8082/todoApp/task/5e65457ee179385539f6c101/5e6546fee179385539f6c103*/
	public TasksModel getSingleTaskOfUser(@ApiParam("Provide the unique user ID and task details")@PathVariable String userID,@PathVariable String taskID){
		return this.todoService.taskByUserAndTaskID(userID,taskID);
	} 
	
	@ApiOperation("Use this method to update a task of a user")
	@PutMapping("/updateTask")
	/*http://localhost:8082/todoApp/updateTask*/
	public TasksModel updateSingleTask(@ApiParam("Provide the task details")@RequestBody TasksModel task){
		return this.todoService.updateTask(task);
	} 
	
	@ApiOperation("Use this method to delete a task of a user")
	@DeleteMapping("/deleteTask")
	/*http://localhost:8082/todoApp/deleteTask/5e650f147a2d7b634480668f*/
	public String deleteTask(@ApiParam("Provide the task ID")@RequestBody TasksModel task) {
		return this.todoService.deleteTask(task);
	}

}
