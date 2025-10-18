package com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record TeamDTO(@Schema(example = "1", required = false)Long id,
                      @Schema(example = "Jose Team", required = true)@NotBlank String nombre) {
}
