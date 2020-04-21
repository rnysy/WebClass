package com.example.caculator;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Caculator {
    @GetMapping("/caculator1")
    public float caculator1(@RequestParam final float num1, @RequestParam final float num2,
            @RequestParam final String operator) {
        float result;

        if(operator.equals("add"))
        result = num1 + num2;
        else if(operator.equals("sub"))
        result = num1 - num2;
        else if(operator.equals("mul"))
        result = num1 * num2;
        else
        result = num1/num2;

        return result;
    }

    @GetMapping("/caculator2/{num1}/{num2}/{operator}")
    public float caculator2(@PathVariable final float num1, @PathVariable final float num2,
            @PathVariable final String operator) {
        float result;

        if(operator.equals("add"))
        result = num1 + num2;
        else if(operator.equals("sub"))
        result = num1 - num2;
        else if(operator.equals("mul"))
        result = num1 * num2;
        else
        result = num1/num2;

        return result;
    }
    }
