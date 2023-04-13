package com.achsat.travel.transaction.controller;

import com.achsat.travel.transaction.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private Integer id;
    public TransactionController

    @PostMapping

    public Transaction create(@RequestBody Transaction transaction) {

        transaction.setId(id.incrementAndGet());

        return transaction;
    }

}
