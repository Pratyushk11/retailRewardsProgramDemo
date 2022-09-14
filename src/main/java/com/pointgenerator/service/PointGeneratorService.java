package com.pointgenerator.service;

import com.pointgenerator.model.Points;



public interface PointGeneratorService {
    public Points getPointsByCustomerId(Long customerId);

}
