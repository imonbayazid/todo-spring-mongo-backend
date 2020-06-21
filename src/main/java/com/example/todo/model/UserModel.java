package com.example.todo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection  = "Users")
public class UserModel {
	
	@Id
	/*userID will be used as primary key will be auto-generated*/
	private String userID;
	private String userName;

	public UserModel( String userID,String userName) {
		this.userName=userName;
		this.userID=userID;
	}
	
	public UserModel() {
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserID() {
		return userID;
	}
}
