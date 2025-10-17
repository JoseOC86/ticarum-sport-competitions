package com.jolmos.ticarum.sport.competitions.domain.model;

import java.util.List;
import java.util.Objects;

public class Team {

    private Long id;
    private String nombre;
    private List<Competition> competiciones;


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Team team)) return false;
        return Objects.equals(nombre, team.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
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

    public List<Competition> getCompeticiones() {
        return competiciones;
    }

    public void setCompeticiones(List<Competition> competiciones) {
        this.competiciones = competiciones;
    }
}
