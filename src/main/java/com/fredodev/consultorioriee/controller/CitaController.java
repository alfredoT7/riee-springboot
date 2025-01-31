package com.fredodev.consultorioriee.controller;

import com.fredodev.consultorioriee.model.Cita;
import com.fredodev.consultorioriee.service.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @GetMapping("/find-cita/{idPaciente}")
    public ResponseEntity<Map<String, Object>> findCitasByPaciente(@PathVariable int idPaciente) {
        Map<String, Object> response = new HashMap<>();
        List<Cita> citas = citaService.findCitasByPaciente(idPaciente);
        if (citas.isEmpty()) {
            response.put("message", "No existen citas para este paciente");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            response.put("citas", citas);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("cita-detalle/{ciPaciente}/{idCita}")
    public ResponseEntity<Map<String, Object>> citaDetail(@PathVariable int ciPaciente, @PathVariable int idCita){
        Map<String, Object> response = new HashMap<>();
        try{
            Cita cita = citaService.findCitaDetail(ciPaciente,idCita);
            if(cita != null){
                response.put("cita", cita);
                return ResponseEntity.ok(response);
            }else{
                response.put("message","Cita no encontrada para ese usuario");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }catch (Exception e ){
            response.put("error","Error al obtener la cita: "+ e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> getFutureAppointment(){
        Map<String, Object> response = new HashMap<>();
        List<Cita> citas = citaService.getFutureAppointment();
        if (citas.isEmpty()){
            response.put("message", "No hay citas futuras");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            response.put("citas", citas);
            return ResponseEntity.ok(response);
        }
    }


}
