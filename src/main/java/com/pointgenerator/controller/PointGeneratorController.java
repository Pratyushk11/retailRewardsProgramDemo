package com.pointgenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pointgenerator.model.Points;
import com.pointgenerator.service.PointGeneratorService;

@RestController
@RequestMapping("/pointGenerated")
public class PointGeneratorController {
	

	@Autowired
	private PointGeneratorService pointsServices;

	 @GetMapping(value = "/customers/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> getPointsByCustomerId(@PathVariable("customerId") Long customerId){
	         Points points = pointsServices.getPointsByCustomerId(customerId);
	         if(points==null)
	 	        return new ResponseEntity<>("No Transaction found for this customer Id",HttpStatus.OK);

	        return new ResponseEntity<>(points,HttpStatus.OK);
	    }
  
}
