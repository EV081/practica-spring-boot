package com.example.suma.service;

import com.example.suma.domain.repository.SumarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SumarService {
    @Autowired
    private SumarRepository repository;

    public Double sumar(Long a, Long b) {
        if(a < 0 || b < 0) {
            throw new IllegalArgumentException("no pueden ser negativos");

        }
        if(a>1000 || b>1000) {
            throw new ArithmeticException("Los numeros no deben ser mayor a 1000");
        }
        return (double) (a+b);
    }
}
