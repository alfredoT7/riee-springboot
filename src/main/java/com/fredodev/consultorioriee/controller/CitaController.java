package com.fredodev.consultorioriee.controller;

import com.fredodev.consultorioriee.model.Cita;
import com.fredodev.consultorioriee.service.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
    private final CitaService citaService;

    public CitaController(CitaService citaService){
        this.citaService = citaService;
     }

    @PostMapping("/create")
    public ResponseEntity<Map<String,String>> crearCita(@RequestBody Cita cita){
        Map<String,String> response = new HashMap<>();
        try{
            boolean created = citaService.saveCita(cita);
            if(created){
                response.put("message","Cita creada exitosamente");
                return ResponseEntity.ok(response);
            }else{
                response.put("error","Error al crear la cita");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        }catch (Exception e){
            response.put("error","Error al crear la cita: "+e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
