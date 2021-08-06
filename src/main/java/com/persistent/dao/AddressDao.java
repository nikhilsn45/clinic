package com.persistent.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.entities.Address;
import com.persistent.entities.Patient;

@Repository
public interface AddressDao extends CrudRepository<Address,Integer>{

}
