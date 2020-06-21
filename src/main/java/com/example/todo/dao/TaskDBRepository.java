package com.example.todo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.todo.model.TasksModel;

public interface TaskDBRepository extends MongoRepository<TasksModel, String>{
	
	/* Defining custom method 
	 * findAllTaskByUserID will return list of TaskModel 
	 * where userID(In the DB) = userID(which is passed to the method)
	 * ?0 means first argument that is passed in the method
	 * */ 
	@Query("{userID: ?0}")
	List<TasksModel> findAllTaskByUserID(String userID);
	
	/* Defining custom method 
	 * findTaskByUserAndTaskID will return single TaskModel 
	 * where userID(In the DB) = userID(which is passed to the method)
	 * and taskID(In the DB) = taskID(which is passed to the method)
	 * ?0 means first argument that is passed in the method
	 * ?1 means 2nd argument that is passed in the method
	 * */ 
	@Query("{'userID': ?0 , 'taskID': ?1}")
	TasksModel findTaskByUserAndTaskID(String userID,String taskID);
}
