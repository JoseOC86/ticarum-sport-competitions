package com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CompetitionDTO(@JsonIgnore Long id,
                             @NotBlank String nombre,
                             @NotBlank String deporte,
                             @NotNull LocalDate fechaInicio,
                             @NotNull LocalDate fechaFin,
                             @Min(value = 1) @Max(value = 100) int pistasDisponibles) {
}
