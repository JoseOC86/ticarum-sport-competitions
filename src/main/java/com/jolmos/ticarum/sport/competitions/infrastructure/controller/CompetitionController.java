package com.jolmos.ticarum.sport.competitions.infrastructure.controller;

import com.jolmos.ticarum.sport.competitions.aplication.usecase.RegistrarCompeticionUseCase;
import com.jolmos.ticarum.sport.competitions.aplication.usecase.RegistrarEquipoUseCase;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.CompetitionDTO;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.TeamDTO;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper.CompetitionDTOMapper;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper.EquipoDTOMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping ("/api/competition")
@RequiredArgsConstructor
public class CompetitionController {

    private final RegistrarCompeticionUseCase registrarCompeticionUseCase;
    private final CompetitionDTOMapper competitionDTOMapper;
    private final EquipoDTOMapper equipoDTOMapper;
    private final RegistrarEquipoUseCase registrarEquipoUseCase;
    @PostMapping
    public ResponseEntity<CompetitionDTO> registrar(@Valid @RequestBody CompetitionDTO competicion) {
        CompetitionDTO competitionDTO = competitionDTOMapper.toCompetitionDTO(this.registrarCompeticionUseCase.execute(this.competitionDTOMapper.toCompeticion(competicion)));
        return ResponseEntity.created(URI.create("/api/competition/" + competitionDTO.id())).body(competitionDTO);
    }

    @PostMapping(path = "/{idCompeticion}/equipo")
    public ResponseEntity<URI> registrarEquipo(@PathVariable @Min(value = 0) Long idCompeticion, @Valid @RequestBody TeamDTO teamDTO) {
        TeamDTO teamDTOResponse = equipoDTOMapper.map(this.registrarEquipoUseCase.execute(this.equipoDTOMapper.map(teamDTO), idCompeticion));;
        return ResponseEntity.created(URI.create("/api/competition/" + idCompeticion + "/equipo/" + teamDTOResponse.id())).build();
    }
}
