package com.example.calculator.service;

import com.example.calculator.model.dto.OperationModelDto;

public interface CalculatorService {

    String mapCalc(OperationModelDto operationModel);
    OperationModelDto getOperation(Long id);

}
