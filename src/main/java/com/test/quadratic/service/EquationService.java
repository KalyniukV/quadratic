package com.test.quadratic.service;

import com.test.quadratic.entity.Equation;

import java.util.List;

public interface EquationService {
    List<Equation> findAll();
    void save(Equation equation);
}
