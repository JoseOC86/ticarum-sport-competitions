package com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;


public record CompetitionDTO(@JsonIgnore Long id,
                             @Schema(example = "Liga Baloncesto", required = true) @NotBlank String nombre,
                             @Schema(example = "Baloncesto", required = true)@NotBlank String deporte,
                             @Schema(example = "2025-10-18", required = true)@NotNull LocalDate fechaInicio,
                             @Schema(example = "2025-10-20", required = true)@NotNull LocalDate fechaFin,
                             @Schema(example = "1", required = true)@Min(value = 1) @Max(value = 100) int pistasDisponibles,
                             @JsonIgnore Set<TeamDTO> equipos) {
}
