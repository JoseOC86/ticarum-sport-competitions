package com.jolmos.ticarum.sport.competitions.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Competition {

    private Long id;
    private String nombre;
    private String deporte;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int pistasDisponibles;
    private Set<Team> equipos;

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

    public boolean addEquipo(Team equipo) {
        if (this.equipos == null) {
            this.equipos = new HashSet<Team>();
        }
        return this.equipos.add(equipo);
    }

    public Set<Team> getEquipos() {
        return equipos;
    }
}
