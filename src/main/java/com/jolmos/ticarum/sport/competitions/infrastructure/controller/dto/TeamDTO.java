package com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record TeamDTO(Long id,
                      @NotBlank String nombre) {
}
