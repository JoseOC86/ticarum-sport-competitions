package com.jolmos.ticarum.sport.competitions.infrastructure.controller;

import com.jolmos.ticarum.sport.competitions.application.usecase.FindTeamsByCompetitionUseCase;
import com.jolmos.ticarum.sport.competitions.application.usecase.RegistrarCompeticionUseCase;
import com.jolmos.ticarum.sport.competitions.application.usecase.RegistrarEquipoUseCase;
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
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping ("/api/competition")
@RequiredArgsConstructor
public class CompetitionController {

    private final RegistrarCompeticionUseCase registrarCompeticionUseCase;
    private final CompetitionDTOMapper competitionDTOMapper;
    private final EquipoDTOMapper equipoDTOMapper;
    private final RegistrarEquipoUseCase registrarEquipoUseCase;
    private final FindTeamsByCompetitionUseCase findTeamsByCompetitionUseCase;

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

    @GetMapping (path = "/{idCompeticion}/equipo")
    public ResponseEntity<Set<TeamDTO>> listarEquiposByCompeticion(@PathVariable @Min(value = 0) Long idCompeticion) {
       return ResponseEntity.ok(this.findTeamsByCompetitionUseCase.execute(idCompeticion).stream().map(equipoDTOMapper::map).collect(Collectors.toSet()));
    }
}
