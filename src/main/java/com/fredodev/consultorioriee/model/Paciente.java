package com.fredodev.consultorioriee.model;

import lombok.*;
import java.util.Date;

public class Paciente {
    private int ciPaciente;
    private Integer idEstadoCivil;
    private Date fechaNacimiento;
    private String direccion;
    private String ocupacion;
    private String personaDeReferencia;
    private int numeroPersonaRef;
    private String imagen;
    private String nombre;
    private String apellido;

    public Paciente(int ciPaciente, Integer idEstadoCivil, Date fechaNacimiento, String direccion, String ocupacion, String personaDeReferencia, int numeroPersonaRef, String imagen, String nombre, String apellido) {
        this.ciPaciente = ciPaciente;
        this.idEstadoCivil = idEstadoCivil;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.personaDeReferencia = personaDeReferencia;
        this.numeroPersonaRef = numeroPersonaRef;
        this.imagen = imagen;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Paciente(){

    }

    public int getCiPaciente() {
        return ciPaciente;
    }

    public void setCiPaciente(int ciPaciente) {
        this.ciPaciente = ciPaciente;
    }

    public Integer getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Integer idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getPersonaDeReferencia() {
        return personaDeReferencia;
    }

    public void setPersonaDeReferencia(String personaDeReferencia) {
        this.personaDeReferencia = personaDeReferencia;
    }

    public int getNumeroPersonaRef() {
        return numeroPersonaRef;
    }

    public void setNumeroPersonaRef(int numeroPersonaRef) {
        this.numeroPersonaRef = numeroPersonaRef;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "ciPaciente=" + ciPaciente +
                ", idEstadoCivil=" + idEstadoCivil +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion='" + direccion + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", personaDeReferencia='" + personaDeReferencia + '\'' +
                ", numeroPersonaRef=" + numeroPersonaRef +
                ", imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
