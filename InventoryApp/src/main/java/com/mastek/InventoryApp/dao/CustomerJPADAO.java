package com.mastek.InventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.InventoryApp.entities.Customer;

@Repository
public interface CustomerJPADAO extends CrudRepository<Customer, Integer>  {

}
