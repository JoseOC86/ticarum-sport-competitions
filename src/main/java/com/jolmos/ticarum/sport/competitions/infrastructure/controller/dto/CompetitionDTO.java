package com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto;

import java.time.LocalDate;

public record CompetitionDTO(Long id, String nombre, String deporte, LocalDate fechaInicio, LocalDate fechaFin, int pistasDisponibles) {
}
