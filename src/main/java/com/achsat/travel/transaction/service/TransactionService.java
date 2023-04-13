package com.achsat.travel.transaction.service;

import com.achsat.travel.transaction.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    public Transaction confirm(Transaction transactionPayment, Transaction transactionProduct) {
//        Transaction tr = new Transaction(transactionPayment.getId(),
//                transactionPayment.getCustomerId(),
//                transactionPayment.getProductId(),
//                transactionPayment.getProductCount(),
//                transactionPayment.getPrice());
//        if (transactionPayment.getStatus().equals("ACCEPT") &&
//                transactionProduct.getStatus().equals("ACCEPT")) {
//            o.setStatus("CONFIRMED");
//        } else if (transactionPayment.getStatus().equals("REJECT") &&
//                transactionProduct.getStatus().equals("REJECT")) {
//            o.setStatus("REJECTED");
//        } else if (transactionPayment.getStatus().equals("REJECT") ||
//                transactionProduct.getStatus().equals("REJECT")) {
//            String source = transactionPayment.getStatus().equals("REJECT")
//                    ? "PAYMENT" : "STOCK";
//            tr.setStatus("ROLLBACK");
//            tr.setSource(source);
//        }
//        return tr;
    }
}
