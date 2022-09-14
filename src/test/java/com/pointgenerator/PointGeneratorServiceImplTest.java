package com.pointgenerator;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pointgenerator.model.Points;
import com.pointgenerator.model.Transaction;
import com.pointgenerator.service.PointGeneratorServiceImpl;  

@RunWith(SpringRunner.class)
@SpringBootTest
public class PointGeneratorServiceImplTest {

	@Mock
	private PointGeneratorServiceImpl pointServiceImpl;

	@Test
	public void test_getPointsByCustomerId()
	{
		Points	points=new Points (1l,123,0,0,0); 
		Mockito.when(pointServiceImpl.getPointsByCustomerId(1l)).thenReturn(points);
		Points points1=pointServiceImpl.getPointsByCustomerId(1l);
		assertEquals(1l, points1.getCustomerId()); 		

	}

	@Test
	public void test_getPointsPerMonth()
	{	
		List<Transaction>	transactionList=new ArrayList<>();
	Transaction	transaction=new Transaction (1l,120l,Timestamp.valueOf("2022-08-09 00:00:00"),1l); 
	transactionList.add(transaction);
	Mockito.when(pointServiceImpl.getPointsPerMonth(transactionList)).thenReturn(2l);
	long points=pointServiceImpl.getPointsPerMonth(transactionList);
	assertEquals(2l, points); 		


	}

}
