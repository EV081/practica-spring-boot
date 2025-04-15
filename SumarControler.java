package com.example.suma.controller;

import com.example.suma.service.SumarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sumar")
public class SumarControler {

    @Autowired
    private SumarService service;

    @GetMapping("/{a}/{b}")
    public ResponseEntity<?> sumar(@PathVariable Long a, @PathVariable Long b) {

        try{
            Double result = service.sumar(a, b);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (ArithmeticException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Error aritmetico: " + e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno inesperado: "+ e.getMessage());
        }
    }
}
