package com.mastek.InventoryApp.dao;

import org.springframework.data.repository.CrudRepository;
import com.mastek.InventoryApp.entities.Ingredient;

public interface IngredientJPADAO extends CrudRepository<Ingredient, Integer>  {

}
