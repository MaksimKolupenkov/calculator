package com.example.calculator.repository;

import com.example.calculator.model.entity.OperationResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcRepository extends JpaRepository<OperationResultEntity, Long> {

}
