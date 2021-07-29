package com.persistent.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.User;

public interface UserDao extends CrudRepository<User,Integer>{

	//User findByUser_Name(String user_name);
	
	@Query(value="select * from user u where u.user_name= :un and password= :p",nativeQuery=true)
	User findUserByUser_NameAndPassword(String un, String p);

}
