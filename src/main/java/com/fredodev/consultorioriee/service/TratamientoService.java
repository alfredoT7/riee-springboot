package com.fredodev.consultorioriee.service;

import com.fredodev.consultorioriee.model.Tratamiento;
import com.fredodev.consultorioriee.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

@Service
public class TratamientoService
{
    private final TratamientoRepository tratamientoRepository;

    public TratamientoService(TratamientoRepository tratamientoRepository){
        this.tratamientoRepository=tratamientoRepository;
    }
    public Boolean insertarTratamiento(Tratamiento tratamiento){
        return tratamientoRepository.insertarTratamiento(tratamiento);
    }



}
