package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.User;

public interface UserDao extends CrudRepository<User,Integer>{

}
