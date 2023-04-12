package com.achsat.travel.transaction.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
public class TransactionHistory {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "account_id")
    private Integer accountId;
    @Column(name = "tour_id")
    private Integer tourId;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "status")
    private String status;
    @Column(name = "date")
    private Date date;

}
