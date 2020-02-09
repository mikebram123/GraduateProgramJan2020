package com.mastek.InventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import com.mastek.InventoryApp.entities.Order;

public interface OrderJPADAO extends CrudRepository<Order, Integer>  {

}
