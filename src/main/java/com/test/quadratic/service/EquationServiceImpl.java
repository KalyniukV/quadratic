package com.test.quadratic.service;

import com.test.quadratic.entity.Equation;
import com.test.quadratic.repos.EquationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquationServiceImpl implements EquationService {

    @Autowired
    private EquationRepo equationRepo;

    public List<Equation> findAll() {
        return equationRepo.findAll();
    }

    @Transactional
    public void save(Equation equation) {
        equationRepo.save(equation);
    }
}
