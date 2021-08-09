package com.persistent.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.entities.Address;

@Repository
public interface AddressDao extends CrudRepository<Address,Integer>{

}
