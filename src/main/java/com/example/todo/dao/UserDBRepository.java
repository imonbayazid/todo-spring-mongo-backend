package com.example.todo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.todo.model.UserModel;

public interface UserDBRepository extends MongoRepository<UserModel, String>{
		

}
