package com.jolmos.ticarum.sport.competitions.infrastructure.controller;

import com.jolmos.ticarum.sport.competitions.aplication.usecase.RegistrarCompeticionUseCase;
import com.jolmos.ticarum.sport.competitions.domain.model.Competicion;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.CompetitionDTO;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper.CompetitionDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompetitionController {

    private final RegistrarCompeticionUseCase registrarCompeticionUseCase;
    private final CompetitionDTOMapper competitionDTOMapper;
    public ResponseEntity<Competicion> registrar(CompetitionDTO competicion) {
        return ResponseEntity.created("/competition/" + this.registrarCompeticionUseCase.execute(this.competitionDTOMapper.toCompeticion(competicion)));
    }
}
