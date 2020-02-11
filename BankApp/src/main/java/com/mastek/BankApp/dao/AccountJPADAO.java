package com.mastek.BankApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.BankApp.entities.Account;

@Repository
public interface AccountJPADAO extends CrudRepository<Account, Integer> {

}
