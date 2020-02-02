package com.test.quadratic.service;


import com.test.quadratic.entity.Equation;
import com.test.quadratic.exception.CalculationException;

public interface CommonService {

    Equation setCalculation(String valA, String valB, String valC) throws CalculationException;
}
