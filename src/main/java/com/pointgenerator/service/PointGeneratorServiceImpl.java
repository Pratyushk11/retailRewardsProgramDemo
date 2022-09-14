package com.pointgenerator.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pointgenerator.contsant.AppConstant;
import com.pointgenerator.model.Points;
import com.pointgenerator.model.Transaction;
import com.pointgenerator.util.TransactionData;

@Service
public class PointGeneratorServiceImpl implements PointGeneratorService {

	public static long calculatePoints(long total) {


		if (total <= AppConstant.first) {
			return 0l;
		} else if (total <= AppConstant.second) {
			return total - AppConstant.first;
		} else {
			return AppConstant.first + 2 * (total - AppConstant.second);
		}
	}


	private List<Transaction> getDataByTransactionDateBetween(Long customerId,
			Timestamp lastMonthTimestamp, Timestamp from) {

		List<Transaction> transactionsList =TransactionData.getAllTransactionData();
		List<Transaction> tList=new ArrayList<Transaction>();
		for (Transaction transaction : transactionsList) {
			if(transaction.getCustomerId()==customerId&&(transaction.getTransactionDate().getTime()>=lastMonthTimestamp.getTime()&&transaction.getTransactionDate().getTime()<=from.getTime()))

			{
				tList.add(transaction);
			}
		}

		return tList;
	}


	@Override
	public Points getPointsByCustomerId(Long customerId) {

		Timestamp lastMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(30));
		Timestamp lastSecondMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(60));
		Timestamp lastThirdMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(90));

		 boolean isValidUser =checkValidCustomerId(customerId);
		 if(!isValidUser)
			 return null;
		
		List<Transaction> lastMonthTransactions = getDataByTransactionDateBetween(customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = getDataByTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = getDataByTransactionDateBetween(customerId, lastThirdMonthTimestamp,lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getPointsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getPointsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getPointsPerMonth(lastThirdMonthTransactions);

		double total=lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints;
		Points points = new Points(customerId,lastMonthRewardPoints,lastSecondMonthRewardPoints,lastThirdMonthRewardPoints,total);
		return points;

	}



	private boolean checkValidCustomerId(Long customerId) {

		List<Transaction> transactionsList =TransactionData.getAllTransactionData();
		for (Transaction transaction : transactionsList) {
			if(transaction.getCustomerId()==customerId)
             return true;			
		}

		return false;
	}


	public Long getPointsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculatePoints(transaction.getTransactionAmount())).collect(Collectors.summingLong(r -> r.longValue()));
	}


}
