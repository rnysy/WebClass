package com.example.mvc.mvc_calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServicempl implements CalculatorService {

    @Override
    public int calculator(String num1, String num2, String sign) {
       int result = 0, number1 = 0, number2 = 0;

       try {
           number1 = Integer.parseInt(num1);
           number2 = Integer.parseInt(num2);
       } catch (NumberFormatException ex){
           throw ex;
       }

       switch(sign){
           case "plus" :
           result = number1 + number2;
           break;
           case "minus" :
           result = number1 - number2;
           break;
           case "multi" :
           result = number1 * number2;
           break;
           case "divide" :
           try {
               result = number1/number2;                           
           } catch (ArithmeticException ex) {
               throw ex;
               
           }
           break;
       }
       return result;
    }

}