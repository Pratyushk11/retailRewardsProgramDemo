package com.pointgenerator.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pointgenerator.model.Transaction;

public class TransactionData {

	public static List<Transaction>  getAllTransactionData() {
		List<Transaction> transactions=new ArrayList<>();

		Transaction transaction1=new Transaction(1l,110l,new Timestamp(new Date().getTime()),1l);
		transactions.add(transaction1);

		Transaction transaction2=new Transaction(2l,982l,new Timestamp(new Date().getTime()),2l);
		transactions.add(transaction2);
		
		Transaction transaction3=new Transaction(3l,599l,new Timestamp(new Date().getTime()),3l);
		transactions.add(transaction3);

		Transaction transaction4=new Transaction(4l,120l,Timestamp.valueOf("2022-08-09 00:00:00"),1l);
		transactions.add(transaction4);

		Transaction transaction5=new Transaction(2l,181,Timestamp.valueOf("2022-08-09 00:00:00"),2l);
		transactions.add(transaction5);

		Transaction transaction6=new Transaction(3l,111l,Timestamp.valueOf("2022-08-09 00:00:00"),3l);
		transactions.add(transaction6);

		Transaction transaction7=new Transaction(4l,232l,Timestamp.valueOf("2022-07-09 00:00:00"),1l);
		transactions.add(transaction7);

		Transaction transaction8=new Transaction(2l,412l,Timestamp.valueOf("2022-07-09 00:00:00"),2l);
		transactions.add(transaction8);

		Transaction transaction9=new Transaction(3l,99l,Timestamp.valueOf("2022-07-09 00:00:00"),3l);
		transactions.add(transaction9);

		return transactions;

	}
}
