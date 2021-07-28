package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;

import com.persistent.entities.UserInfo;

public interface UserDao extends CrudRepository<UserInfo,Integer>{

}
