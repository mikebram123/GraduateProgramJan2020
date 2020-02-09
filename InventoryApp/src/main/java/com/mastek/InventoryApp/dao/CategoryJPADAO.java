package com.mastek.InventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import com.mastek.InventoryApp.entities.Category;

public interface CategoryJPADAO extends CrudRepository<Category, Integer>  {

}
