package com.fredodev.consultorioriee.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.sql.Date;

public class Cita {
    private Integer idPaciente;
    private int idCita;
    private Date fechaCita;
    private Time hora;
    private int duracionEstimada;
    private String descripcionCita;

    public Cita(){

    }
    public Cita(Integer idPaciente, int idCita, Date fechaCita, Time hora, int duracionEstimada, String descripcionCita) {
        this.idPaciente = idPaciente;
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.hora = hora;
        this.duracionEstimada = duracionEstimada;
        this.descripcionCita = descripcionCita;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getDescripcionCita() {
        return descripcionCita;
    }

    public void setDescripcionCita(String descripcionCita) {
        this.descripcionCita = descripcionCita;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idPaciente=" + idPaciente +
                ", idCita=" + idCita +
                ", fechaCita=" + fechaCita +
                ", hora=" + hora +
                ", duracionEstimada=" + duracionEstimada +
                ", descripcionCita='" + descripcionCita + '\'' +
                '}';
    }
}
