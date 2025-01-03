package com.fredodev.consultorioriee.service;

import com.fredodev.consultorioriee.model.Paciente;
import com.fredodev.consultorioriee.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void savePaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }
    public Paciente getPacienteByCi(int ciPaciente) {
        return pacienteRepository.findByCiPaciente(ciPaciente);
    }
    public List<Paciente> getAllPacientes(int pageNumber) {
        return pacienteRepository.findAll(pageNumber);
    }
    public List<Paciente> getAllPacientes(){
        return pacienteRepository.findAll();
    }
    public boolean updatePaciente(Paciente paciente) {
        return pacienteRepository.update(paciente);
    }
    public int contarPacientes() {
        return pacienteRepository.contarPacientes();
    }
}
