package com.example.todo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Tasks")
public class TasksModel {
	
	@Id
	/*taskID will be used as primary key will be auto-generated*/
	private String taskID;
	private String userID;
	private String task;
	
	public TasksModel(String taskID, String userID, String task) {
		super();
		this.taskID = taskID;
		this.userID = userID;
		this.task = task;
	}
	
	public String getTaskID() {
		return taskID;
	}


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
}
