package com.example.calculator.service;

import com.example.calculator.model.dto.OperationModelDto;
import com.example.calculator.repository.CalcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private CalcRepository calcRepository;

    @Override
    public String calc(OperationModelDto operationModel) {
        String calcResult = new String();
        String operation = operationModel.getOperation();
        if (operation.equals("+")) {
            double v = operationModel.getNum1() + operationModel.getNum2();
            calcResult = String.valueOf(v);
        }
        if (operation.equals("-")) {
            double v = operationModel.getNum1() - operationModel.getNum2();
            calcResult = String.valueOf(v);
        }
        if (operation.equals("*")) {
            double v = operationModel.getNum1() * operationModel.getNum2();
            calcResult = String.valueOf(v);
        }
        if (operation.equals("/") && operationModel.getNum1() != 0 && operationModel.getNum2() != 0) {
            double v = operationModel.getNum1() / operationModel.getNum2();
            calcResult = String.valueOf(v);
        }else{
            calcResult = "Ошибка ввода ";
        }
        return calcResult;
    }

//    @Override
//    public Double division(OperationModelDto operationModel){
//        if(operationModel.getNum1() == 0) return (double) 0;
//        if(operationModel.getNum2() == 0) return (double) 0;
//        return (double) operationModel.getNum1() / operationModel.getNum2();
//    }
//
//    @Override
//    public Long multiplication(OperationModelDto operationModel) {
//        return operationModel.getNum1() * operationModel.getNum2();
//    }
}
