package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.mastek.hrapp.entities.Department;

public interface DepartmentJPADAO extends CrudRepository<Department, Integer>  {

}
