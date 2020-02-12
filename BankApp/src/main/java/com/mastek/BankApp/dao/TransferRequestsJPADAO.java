package com.mastek.BankApp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.BankApp.entities.TransferRequests;

@Repository
public interface TransferRequestsJPADAO extends MongoRepository<TransferRequests, Integer> {

}
