package com.example.calculator.controller;

import com.example.calculator.model.dto.OperationModelDto;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/subtraction")
    public String getCalc(@RequestBody OperationModelDto operationModel) {
        return calculatorService.calc(operationModel);
    }

//    @GetMapping("/multiply")
//    public Long multiply(@RequestParam Long num1, @RequestParam Long num2) {
//        return calculatorService(num1.multiplication(num2));
//    }


}
