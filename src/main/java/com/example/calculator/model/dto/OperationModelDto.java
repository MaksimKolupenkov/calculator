package com.example.calculator.model.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
public class OperationModelDto {
    @NotNull
    @Digits(integer=6, fraction=2)
    private Double num1;
    @NotNull
    @Digits(integer=6, fraction=2)
    private Double num2;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 1, max = 1)
    private String operation;
}
