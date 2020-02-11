package com.mastek.BankApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.BankApp.entities.Transaction;

@Repository
public interface TransactionJPADAO extends CrudRepository<Transaction, Integer>{

}
