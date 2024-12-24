package com.fredodev.consultorioriee.controller;

import com.fredodev.consultorioriee.model.Paciente;
import com.fredodev.consultorioriee.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createPaciente(@RequestBody Paciente paciente) {
        Map<String, String> response = new HashMap<>();
        try {
            pacienteService.savePaciente(paciente);
            response.put("message", "Paciente creado exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Error al crear el paciente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @GetMapping("/{ciPaciente}")
    public ResponseEntity<Map<String, Object>> getPacienteByCi(@PathVariable int ciPaciente) {
        try {
            Paciente paciente = pacienteService.getPacienteByCi(ciPaciente);
            Map<String, Object> response = new HashMap<>();
            response.put("paciente", paciente);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("error", "Paciente no encontrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllPacientes() {
        Map<String, Object> response = new HashMap<>();
        response.put("pacientes", pacienteService.getAllPacientes());
        return ResponseEntity.ok(response);
    }

}
