package com.test.quadratic.service;

import com.test.quadratic.entity.Equation;
import com.test.quadratic.exception.CalculationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    public Equation setCalculation(String valA, String valB, String valC) {
        BigDecimal a = new BigDecimal(valA);
        BigDecimal b = new BigDecimal(valB);
        BigDecimal c = new BigDecimal(valC);

        BigDecimal x1 = null;
        BigDecimal x2 = null;

        BigDecimal descr = b.pow(2).subtract(new BigDecimal(4).multiply(a).multiply(c));
        if (descr.compareTo(BigDecimal.ZERO) > 0) {
            x1 = (b.negate().subtract(getSqrt(descr))).divide(new BigDecimal(2).multiply(a));
            x2 = (b.negate().add(getSqrt(descr))).divide(new BigDecimal(2).multiply(a));
        } else if (descr.compareTo(BigDecimal.ZERO) == 0) {
            x1 = b.negate().divide(new BigDecimal(2).multiply(a));
        } else {
            throw new CalculationException();
        }

        return new Equation(a, b, c, x1, x2);
    }

    private BigDecimal getSqrt(BigDecimal value) {
        return new BigDecimal(Math.sqrt(value.doubleValue()));
    }

}


