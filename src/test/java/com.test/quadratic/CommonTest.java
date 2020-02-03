package com.test.quadratic;


import com.test.quadratic.config.JpaConfig;
import com.test.quadratic.entity.Equation;
import com.test.quadratic.exception.CalculationException;
import com.test.quadratic.service.CommonService;
import com.test.quadratic.service.CommonServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.math.BigDecimal;


public class CommonTest {
    private GenericApplicationContext ctx;
    private CommonService commonService;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        commonService = ctx.getBean(CommonServiceImpl.class);
        Assert.assertNotNull(commonService);        
    }


    @Test
    public void discriminatorMoreThanZero() {
        Equation equation = commonService.setCalculation("-10", "20", "30");
        Assert.assertTrue(equation.getResX1().compareTo(new BigDecimal(3)) == 0 &&
                                    equation.getResX2().compareTo(new BigDecimal(-1)) == 0);
    }

    @Test
    public void discriminatorIsZero() {
        Equation equation = commonService.setCalculation("1", "12", "36");
        Assert.assertTrue(equation.getResX1().compareTo(new BigDecimal(-6)) == 0 &&
                                    equation.getResX2() == null);
    }

    @Test
    public void discriminatorLessThanZero() {
        try {
            commonService.setCalculation("1","1","1");
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), CalculationException.MESSAGE);
        }
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
