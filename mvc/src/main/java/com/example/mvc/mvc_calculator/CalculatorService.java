package com.example.mvc.mvc_calculator;

public interface CalculatorService {
    int calculator(String num1, String num2, String sign) throws ArithmeticException, NumberFormatException;

}