package com.fredodev.consultorioriee.controller;

import com.fredodev.consultorioriee.model.Tratamiento;
import com.fredodev.consultorioriee.service.TratamientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/tratamiento")
public class TratamientoControlller {
    private final TratamientoService tratamientoService;
    public TratamientoControlller(TratamientoService tratamientoService){
        this.tratamientoService=tratamientoService;
    }
    @PostMapping("/insert")
    public ResponseEntity<Map<String,Object>> insertarPaciente(@RequestBody Tratamiento tratamiento){
        Map<String,Object> response = new HashMap<>();
        boolean methods = tratamientoService.insertarTratamiento(tratamiento);
        if(methods){
            response.put("message", "Tratamiento correctamente creado");
            return ResponseEntity.ok(response);
        }else{
            response.put("error","No se logro crear el tratamiento, revisa los datos de los campos");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
