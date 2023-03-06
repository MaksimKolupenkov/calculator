package com.example.calculator.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "result")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OperationResultEntity {


    @Id
    @SequenceGenerator(name = "resultSequence", sequenceName = "result_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultSequence")
    private Long id;

    @Column(name = "date_operation")
    private LocalDate date;

    @Column(name = "result_operation")
    private String result;

    @Column(name = "num_one")
    private Double num1;

    @Column(name = "num_two")
    private Double num2;


}
