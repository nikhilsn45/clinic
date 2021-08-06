package com.persistent.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.User;

public interface UserDao extends CrudRepository<User,Integer>{

	//User findByUser_Name(String user_name);
	
	User findUserByUserNameAndPassword(String un, String p);

}
