package com.test.quadratic.service;

import com.test.quadratic.entity.Equation;
import com.test.quadratic.exception.CalculationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    public Equation setCalculation(String a, String b, String c) {
        BigDecimal valA = new BigDecimal(a);
        BigDecimal valB = new BigDecimal(b);
        BigDecimal valC = new BigDecimal(c);

        BigDecimal resX1 = null;
        BigDecimal resX2 = null;

        BigDecimal descr = valB.pow(2).subtract(new BigDecimal(4).multiply(valA).multiply(valC));
        if (descr.compareTo(BigDecimal.ZERO) > 0) {
            resX1 = (valB.negate().subtract(getSqrt(descr))).divide(new BigDecimal(2).multiply(valA));
            resX2 = (valB.negate().add(getSqrt(descr))).divide(new BigDecimal(2).multiply(valA));
        } else if (descr.compareTo(BigDecimal.ZERO) == 0) {
            resX1 = valB.negate().divide(new BigDecimal(2).multiply(valA));
        } else {
            throw new CalculationException();
        }

        return new Equation(valA, valB, valC, resX1, resX2);
    }

    private BigDecimal getSqrt(BigDecimal value) {
        return new BigDecimal(Math.sqrt(value.doubleValue()));
    }

}


