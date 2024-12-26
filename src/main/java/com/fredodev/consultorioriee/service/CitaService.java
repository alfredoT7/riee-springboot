package com.fredodev.consultorioriee.service;

import com.fredodev.consultorioriee.model.Cita;
import com.fredodev.consultorioriee.repository.CitaRepository;
import org.springframework.stereotype.Service;

@Service
public class CitaService {
    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public boolean saveCita(Cita cita) {
        return citaRepository.saveCita(cita);
    }


}
