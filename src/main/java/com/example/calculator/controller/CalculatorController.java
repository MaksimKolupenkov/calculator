package com.example.calculator.controller;

import com.example.calculator.model.dto.OperationModelDto;
import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate")
    public String getCalc(@Validated @RequestBody OperationModelDto operationModel) {
        return calculatorService.mapCalc(operationModel);
    }

    @GetMapping("/calculate/{id}")
    public @ResponseBody OperationModelDto getOperation(@PathVariable Long id){
        return calculatorService.getOperation(id);
    }

//    @GetMapping("/multiply")
//    public Long multiply(@RequestParam Long num1, @RequestParam Long num2) {
//        return calculatorService(num1.multiplication(num2));
//    }


}
