package com.jolmos.ticarum.sport.competitions.domain.model;

import java.time.LocalDate;

public class Competicion {

    private Long  id;
    private String nombre;
    private String deporte;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int pistasDisponibles   ;

    public Competicion(Long id, String nombre, String deporte, LocalDate fechaInicio, LocalDate fechaFin, int pistasDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.deporte = deporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pistasDisponibles = pistasDisponibles;
    }

    public Competicion() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPistasDisponibles() {
        return pistasDisponibles;
    }

    public void setPistasDisponibles(int pistasDisponibles) {
        this.pistasDisponibles = pistasDisponibles;
    }
}
