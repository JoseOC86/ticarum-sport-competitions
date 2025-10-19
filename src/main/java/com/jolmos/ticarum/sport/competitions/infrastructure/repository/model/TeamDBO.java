package com.jolmos.ticarum.sport.competitions.infrastructure.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "equipos")
@Data
public class TeamDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", unique = true,  nullable = false)
    private String nombre;
    @Column(name = "competiciones")
    @ManyToMany(mappedBy = "equipos")
    private List<CompeticionDBO> competiciones;


}
