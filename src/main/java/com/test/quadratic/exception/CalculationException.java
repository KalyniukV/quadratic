package com.test.quadratic.exception;

public class CalculationException extends RuntimeException {
    public static final String MESSAGE = "Дискримінант менше нуля";

    public CalculationException() {
        super(MESSAGE);
    }

}
