package com.fredodev.consultorioriee.model;

import java.sql.Date;

public class Tratamiento {
    private int idTratamiento;
    private int idTipoTratamiento;
    private int piezaDental;
    private String descripcionHistorial;
    private Date inicioTratamiento;
    private Date finTratamiento;
    private Double precioTotal;
    private Double saldo;
    private boolean tratamientoTerminado;

    public Tratamiento(int idTratamiento, int idTipoTratamiento, int piezaDental, String descripcionHistorial, Date inicioTratamiento, Date finTratamiento,Double precioTotal, Double saldo, boolean tratamientoTerminado) {
        this.idTratamiento = idTratamiento;
        this.idTipoTratamiento = idTipoTratamiento;
        this.piezaDental = piezaDental;
        this.descripcionHistorial = descripcionHistorial;
        this.inicioTratamiento = inicioTratamiento;
        this.finTratamiento = finTratamiento;
        this.precioTotal=precioTotal;
        this.saldo = saldo;
        this.tratamientoTerminado = tratamientoTerminado;
    }
    public Tratamiento(int idTipoTratamiento, int piezaDental, String descripcionHistorial, Date inicioTratamiento, Date finTratamiento,Double precioTotal, Double saldo, boolean tratamientoTerminado) {
        this.idTratamiento = idTratamiento;
        this.idTipoTratamiento = idTipoTratamiento;
        this.piezaDental = piezaDental;
        this.descripcionHistorial = descripcionHistorial;
        this.inicioTratamiento = inicioTratamiento;
        this.finTratamiento = finTratamiento;
        this.precioTotal=precioTotal;
        this.saldo = saldo;
        this.tratamientoTerminado = tratamientoTerminado;
    }
    public Tratamiento(){

    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public int getIdTipoTratamiento() {
        return idTipoTratamiento;
    }

    public void setIdTipoTratamiento(int idTipoTratamiento) {
        this.idTipoTratamiento = idTipoTratamiento;
    }

    public int getPiezaDental() {
        return piezaDental;
    }

    public void setPiezaDental(int piezaDental) {
        this.piezaDental = piezaDental;
    }

    public String getDescripcionHistorial() {
        return descripcionHistorial;
    }

    public void setDescripcionHistorial(String descripcionHistorial) {
        this.descripcionHistorial = descripcionHistorial;
    }

    public Date getInicioTratamiento() {
        return inicioTratamiento;
    }

    public void setInicioTratamiento(Date inicioTratamiento) {
        this.inicioTratamiento = inicioTratamiento;
    }

    public Date getFinTratamiento() {
        return finTratamiento;
    }

    public void setFinTratamiento(Date finTratamiento) {
        this.finTratamiento = finTratamiento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public boolean isTratamientoTerminado() {
        return tratamientoTerminado;
    }

    public void setTratamientoTerminado(boolean tratamientoTerminado) {
        this.tratamientoTerminado = tratamientoTerminado;
    }
}
