package com.pointgenerator.model;

import java.sql.Timestamp;

public class Transaction {
    
    private Long transactionId;

    private Long customerId;

    private Timestamp transactionDate;

    private long transactionAmount;

    public Transaction()
    {
    	
    }

    public Transaction( Long customerId, long transactionAmount,Timestamp transactionDate,Long transactionId) {
		super();
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
