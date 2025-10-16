package com.jolmos.ticarum.sport.competitions.infrastructure.controller;

import com.jolmos.ticarum.sport.competitions.aplication.usecase.RegistrarCompeticionUseCase;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.CompetitionDTO;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper.CompetitionDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping ("/api/competition")
@RequiredArgsConstructor
public class CompetitionController {

    private final RegistrarCompeticionUseCase registrarCompeticionUseCase;
    private final CompetitionDTOMapper competitionDTOMapper;

    @PostMapping
    public ResponseEntity<CompetitionDTO> registrar(@Valid @RequestBody CompetitionDTO competicion) {
        CompetitionDTO competitionDTO = competitionDTOMapper.toCompetitionDTO(this.registrarCompeticionUseCase.execute(this.competitionDTOMapper.toCompeticion(competicion)));
        return ResponseEntity.created(URI.create("/api/competition/" + competitionDTO.id())).body(competitionDTO);
    }
}
