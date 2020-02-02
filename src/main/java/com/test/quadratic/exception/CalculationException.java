package com.test.quadratic.exception;

public class CalculationException extends RuntimeException {
    public static final String MESSAGE = "Calculation exception";

    public CalculationException() {
        super(MESSAGE);
    }

}
