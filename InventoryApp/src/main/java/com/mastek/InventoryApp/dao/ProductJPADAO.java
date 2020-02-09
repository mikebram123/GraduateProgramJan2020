package com.mastek.InventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import com.mastek.InventoryApp.entities.Product;

public interface ProductJPADAO extends CrudRepository<Product, Integer> {

}
