package com.fredodev.consultorioriee.service;

import com.fredodev.consultorioriee.model.Paciente;
import com.fredodev.consultorioriee.repository.PacienteRepository;
import org.springframework.stereotype.Service;

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

}
