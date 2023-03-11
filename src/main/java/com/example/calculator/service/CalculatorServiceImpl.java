package com.example.calculator.service;

import com.example.calculator.exception.ErrorMessage;
import com.example.calculator.model.dto.OperationModelDto;
import com.example.calculator.model.entity.OperationResultEntity;
import com.example.calculator.repository.CalcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Base64;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    private CalcRepository calcRepository;

    @Override
    public String mapCalc(OperationModelDto operationModel) {
        String calcResult = new String();
        String operation = operationModel.getOperation();
        OperationResultEntity operationResultEntity = new OperationResultEntity();

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
        }
//        else {
//            calcResult = "Ошибка ввода ";
//        }
//        throw new ErrorMessage("Ошибка ввода, пробуй еще!", HttpStatus.PAYMENT_REQUIRED); не работает

        operationResultEntity.setResult(encode(calcResult));
        operationResultEntity.setNum1(operationModel.getNum1());
        operationResultEntity.setNum2(operationModel.getNum2());

        operationResultEntity.setDate(LocalDate.now());
        calcRepository.save(operationResultEntity);
        return calcResult;
    }

    @Override
    public OperationModelDto getOperation(Long id) {
        OperationResultEntity operationResultEntity = calcRepository.findById(id).get();
        OperationModelDto operationModelDto = new OperationModelDto();
        operationModelDto.setNum1(operationResultEntity.getNum1());
        operationModelDto.setNum2(operationResultEntity.getNum2());
        operationModelDto.setOperation(decoder(operationResultEntity.getResult()));

        return operationModelDto;
    }

    public String encode(String result) {
        Base64.Encoder encoder = Base64.getEncoder();
        String res = encoder.encodeToString(result.getBytes());
        return res;
    }

    public String decoder(String result) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(result);
        String res = new String(decode);
        return res;
    }

}
