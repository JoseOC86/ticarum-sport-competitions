package com.jolmos.ticarum.sport.competitions.infrastructure.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "competiciones")
@Data
public class CompeticionDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "deporte")
    private String deporte;
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "pistas_disponibles")
    private int pistasDisponibles;
    @Column (name = "equipos")
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TeamDBO> equipos;

}
