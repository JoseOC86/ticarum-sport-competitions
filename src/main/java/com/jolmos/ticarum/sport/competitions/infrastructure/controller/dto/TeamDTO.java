package com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record TeamDTO(@JsonIgnore Long id,
                      @NotBlank String nombre,
                      List<CompetitionDTO> competiciones) {
}
