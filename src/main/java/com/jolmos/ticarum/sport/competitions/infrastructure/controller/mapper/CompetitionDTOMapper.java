package com.jolmos.ticarum.sport.competitions.infrastructure.controller.mapper;

import com.jolmos.ticarum.sport.competitions.domain.model.Competition;
import com.jolmos.ticarum.sport.competitions.infrastructure.controller.dto.CompetitionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompetitionDTOMapper {

    private final EquipoDTOMapper equipoDTOMapper;

    public CompetitionDTO toCompetitionDTO(Competition competition) {
        return new CompetitionDTO(competition.getId(), competition.getNombre(), competition.getDeporte(), competition.getFechaInicio(), competition.getFechaFin(), competition.getPistasDisponibles(), competition.getEquipos().stream().map(equipoDTOMapper::map).collect(Collectors.toSet()) );

    }

    public Competition toCompeticion(CompetitionDTO competitionDTO) {

        Competition competition = new Competition();
        competition.setId(competitionDTO.id());
        competition.setNombre(competitionDTO.nombre());
        competition.setDeporte(competitionDTO.deporte());
        competition.setFechaInicio(competitionDTO.fechaInicio());
        competition.setFechaFin(competitionDTO.fechaFin());
        competition.setPistasDisponibles(competitionDTO.pistasDisponibles());
        return competition;

    }
}
