package com.test.quadratic.repos;

import com.test.quadratic.entity.Equation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquationRepo extends JpaRepository<Equation, Long> {

}
