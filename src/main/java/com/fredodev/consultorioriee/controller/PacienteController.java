package com.fredodev.consultorioriee.controller;

import com.fredodev.consultorioriee.model.Paciente;
import com.fredodev.consultorioriee.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    /**
     * http://localhost:8080/api/pacientes/create
     */
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
    /**
     * http://localhost:8080/api/pacientes/123456
     */

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
    /**
     * http://localhost:8080/api/pacientes/all
     */

    @GetMapping("/all/{pageNumber}")
    public ResponseEntity<Map<String, Object>> getAllPacientesPagination(@PathVariable int pageNumber) {
        Map<String, Object> response = new HashMap<>();
        List<Paciente> pacientes = pacienteService.getAllPacientes(pageNumber);
        int totalPacientes = pacienteService.contarPacientes();
        if (!pacientes.isEmpty()) {
            response.put("pacientes", pacientes);
            response.put("totalPacientes", totalPacientes);
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Pacientes no encontrados");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    /**
     *GET http://localhost:8080/api/pacientes/getAll
     */
    @GetMapping("/getAll")
    public ResponseEntity<Map<String,Object>> getAllPacientes(){
        Map<String,Object> response = new HashMap<>();
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        if(!pacientes.isEmpty()){
            response.put("pacientes", pacientes);
            return ResponseEntity.ok(response);
        }else{
            response.put("error", "Pacientes no encontrados");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



    /**
     * http://localhost:8080/api/pacientes/update
     */
    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> updatePaciente(@RequestBody Paciente paciente) {
        Map<String, String> response = new HashMap<>();
        try {
            boolean updated = pacienteService.updatePaciente(paciente);
            if (updated) {
                response.put("message", "Paciente actualizado exitosamente");
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Paciente no encontrado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("error", "Error al actualizar el paciente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
