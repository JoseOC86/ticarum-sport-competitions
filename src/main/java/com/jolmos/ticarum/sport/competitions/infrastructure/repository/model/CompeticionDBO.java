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

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "deporte", nullable = false)
    private String deporte;
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;
    @Column(name = "pistas_disponibles", nullable = false)
    private int pistasDisponibles;
    @Column(name = "equipos")
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TeamDBO> equipos;

}
