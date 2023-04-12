package com.achsat.travel.transaction.repository;

import com.achsat.travel.transaction.model.TransactionHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, Integer> {

}
